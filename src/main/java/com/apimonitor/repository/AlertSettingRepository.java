package com.apimonitor.repository;

import com.apimonitor.entity.AlertSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertSettingRepository extends JpaRepository<AlertSetting, Long> {

    Optional<AlertSetting> findByApiEndpointId(Long apiId);

}