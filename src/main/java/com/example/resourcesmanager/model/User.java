package com.example.resourcesmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;
    @Column(name = "date_of_update")
    private LocalDateTime dateOfUpdate;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources;


}
