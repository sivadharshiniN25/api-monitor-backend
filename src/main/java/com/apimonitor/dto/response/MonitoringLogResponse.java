package com.apimonitor.dto.response;

import java.time.LocalDateTime;

public class MonitoringLogResponse {

    private String status;
    private Integer statusCode;
    private Long responseTimeMs;
    private String errorMessage;
    private LocalDateTime checkedAt;

    public MonitoringLogResponse() {
    }

    public MonitoringLogResponse(String status,
                                 Integer statusCode,
                                 Long responseTimeMs,
                                 String errorMessage,
                                 LocalDateTime checkedAt) {
        this.status = status;
        this.statusCode = statusCode;
        this.responseTimeMs = responseTimeMs;
        this.errorMessage = errorMessage;
        this.checkedAt = checkedAt;
    }

    // Generate getters and setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Long getResponseTimeMs() {
        return responseTimeMs;
    }

    public void setResponseTimeMs(Long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}