package com.example.staz_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("userGroups")
    private List<String> userGroups;
}
