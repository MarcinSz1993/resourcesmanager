package com.example.resourcesmanager.controller;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/{id}")
    public User editNickName(@PathVariable Long id, @RequestBody String newNickName){
        return userService.editNickname(id,newNickName);
    }

    @GetMapping
    public List<UserDto> getUsers(@RequestHeader("Username") String username) {
        return userService.getUsers(username);
    }
}
