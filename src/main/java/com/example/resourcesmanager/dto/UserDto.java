package com.example.resourcesmanager.dto;

import com.example.resourcesmanager.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;
    String name;
    String lastname;
    String nickname;
    LocalDateTime dateOfCreate;
    LocalDateTime dateOfUpdate;
    UserType userType;
}
