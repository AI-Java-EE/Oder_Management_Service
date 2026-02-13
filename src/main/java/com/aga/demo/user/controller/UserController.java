package com.aga.demo.user.controller;

import com.aga.demo.user.dto.CreateUserRequest;
import com.aga.demo.user.dto.UserResponse;
import com.aga.demo.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection (best practice
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> list() {
        return userService.list();
    }
}
