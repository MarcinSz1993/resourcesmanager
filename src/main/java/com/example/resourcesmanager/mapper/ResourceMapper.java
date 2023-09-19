package com.example.resourcesmanager.mapper;

import com.example.resourcesmanager.model.Resource;
import com.example.resourcesmanager.request.ResourceRequest;

public class ResourceMapper {
    //Przerobić na tworzenie konstruktorem lub builderem.
    //Nie przekazywać id w requestcie. Bo i tak jest potem nadpisywany przez Hibernate.
    public static Resource toEntity(ResourceRequest resourceRequest, Long userId){
        Resource resourceEntity = new Resource();
        resourceEntity.setId(resourceRequest.getId());
        resourceEntity.setName(resourceRequest.getName());
        resourceEntity.setResourceType(resourceRequest.getResourceType());
        resourceEntity.setUserid(userId);
        return resourceEntity;
    }
}
