package com.example.resourcesmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
