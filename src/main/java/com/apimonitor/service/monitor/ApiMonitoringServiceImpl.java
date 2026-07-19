package com.apimonitor.service.monitor;

import com.apimonitor.entity.ApiEndpoint;
import com.apimonitor.entity.MonitoringLog;
import com.apimonitor.repository.ApiEndpointRepository;
import com.apimonitor.repository.MonitoringLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@Service
public class ApiMonitoringServiceImpl
        implements ApiMonitoringService {

    private final ApiEndpointRepository apiRepository;
    private final MonitoringLogRepository logRepository;

    private final RestTemplate restTemplate =
            new RestTemplate();

    public ApiMonitoringServiceImpl(
            ApiEndpointRepository apiRepository,
            MonitoringLogRepository logRepository) {

        this.apiRepository = apiRepository;
        this.logRepository = logRepository;
    }

    @Override
    @Scheduled(fixedDelay = 60000)
        public void monitorApis() {
            System.out.println("Monitoring started...");
            for (ApiEndpoint api : apiRepository.findByIsActiveTrue()) {
                System.out.println("Checking : " + api.getUrl());
                MonitoringLog log = new MonitoringLog();

                log.setApiEndpoint(api);
                log.setCheckedAt(LocalDateTime.now());
                long start = System.currentTimeMillis();

                try {

                    ResponseEntity<String> response =
                            restTemplate.getForEntity(
                                    api.getUrl(),
                                    String.class);

                    long end = System.currentTimeMillis();

                    log.setStatusCode(response.getStatusCode().value());

                    log.setResponseTimeMs(end - start);

                    if (response.getStatusCode().value()
                            == api.getExpectedStatusCode()) {

                        log.setStatus("UP");

                    } else {

                        log.setStatus("DOWN");

                        log.setErrorMessage(
                                "Unexpected Status Code");

                    }

                }

                catch (Exception e) {
                    long end = System.currentTimeMillis();
                    log.setStatus("DOWN");
                    log.setResponseTimeMs(end - start);
                    log.setErrorMessage(e.getMessage());
                    e.printStackTrace();

                }

                logRepository.save(log);

            }

        }

}