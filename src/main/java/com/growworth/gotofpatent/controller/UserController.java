package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.entity.User;
import com.growworth.gotofpatent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity getUser(@PathVariable Long user_id) {
        User user = userService.getUserById(user_id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
