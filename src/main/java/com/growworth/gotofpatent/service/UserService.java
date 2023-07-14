package com.growworth.gotofpatent.service;

import com.growworth.gotofpatent.dto.UserFormRequestDto;
import com.growworth.gotofpatent.entity.User;
import com.growworth.gotofpatent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long Id) {
        return userRepository.findById(Id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
