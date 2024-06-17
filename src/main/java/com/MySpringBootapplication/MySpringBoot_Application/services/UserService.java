package com.MySpringBootapplication.MySpringBoot_Application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MySpringBootapplication.MySpringBoot_Application.Repository.UserRepository;
import com.MySpringBootapplication.MySpringBoot_Application.entities.User;

@Service
public class UserService {
	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
