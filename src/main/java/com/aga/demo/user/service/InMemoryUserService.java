package com.aga.demo.user.service;

import com.aga.demo.user.dto.CreateUserRequest;
import com.aga.demo.user.dto.UserResponse;
import com.aga.demo.user.entity.User;
import com.aga.demo.user.exception.DuplicateEmailException;
import com.aga.demo.user.exception.UserNotFoundException;
import com.aga.demo.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class InMemoryUserService implements UserService {
    private final UserMapper userMapper;

    private final Map<String, User> store = new ConcurrentHashMap<>();

    @Override
    public UserResponse create(CreateUserRequest request) {
        boolean exists = store.values().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(request.email()));
        if (exists) {
            throw new DuplicateEmailException(request.email());
        }
        String id = UUID.randomUUID().toString();
        UserResponse userResponse = new UserResponse(id, request.name(), request.email());
        // ✅ password is STORED internally
        User user = new User(
                id,
                request.name(),
                request.email(),
                request.password() // stored here
        );
        store.put(id, user);
        return userResponse;
    }

    @Override
    public UserResponse getById(String id) {
        User user = store.get(id);
        System.out.println("User: " + user);
        if (user == null) throw new UserNotFoundException(id);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public List<UserResponse> list() {
        return store
                .values()
                .stream()
                .peek(user -> System.out.println(
                        "User in memory BEFORE toResponse -> " +
                                "id=" + user.getId() +
                                ", name=" + user.getName() +
                                ", email=" + user.getEmail() +
                                ", password=" + user.getPassword()
                ))
                .map(userMapper::toResponse)
                .toList();
    }
}