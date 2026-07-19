package com.apimonitor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "monitoring_logs")
public class MonitoringLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "api_endpoint_id", nullable = false)
    private ApiEndpoint apiEndpoint;

    @Column(nullable = false)
    private String status;

    private Integer statusCode;

    private Long responseTimeMs;

    @Column(columnDefinition = "TEXT")
    private String errorMessage;

    @Column(nullable =false)
    private LocalDateTime checkedAt = LocalDateTime.now();

    public MonitoringLog() {
    }

    public MonitoringLog(Long id,
                         ApiEndpoint apiEndpoint,
                         String status,
                         Integer statusCode,
                         Long responseTimeMs,
                         String errorMessage,
                         LocalDateTime checkedAt) {
        this.id = id;
        this.apiEndpoint = apiEndpoint;
        this.status = status;
        this.statusCode = statusCode;
        this.responseTimeMs = responseTimeMs;
        this.errorMessage = errorMessage;
        this.checkedAt = checkedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public ApiEndpoint getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(ApiEndpoint apiEndpoint) {
        this.apiEndpoint=apiEndpoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode=statusCode;
    }

    public Long getResponseTimeMs() {
        return responseTimeMs;
    }

    public void setResponseTimeMs(Long responseTimeMs) {
        this.responseTimeMs=responseTimeMs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage=errorMessage;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt=checkedAt;
    }
}