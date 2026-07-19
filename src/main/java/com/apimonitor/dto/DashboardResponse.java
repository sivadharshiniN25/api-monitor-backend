package com.apimonitor.dto;

public class DashboardResponse {

    private long totalApis;
    private long activeApis;
    private long upApis;
    private long downApis;
    private long totalLogs;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalApis,
                             long activeApis,
                             long upApis,
                             long downApis,
                             long totalLogs) {

        this.totalApis = totalApis;
        this.activeApis = activeApis;
        this.upApis = upApis;
        this.downApis = downApis;
        this.totalLogs = totalLogs;
    }

    public long getTotalApis() {
        return totalApis;
    }

    public void setTotalApis(long totalApis) {
        this.totalApis = totalApis;
    }

    public long getActiveApis() {
        return activeApis;
    }

    public void setActiveApis(long activeApis) {
        this.activeApis = activeApis;
    }

    public long getUpApis() {
        return upApis;
    }

    public void setUpApis(long upApis) {
        this.upApis = upApis;
    }

    public long getDownApis() {
        return downApis;
    }

    public void setDownApis(long downApis) {
        this.downApis = downApis;
    }

    public long getTotalLogs() {
        return totalLogs;
    }

    public void setTotalLogs(long totalLogs) {
        this.totalLogs = totalLogs;
    }
}