package com.tech.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.backend.model.User;

public interface UserRepositoty extends JpaRepository<User, Long >{

}
