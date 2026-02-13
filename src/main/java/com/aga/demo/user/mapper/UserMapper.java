package com.aga.demo.user.mapper;

import com.aga.demo.user.dto.UserResponse;
import com.aga.demo.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
