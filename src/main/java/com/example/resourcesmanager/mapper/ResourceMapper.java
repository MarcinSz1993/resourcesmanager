package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.request.ResourceRequest;

public class ResourceMapper {
    public static Resource toEntity(ResourceRequest resourceRequest){
        Resource resourceEntity = new Resource();
        resourceEntity.setId(resourceRequest.getId());
        resourceEntity.setName(resourceRequest.getName());
        resourceEntity.setResourceType(resourceRequest.getResourceType());
        resourceEntity.setUserid(resourceRequest.getUserid());
        return resourceEntity;
    }
}
