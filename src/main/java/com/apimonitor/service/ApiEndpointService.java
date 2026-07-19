package com.apimonitor.service;

import com.apimonitor.dto.request.ApiEndpointRequest;
import com.apimonitor.dto.response.ApiEndpointResponse;

import java.util.List;

public interface ApiEndpointService {

    ApiEndpointResponse create(ApiEndpointRequest request);

    List<ApiEndpointResponse> getAll();

    ApiEndpointResponse getById(Long id);

    ApiEndpointResponse update(Long id, ApiEndpointRequest request);

    void delete(Long id);
}