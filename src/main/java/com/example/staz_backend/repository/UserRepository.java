package com.example.staz_backend.repository;

import com.example.staz_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findById(int integer);
}
