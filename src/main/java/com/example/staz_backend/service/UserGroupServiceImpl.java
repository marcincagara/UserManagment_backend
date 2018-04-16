package com.example.staz_backend.service;

import com.example.staz_backend.entity.UserGroup;
import com.example.staz_backend.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {

   private UserGroupRepository userGroupRepository;

    @Autowired
    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Transactional
    public List<UserGroup> getAllUserGroups(){
        List<UserGroup> users = new ArrayList<>();
        userGroupRepository.findAll().forEach(e -> users.add(e));
        return users;
    }

    @Transactional
    public void saveUserGroup(UserGroup userGroup){
        userGroupRepository.save(userGroup);
    }

    @Transactional
    public void deleteUserGroup(Integer id){
        userGroupRepository.deleteById(id);
    }

    @Transactional
    public void updateUserGroup(UserGroup userGroup){
        userGroupRepository.save(userGroup);
    }
}
