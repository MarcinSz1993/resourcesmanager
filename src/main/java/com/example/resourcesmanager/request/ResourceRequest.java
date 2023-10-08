package com.example.resourcesmanager.request;

import com.example.resourcesmanager.model.ResourceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ResourceRequest {
    private String name;
    private LocalDateTime dateOfCreate;
    private LocalDateTime dateOfUpdate;
    private ResourceType resourceType;

}
