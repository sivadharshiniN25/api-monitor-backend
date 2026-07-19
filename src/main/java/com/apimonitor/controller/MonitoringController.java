package com.apimonitor.controller;

import com.apimonitor.dto.ApiStatusResponse;
import com.apimonitor.dto.DashboardResponse;
import com.apimonitor.entity.ApiEndpoint;
import com.apimonitor.entity.MonitoringLog;
import com.apimonitor.repository.ApiEndpointRepository;
import com.apimonitor.repository.MonitoringLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MonitoringController {

    private final MonitoringLogRepository logRepository;
    private final ApiEndpointRepository apiRepository;

    public MonitoringController(
            MonitoringLogRepository logRepository,
            ApiEndpointRepository apiRepository) {

        this.logRepository = logRepository;
        this.apiRepository = apiRepository;
    }

    @GetMapping("/logs/{apiId}")
    public List<MonitoringLog> history(
            @PathVariable Long apiId) {
        System.out.println("===== HISTORY API HIT =====");
        return logRepository.findTop100ByApiEndpointIdOrderByCheckedAtDesc(apiId);
    }

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {

        long totalApis = apiRepository.count();

        long activeApis =
                apiRepository.findByIsActiveTrue().size();

        long up = 0;
        long down = 0;

        for (ApiEndpoint api : apiRepository.findAll()) {

            var latest =
                    logRepository.findTop1ByApiEndpointIdOrderByCheckedAtDesc(api.getId());

            if (latest.isPresent()) {

                if ("UP".equalsIgnoreCase(latest.get().getStatus())) {
                    up++;
                } else {
                    down++;
                }
            }
        }

        return new DashboardResponse(
                totalApis,
                activeApis,
                up,
                down,
                logRepository.count()
        );
    }

    @GetMapping("/status")
    public List<ApiStatusResponse> currentStatus() {

        List<ApiStatusResponse> response =
                new ArrayList<>();

        for (ApiEndpoint api : apiRepository.findAll()) {

            var latest =
                    logRepository.findTop1ByApiEndpointIdOrderByCheckedAtDesc(api.getId());

            if (latest.isPresent()) {

                MonitoringLog log = latest.get();

                response.add(

                        new ApiStatusResponse(

                                api.getId(),

                                api.getName(),

                                api.getUrl(),

                                log.getStatus(),

                                log.getStatusCode(),

                                log.getResponseTimeMs(),

                                log.getCheckedAt()

                        )

                );

            }

        }

        return response;
    }

}