package com.example.staz_backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserGroupDto {

    private Integer id;
    private String name;
    private List<String> usersList;
}
