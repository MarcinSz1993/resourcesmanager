package com.example.resourcesmanager.service;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.exception.NoPermissionException;
import com.example.resourcesmanager.mapper.UserMapper;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.model.UserType;
import com.example.resourcesmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User addUser(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDto> getUsers(String username) {
        if (!isSuperUser(username)) {
            throw new NoPermissionException();
        }

        return userRepository.findAll().stream()
                .map(UserMapper::toUserDto)
                .toList();
    }

    public User editNickname(Long userid, String newNickname) {
        Optional<User> existingUser = Optional.of(userRepository.findById(userid).orElseThrow());
        User userEntity = existingUser.get();
        userEntity.setDateOfUpdate(LocalDateTime.now());
        userEntity.setNickName(newNickname);
        return userRepository.save(userEntity);
    }


    public boolean isSuperUser(String username) {
        Optional<User> user = userRepository.findByName(username);
        return user.isPresent() && user.get().getUserType().equals(UserType.SUPER_USER);
    }


}
