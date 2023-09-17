package com.example.resourcesmanager.service;

import com.example.resourcesmanager.dto.UserDto;
import com.example.resourcesmanager.mapper.UserMapper;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.model.UserType;
import com.example.resourcesmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User addUser(UserDto userDto){
        User user = UserMapper.userDtoToUser(userDto);
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(new Function<User, UserDto>() {
                    @Override
                    public UserDto apply(User user) {
                        return UserMapper.userToUserDto(user);
                    }
                })
                .toList();

    }

    public User editNickname(Long userid, String newNickname) {
        Optional<User> existingUser = Optional.of(userRepository.findById(userid).orElseThrow());
        User userEntity = existingUser.get();
        userEntity.setDateOfUpdate(LocalDateTime.now());
        userEntity.setNickname(newNickname);
        return userRepository.save(userEntity);
    }


    public boolean isUserSuperUser(String username){
        Optional<User> user = userRepository.findByName(username);
        return user.isPresent() && user.get().getUserType().equals(UserType.SUPER_USER);
    }


}
