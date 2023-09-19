package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.model.User;

import java.time.LocalDateTime;
import java.util.Collections;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getNickname(),
                LocalDateTime.now(),
                user.getDateOfUpdate(),
                user.getUserType()
        );
    }


// Mappery przerobić na buildera @Builder w lomboku. Doczytać.
    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getNickname(),
                userDto.getDateOfCreate(),
                userDto.getDateOfUpdate(),
                userDto.getUserType(),
                Collections.emptyList());
    }

}
