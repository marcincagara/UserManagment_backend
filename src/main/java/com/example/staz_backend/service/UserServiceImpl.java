package com.example.staz_backend.service;

import com.example.staz_backend.entity.User;
import com.example.staz_backend.exceptions.UserNotFoundException;
import com.example.staz_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));
        return users;
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Użytkownik z takim ID nie istnieje");
        }
    }

    @Transactional
    public void updateUser(User user){
        userRepository.save(user);
    }

    @Transactional
    public User findSingleUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserById(Integer id) {
         if(userRepository.findById(id).isPresent()){
             return userRepository.findById(id).get();
         }else{
             throw new UserNotFoundException("Użytkownik z takim ID nie istnieje");
         }
    }
}
