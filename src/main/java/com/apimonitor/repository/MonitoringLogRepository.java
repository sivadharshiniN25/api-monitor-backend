package com.apimonitor.repository;

import com.apimonitor.entity.MonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MonitoringLogRepository extends JpaRepository<MonitoringLog, Long> {

    List<MonitoringLog> findTop100ByApiEndpointIdOrderByCheckedAtDesc(Long apiId);

    List<MonitoringLog> findByApiEndpointIdAndCheckedAtAfter(Long apiId,
                                                             LocalDateTime since);

    Optional<MonitoringLog> findTop1ByApiEndpointIdOrderByCheckedAtDesc(Long apiId);

}