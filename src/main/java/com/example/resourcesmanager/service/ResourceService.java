package com.example.resourcesmanager.service;

import com.example.resourcesmanager.exception.UserNotFoundException;
import com.example.resourcesmanager.mapper.ResourceMapper;
import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.repository.ResourceRepository;
import com.example.resourcesmanager.repository.UserRepository;
import com.example.resourcesmanager.request.ResourceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public Resource addResource(ResourceRequest resourceRequest,String username) {
        Optional<User> byName = userRepository.findByName(username);
        Long userId;
        if (byName.isPresent()) {
            userId = byName.get().getId();
        } else {
            throw new UserNotFoundException(username);
        }
        Resource resource = ResourceMapper.toEntity(resourceRequest, userId);
        resource.setDateOfCreate(LocalDateTime.now());
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long fileid){
        resourceRepository.deleteById(fileid);
    }

    //Doczytać o @Transactional - DOCZYTANE
    public Resource editResourceName(Long userId, String newResourcename) {
        Resource editedResource = resourceRepository.findById(userId).orElseThrow();
        editedResource.setDateOfUpdate(LocalDateTime.now());
        editedResource.setName(newResourcename);
        return resourceRepository.save(editedResource);
    }
}
