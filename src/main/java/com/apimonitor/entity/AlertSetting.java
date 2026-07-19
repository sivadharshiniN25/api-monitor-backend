package com.apimonitor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_settings")
public class AlertSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "api_endpoint_id", nullable = false, unique = true)
    private ApiEndpoint apiEndpoint;

    private String notifyEmail;

    @Column(nullable = false)
    private Boolean isEnabled = true;

    public AlertSetting() {
    }

    public AlertSetting(Long id, ApiEndpoint apiEndpoint,
                        String notifyEmail,
                        Boolean isEnabled) {
        this.id = id;
        this.apiEndpoint = apiEndpoint;
        this.notifyEmail = notifyEmail;
        this.isEnabled = isEnabled;
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

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail=notifyEmail;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isEnabled=enabled;
    }
}