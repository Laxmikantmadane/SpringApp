package com.MySpringBootapplication.MySpringBoot_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MySpringBootapplication.MySpringBoot_Application.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
