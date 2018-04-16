package com.example.staz_backend.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "users_group",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "user_group_id")})
    private List<UserGroup> userGroups;

    public User(){}

}
