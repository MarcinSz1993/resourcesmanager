package com.example.resourcesmanager.service;

import com.example.resourcesmanager.mapper.ResourceMapper;
import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.repository.ResourceRepository;
import com.example.resourcesmanager.request.ResourceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public Resource addResource(ResourceRequest resourceRequest, Long userId) {
        Resource resource = ResourceMapper.toEntity(resourceRequest, userId);
        resource.setDateOfCreate(LocalDateTime.now());
        return resourceRepository.save(resource);
    }

    public void deleteFile(Long fileid){
        resourceRepository.deleteById(fileid);
    }

    //Doczytać o @Transactional
    public Resource editResourceName(Long fileid, Resource newResourcename) {
        Resource editedResource = resourceRepository.findById(fileid).orElseThrow();
        editedResource.setDateOfUpdate(LocalDateTime.now());
        editedResource.setName(newResourcename.getName());
        return resourceRepository.save(editedResource);
    }
}
