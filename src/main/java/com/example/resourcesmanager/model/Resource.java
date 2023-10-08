package com.example.resourcesmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "resource")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private Long id;
    @Column(name = "resource_name")
    private String name;
    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;
    @Column(name = "date_of_update")
    private LocalDateTime dateOfUpdate;
    @Column(name = "resource_type")
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @Column(name = "userid")
    private Long userid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Resource(String name, LocalDateTime dateOfCreate, LocalDateTime dateOfUpdate, ResourceType resourceType, Long userId) {
        this.name = name;
        this.dateOfCreate = dateOfCreate;
        this.dateOfUpdate = dateOfUpdate;
        this.resourceType = resourceType;
        this.userid = userId;
        setDateOfCreate(LocalDateTime.now());
    }
}

