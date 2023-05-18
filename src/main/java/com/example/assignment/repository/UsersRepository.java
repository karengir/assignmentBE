package com.example.assignment.repository;

import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
