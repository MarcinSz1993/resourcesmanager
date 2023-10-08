package com.example.resourcesmanager.service;

import com.example.resourcesmanager.exception.InvalidDataException;
import com.example.resourcesmanager.exception.UserNotFoundException;
import com.example.resourcesmanager.mapper.ResourceMapper;
import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.repository.ResourceRepository;
import com.example.resourcesmanager.repository.UserRepository;
import com.example.resourcesmanager.request.ResourceRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public Resource addResource(ResourceRequest resourceRequest,String username) {
        Optional<User> byName = userRepository.findByName(username);
        Long userId = byName.map(new Function<User, Long>() {
            @Override
            public Long apply(User user) {
                return user.getId();
            }
        }).orElseThrow(new Supplier<UserNotFoundException>() {
            @Override
            public UserNotFoundException get() {
                return new UserNotFoundException(username);
            }
        });
        Resource resource = ResourceMapper.toEntity(resourceRequest, userId);
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long fileid){
        resourceRepository.deleteById(fileid);
    }

    @Transactional
    public Resource editResourceName(Long resourceId, String newResourcename) {
        Resource editedResource = resourceRepository.findById(resourceId).orElseThrow(new Supplier<InvalidDataException>() {
            @Override
            public InvalidDataException get() {
                return new InvalidDataException("There is no resource with id: " + resourceId);
            }

        });
        if(newResourcename.trim().isEmpty()) {
            throw new InvalidDataException();
        }
        else if (editedResource.getName().equals(newResourcename)) {
            throw new InvalidDataException("New name must be different than previous.");
        }
        editedResource.setDateOfUpdate(LocalDateTime.now());
        editedResource.setName(newResourcename);

        return resourceRepository.save(editedResource);
    }
}
