package com.apimonitor.controller;

import com.apimonitor.dto.request.ApiEndpointRequest;
import com.apimonitor.dto.response.ApiEndpointResponse;
import com.apimonitor.service.ApiEndpointService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endpoints")
@CrossOrigin("*")
public class ApiEndpointController {

    private final ApiEndpointService apiEndpointService;

    public ApiEndpointController(ApiEndpointService apiEndpointService) {
        this.apiEndpointService = apiEndpointService;
    }

    @PostMapping
    public ApiEndpointResponse create(@Valid @RequestBody ApiEndpointRequest request) {
        return apiEndpointService.create(request);
    }

    @GetMapping
    public List<ApiEndpointResponse> getAll() {
        return apiEndpointService.getAll();
    }

    @GetMapping("/{id}")
    public ApiEndpointResponse getById(@PathVariable Long id) {
        return apiEndpointService.getById(id);
    }

    @PutMapping("/{id}")
    public ApiEndpointResponse update(@PathVariable Long id,
                                      @Valid @RequestBody ApiEndpointRequest request) {
        return apiEndpointService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        apiEndpointService.delete(id);
        return "Endpoint Deleted Successfully";
    }
}