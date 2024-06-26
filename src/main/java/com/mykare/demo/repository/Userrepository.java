package com.mykare.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mykare.demo.entity.User;



public interface Userrepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
