package com.apimonitor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_endpoints")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApiEndpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String httpMethod = "GET";

    @Column(nullable = false)
    private Integer expectedStatusCode = 200;

    @Column(nullable = false)
    private Integer checkIntervalSeconds = 60;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    public ApiEndpoint() {
    }

    public ApiEndpoint(Long id, String name, String url,
                       String httpMethod,
                       Integer expectedStatusCode,
                       Integer checkIntervalSeconds,
                       Boolean isActive,
                       LocalDateTime createdAt,
                       User owner) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.httpMethod = httpMethod;
        this.expectedStatusCode = expectedStatusCode;
        this.checkIntervalSeconds = checkIntervalSeconds;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url=url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod=httpMethod;
    }

    public Integer getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(Integer expectedStatusCode) {
        this.expectedStatusCode=expectedStatusCode;
    }

    public Integer getCheckIntervalSeconds() {
        return checkIntervalSeconds;
    }

    public void setCheckIntervalSeconds(Integer checkIntervalSeconds) {
        this.checkIntervalSeconds=checkIntervalSeconds;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive=active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt=createdAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner=owner;
    }
}