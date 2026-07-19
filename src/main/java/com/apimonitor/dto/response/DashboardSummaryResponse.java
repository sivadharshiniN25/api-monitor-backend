package com.apimonitor.dto.response;

public class DashboardSummaryResponse {

    private Long totalApis;
    private Long upApis;
    private Long downApis;
    private Long activeIncidents;
    private Double averageResponseTime;

    public DashboardSummaryResponse() {
    }

    public DashboardSummaryResponse(Long totalApis,
                                    Long upApis,
                                    Long downApis,
                                    Long activeIncidents,
                                    Double averageResponseTime) {

        this.totalApis = totalApis;
        this.upApis = upApis;
        this.downApis = downApis;
        this.activeIncidents = activeIncidents;
        this.averageResponseTime = averageResponseTime;
    }

    // Generate getters and setters

    public Long getTotalApis() {
        return totalApis;
    }

    public void setTotalApis(Long totalApis) {
        this.totalApis = totalApis;
    }

    public Long getUpApis() {
        return upApis;
    }

    public void setUpApis(Long upApis) {
        this.upApis = upApis;
    }

    public Long getDownApis() {
        return downApis;
    }

    public void setDownApis(Long downApis) {
        this.downApis = downApis;
    }

    public Long getActiveIncidents() {
        return activeIncidents;
    }

    public void setActiveIncidents(Long activeIncidents) {
        this.activeIncidents = activeIncidents;
    }

    public Double getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(Double averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }
}