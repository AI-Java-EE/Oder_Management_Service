package com.aga.demo.user.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String password;
}
