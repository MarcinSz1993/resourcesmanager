package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.model.User;
import java.time.LocalDateTime;
import java.util.Collections;


public class UserMapper {
    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastName())
                .nickname(user.getNickName())
                .dateOfCreate(LocalDateTime.now())
                .dateOfUpdate(user.getDateOfUpdate())
                .userType(user.getUserType())
                .build();
    }
    public static User userDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .lastName(userDto.getLastname())
                .nickName(userDto.getNickname())
                .dateOfCreate(LocalDateTime.now())
                .dateOfUpdate(userDto.getDateOfUpdate())
                .userType(userDto.getUserType())
                .resources(Collections.emptyList())
                .build();


    }

}
