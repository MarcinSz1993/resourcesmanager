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
@RequestMapping("/resource")
public class ResourceController {
    private final ResourceService resourceService;

    @PostMapping
    public Resource addResource(
            @RequestHeader("Username") String username,
            @RequestBody ResourceRequest resourceRequest
    ) {

        return resourceService.addResource(resourceRequest, username);
    }

    @DeleteMapping("/{resourceId}")
    public void deleteFile(@PathVariable("resourceId") Long fileid) {
        resourceService.deleteFile(fileid);
    }


    @PutMapping("/{id}")
    public Resource editResource(@PathVariable Long id, @RequestBody String newResourcename) {
        return resourceService.editResourceName(id, newResourcename);
    }
}
