package com.example.staz_backend.controller;

import com.example.staz_backend.entity.UserGroup;
import com.example.staz_backend.service.UserGroupService;
import com.example.staz_backend.service.UserGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class UserGroupController {

    private final UserGroupService userGroupService;

    @Autowired
    public UserGroupController(UserGroupServiceImpl userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("/list")
    public List<UserGroup> userGroupList(){
        return userGroupService.getAllUserGroups();
    }

    @PostMapping("/")
    public ResponseEntity<String> addUserGroup(UserGroup userGroup){
        userGroupService.saveUserGroup(userGroup);
        return new ResponseEntity<>("New UserGroup has been added", HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateUserGroup(UserGroup userGroup){
        userGroupService.updateUserGroup(userGroup);
        return new ResponseEntity<>("UserGroup has been updated",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserGroup(@PathVariable("id") Integer id){
        userGroupService.deleteUserGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
