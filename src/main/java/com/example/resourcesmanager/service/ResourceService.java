package com.example.resourcesmanager.service;

import com.example.resourcesmanager.mapper.ResourceMapper;
import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.repository.ResourceRepository;
import com.example.resourcesmanager.request.ResourceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public Resource addResource(ResourceRequest resourceRequest) {
        Resource resource = ResourceMapper.toEntity(resourceRequest);
        resource.setDateOfCreate(LocalDateTime.now());
        return resourceRepository.save(resource);
    }

    public void deleteFile(Long fileid){
        resourceRepository.deleteById(fileid);
    }

    public Resource editResourcename(Long fileid, Resource newResourcename) {
        Resource editedResource = resourceRepository.findById(fileid).orElseThrow();
        editedResource.setDateOfUpdate(LocalDateTime.now());
        editedResource.setName(newResourcename.getName());
        return resourceRepository.save(editedResource);
    }
}
