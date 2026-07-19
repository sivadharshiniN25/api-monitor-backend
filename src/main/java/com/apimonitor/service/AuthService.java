package com.apimonitor.service;

import com.apimonitor.dto.request.LoginRequest;
import com.apimonitor.dto.request.RegisterRequest;
import com.apimonitor.dto.response.LoginResponse;

public interface AuthService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}