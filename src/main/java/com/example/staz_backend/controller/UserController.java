package com.example.staz_backend.controller;

import com.example.staz_backend.dto.UserDto;
import com.example.staz_backend.entity.User;
import com.example.staz_backend.entity.UserGroup;
import com.example.staz_backend.password.PasswordUtils;
import com.example.staz_backend.service.UserService;
import com.example.staz_backend.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private PasswordUtils passwordUtils;

    @Autowired
    public UserController(UserServiceImpl userService, PasswordUtils passwordUtils) {
        this.userService = userService;
        this.passwordUtils = passwordUtils;
    }


    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        System.out.println("USERS: " + users);
        List<UserDto> userDto = new ArrayList<>();

        for (User e : users) {
            List<UserGroup> userRoleList = e.getUserGroups();
            List<String> userRoles = new ArrayList<>();
            for (UserGroup userRole : userRoleList) {
                userRoles.add(userRole.getName());
                userDto.add(new UserDto(e.getId(), e.getName(), e.getPassword(), e.getFirstName(), e.getLastName(),e.getDateOfBirth(), userRoles));
            }
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody User user){
        System.out.println(user);
        String salt = PasswordUtils.getSalt();
        user.setPassword(passwordUtils.generateSecurePassword(user.getPassword(),salt));
        userService.saveUser(user);
        return new ResponseEntity<>("New user has been added", HttpStatus.CREATED);
    }


    @CrossOrigin
    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>("User has been updated", HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.NO_CONTENT);
    }

    @CrossOrigin
    @GetMapping("/test/{id}")
    public ResponseEntity<?> updateTest(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
