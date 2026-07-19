package com.apimonitor.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ApiEndpointRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    @NotBlank
    private String httpMethod;

    @NotNull
    private Integer expectedStatusCode;

    @Min(10)
    private Integer checkIntervalSeconds;

    public ApiEndpointRequest() {
    }

    public ApiEndpointRequest(String name,
                              String url,
                              String httpMethod,
                              Integer expectedStatusCode,
                              Integer checkIntervalSeconds) {

        this.name = name;
        this.url = url;
        this.httpMethod = httpMethod;
        this.expectedStatusCode = expectedStatusCode;
        this.checkIntervalSeconds = checkIntervalSeconds;
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
}