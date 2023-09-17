package com.example.resourcesmanager.controller;

import com.example.resourcesmanager.exception.UserNotFoundException;
import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.model.User;
import com.example.resourcesmanager.repository.UserRepository;
import com.example.resourcesmanager.request.ResourceRequest;
import com.example.resourcesmanager.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;
    private final UserRepository userRepository;

    @PostMapping("/resource")
    public Resource addResource(@RequestHeader("Username")String username, @RequestBody ResourceRequest resourceRequest) {
        Optional<User> byName = userRepository.findByName(username);
        if (byName.isPresent()) {
            Long id = byName.get().getId();
            resourceRequest.setUserid(id);

        } else {
            throw new UserNotFoundException(username);
        }
        return resourceService.addResource(resourceRequest);
    }

    @DeleteMapping("/{fileid}")
    public void deleteFile(@PathVariable("fileid") Long fileid){
        resourceService.deleteFile(fileid);
    }

    @PutMapping("/editresourcename/{id}")
    public Resource editResource(@PathVariable Long id, @RequestBody Resource newResourcename){
        return resourceService.editResourcename(id,newResourcename);
    }
}
