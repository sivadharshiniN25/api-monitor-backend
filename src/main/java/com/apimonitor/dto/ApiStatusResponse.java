package com.apimonitor.dto;

import java.time.LocalDateTime;

public class ApiStatusResponse {

    private Long id;
    private String name;
    private String url;
    private String status;
    private Integer statusCode;
    private Long responseTimeMs;
    private LocalDateTime lastChecked;

    public ApiStatusResponse() {
    }

    public ApiStatusResponse(Long id,
                             String name,
                             String url,
                             String status,
                             Integer statusCode,
                             Long responseTimeMs,
                             LocalDateTime lastChecked) {

        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.statusCode = statusCode;
        this.responseTimeMs = responseTimeMs;
        this.lastChecked = lastChecked;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Long getResponseTimeMs() {
        return responseTimeMs;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setResponseTimeMs(Long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }
}