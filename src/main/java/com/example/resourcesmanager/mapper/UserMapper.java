package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.model.User;

import java.time.LocalDateTime;
public class UserMapper {
    public static UserDto userToUserDto(User user){
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



//    public static User userDtoToUser(UserDto userDto){
//        return new User(
//                userDto.getId(),
//                userDto.getName(),
//                userDto.getLastname(),
//                userDto.getNickname(),
//                userDto.getDateOfCreate(),
//                userDto.getDateOfUpdate(),
//                userDto.getUserType());
//    }

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setNickname(userDto.getNickname());
        user.setDateOfCreate(LocalDateTime.now());
        user.setDateOfUpdate(userDto.getDateOfUpdate());
        user.setUserType(userDto.getUserType());
        return user;
    }
}
