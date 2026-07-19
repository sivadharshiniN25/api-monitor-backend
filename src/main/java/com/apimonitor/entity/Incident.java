package com.apimonitor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "api_endpoint_id", nullable = false)
    private ApiEndpoint apiEndpoint;

    @Column(nullable = false)
    private LocalDateTime startedAt = LocalDateTime.now();

    private LocalDateTime resolvedAt;

    private Long durationSeconds;

    @Column(nullable = false)
    private Boolean isResolved = false;

    public Incident() {
    }

    public Incident(Long id, ApiEndpoint apiEndpoint, LocalDateTime startedAt,
                    LocalDateTime resolvedAt, Long durationSeconds,
                    Boolean isResolved) {
        this.id = id;
        this.apiEndpoint = apiEndpoint;
        this.startedAt = startedAt;
        this.resolvedAt = resolvedAt;
        this.durationSeconds = durationSeconds;
        this.isResolved = isResolved;
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

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt=startedAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt=resolvedAt;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds=durationSeconds;
    }

    public Boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(Boolean resolved) {
        isResolved=resolved;
    }
}