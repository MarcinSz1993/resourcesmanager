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
    private final UserRepository userRepository;

    @PostMapping
    public Resource addResource(
            @RequestHeader("Username") String username,
            @RequestBody ResourceRequest resourceRequest
    ) {
        //Rozwiązać w ładniejszy sposób najlepiej w chainie.
        // Jeżeli robię .get() na Optionalu to jest sygnał, że mogłem coś rozwiązać lepiej.
        //Logikę biznesową przenieść do warstwy service. Nie wstrzykiwać repozytorium do kontrolera.
        Optional<User> byName = userRepository.findByName(username);
        Long userId;
        if (byName.isPresent()) {
            userId = byName.get().getId();
        } else {
            throw new UserNotFoundException(username);
        }
        return resourceService.addResource(resourceRequest, userId);
    }

    //Przerobić nazwy na Resource
    @DeleteMapping("/{fileid}")
    public void deleteFile(@PathVariable("fileid") Long fileid) {
        resourceService.deleteFile(fileid);
    }

    //Nie przekazywać obiektu bazodanowego z frontu.
    //Nie przekazywać nadmiarowej ilości danych.
    //Skasować nazwę część ściezki.
    @PutMapping("/editresourcename/{id}")
    public Resource editResource(@PathVariable Long id, @RequestBody Resource newResourcename) {
        return resourceService.editResourceName(id, newResourcename);
    }
}
