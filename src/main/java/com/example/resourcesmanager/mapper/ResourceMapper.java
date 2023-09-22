package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.request.ResourceRequest;

public class ResourceMapper {
    public static Resource toEntity(ResourceRequest resourceRequest, Long userId){
        return new Resource(
                resourceRequest.getName(),
                resourceRequest.getDateOfCreate(),
                resourceRequest.getDateOfUpdate(),
                resourceRequest.getResourceType(),
                userId);
    }
}
