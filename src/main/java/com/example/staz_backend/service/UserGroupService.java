package com.example.staz_backend.service;

import com.example.staz_backend.entity.UserGroup;

import java.util.List;

public interface UserGroupService {
    List<UserGroup> getAllUserGroups();
    void saveUserGroup(UserGroup userGroup);
    void deleteUserGroup(Integer id);
    void updateUserGroup(UserGroup userGroup);
}
