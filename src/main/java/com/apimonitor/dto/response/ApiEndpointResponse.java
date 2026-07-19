package com.apimonitor.dto.response;

import java.time.LocalDateTime;

public class ApiEndpointResponse {

    private Long id;
    private String name;
    private String url;
    private String httpMethod;
    private Integer expectedStatusCode;
    private Integer checkIntervalSeconds;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public ApiEndpointResponse() {
    }

    public ApiEndpointResponse(Long id,
                               String name,
                               String url,
                               String httpMethod,
                               Integer expectedStatusCode,
                               Integer checkIntervalSeconds,
                               Boolean isActive,
                               LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.httpMethod = httpMethod;
        this.expectedStatusCode = expectedStatusCode;
        this.checkIntervalSeconds = checkIntervalSeconds;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    // Generate getters and setters using IntelliJ

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Integer getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(Integer expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public Integer getCheckIntervalSeconds() {
        return checkIntervalSeconds;
    }

    public void setCheckIntervalSeconds(Integer checkIntervalSeconds) {
        this.checkIntervalSeconds = checkIntervalSeconds;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}