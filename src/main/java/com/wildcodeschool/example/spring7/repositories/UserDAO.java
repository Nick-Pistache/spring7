package com.wildcodeschool.example.spring7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.example.spring7.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}