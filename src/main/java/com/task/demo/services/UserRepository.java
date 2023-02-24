package com.task.demo.services;

import com.task.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(int id);
    UserEntity findByUsername(String username);

    // also other method descriptions can be added
}