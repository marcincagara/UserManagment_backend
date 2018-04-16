package com.example.staz_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "users_group",joinColumns = {@JoinColumn(name = "user_group_id")},inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> usersList;
    public UserGroup() {
    }
}
