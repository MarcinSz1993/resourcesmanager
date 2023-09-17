package com.example.resourcesmanager.request;

import com.example.resourcesmanager.model.ResourceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ResourceRequest {
    private Long id;
    private String name;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfModification;
    private ResourceType resourceType;
    private Long userid;
}
