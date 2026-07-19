package com.apimonitor.dto.response;

import java.time.LocalDateTime;

public class IncidentResponse {

    private LocalDateTime startedAt;
    private LocalDateTime resolvedAt;
    private Long durationSeconds;
    private Boolean isResolved;

    public IncidentResponse() {
    }

    public IncidentResponse(LocalDateTime startedAt,
                            LocalDateTime resolvedAt,
                            Long durationSeconds,
                            Boolean isResolved) {
        this.startedAt = startedAt;
        this.resolvedAt = resolvedAt;
        this.durationSeconds = durationSeconds;
        this.isResolved = isResolved;
    }

    // Generate getters and setters

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Boolean getResolved() {
        return isResolved;
    }

    public void setResolved(Boolean resolved) {
        isResolved = resolved;
    }
}