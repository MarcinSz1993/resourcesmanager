package com.example.resourcesmanager.dto;

import com.example.resourcesmanager.model.UserType;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    Long id;
    String name;
    String lastname;
    String nickname;
    LocalDateTime dateOfCreate;
    LocalDateTime dateOfUpdate;
    UserType userType;
}
