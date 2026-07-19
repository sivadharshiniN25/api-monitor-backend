package com.apimonitor.service.impl;

import com.apimonitor.config.SecurityUtils;
import com.apimonitor.dto.request.ApiEndpointRequest;
import com.apimonitor.dto.response.ApiEndpointResponse;
import com.apimonitor.entity.ApiEndpoint;
import com.apimonitor.entity.User;
import com.apimonitor.repository.ApiEndpointRepository;
import com.apimonitor.repository.UserRepository;
import com.apimonitor.service.ApiEndpointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiEndpointServiceImpl implements ApiEndpointService {

    private final ApiEndpointRepository apiEndpointRepository;
    private final UserRepository userRepository;

    public ApiEndpointServiceImpl(ApiEndpointRepository apiEndpointRepository,
                                  UserRepository userRepository) {

        this.apiEndpointRepository = apiEndpointRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiEndpointResponse create(ApiEndpointRequest request) {

        String email = SecurityUtils.getCurrentUserEmail();

        User owner = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ApiEndpoint endpoint = new ApiEndpoint();

        endpoint.setName(request.getName());
        endpoint.setUrl(request.getUrl());
        endpoint.setHttpMethod(request.getHttpMethod());
        endpoint.setExpectedStatusCode(request.getExpectedStatusCode());
        endpoint.setCheckIntervalSeconds(request.getCheckIntervalSeconds());
        endpoint.setIsActive(true);
        endpoint.setOwner(owner);

        endpoint = apiEndpointRepository.save(endpoint);

        return map(endpoint);
    }

    @Override
    public List<ApiEndpointResponse> getAll() {

        String email = SecurityUtils.getCurrentUserEmail();

        User owner = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return apiEndpointRepository.findByOwnerId(owner.getId())
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public ApiEndpointResponse getById(Long id) {

        ApiEndpoint endpoint = apiEndpointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endpoint not found"));

        return map(endpoint);
    }

    @Override
    public ApiEndpointResponse update(Long id,
                                      ApiEndpointRequest request) {

        ApiEndpoint endpoint = apiEndpointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endpoint not found"));

        endpoint.setName(request.getName());
        endpoint.setUrl(request.getUrl());
        endpoint.setHttpMethod(request.getHttpMethod());
        endpoint.setExpectedStatusCode(request.getExpectedStatusCode());
        endpoint.setCheckIntervalSeconds(request.getCheckIntervalSeconds());

        endpoint = apiEndpointRepository.save(endpoint);

        return map(endpoint);
    }

    @Override
    public void delete(Long id) {

        ApiEndpoint endpoint = apiEndpointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endpoint not found"));

        apiEndpointRepository.delete(endpoint);
    }

    private ApiEndpointResponse map(ApiEndpoint endpoint) {

        return new ApiEndpointResponse(
                endpoint.getId(),
                endpoint.getName(),
                endpoint.getUrl(),
                endpoint.getHttpMethod(),
                endpoint.getExpectedStatusCode(),
                endpoint.getCheckIntervalSeconds(),
                endpoint.getIsActive(),
                endpoint.getCreatedAt()
        );
    }
}