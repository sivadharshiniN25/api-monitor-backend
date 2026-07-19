package com.apimonitor.repository;

import com.apimonitor.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    Optional<Incident> findByApiEndpointIdAndIsResolvedFalse(Long apiId);

    List<Incident> findByApiEndpointIdOrderByStartedAtDesc(Long apiId);

    List<Incident> findByIsResolvedFalse();

}