package com.example.resourcesmanager.controller;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid){
        userService.deleteUser(userid);
    }

    @PutMapping("/editNickname/{id}")
    public User editNickname(@PathVariable Long id, @RequestBody String newNickname){
        return userService.editNickname(id,newNickname);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestHeader("Username") String username) {
        if (userService.isUserSuperUser(username)) {
            return userService.getUsers();
        } else
            return Collections.emptyList();
    }
}
