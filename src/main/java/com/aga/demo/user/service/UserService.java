package com.aga.demo.user.service;

import com.aga.demo.user.dto.CreateUserRequest;
import com.aga.demo.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(CreateUserRequest request);
    UserResponse getById(String id);
    List<UserResponse> list();
}
