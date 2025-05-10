package com.example.orderingsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
    LocalDateTime created_at;
    LocalDateTime updated_at;
    LocalDateTime last_login;
    Boolean is_active;
    Boolean is_admin;
}
