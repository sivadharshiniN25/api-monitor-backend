package com.apimonitor.repository;

import com.apimonitor.entity.ApiEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiEndpointRepository extends JpaRepository<ApiEndpoint, Long> {

    List<ApiEndpoint> findByIsActiveTrue();

    List<ApiEndpoint> findByOwnerId(Long ownerId);

}