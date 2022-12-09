package com.developer.repository;

import com.developer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
