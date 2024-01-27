package com.addon.userservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addon.userservice.entity.UserEntity;
import com.addon.userservice.exception.UserNotFoundException;
import com.addon.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserEntity save(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping()
    public List<UserEntity> get() throws IOException {
        // throw new IOException ("checked : IOException thrown forcefully here");
        return userService.get();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable(name = "id") Long id) {
        Optional<UserEntity> byId = userService.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    @GetMapping("userId/{userId}")
    public UserEntity getByUserId(@PathVariable(name = "userId") String userId) {
        Optional<UserEntity> byUserId = userService.findByUserId(userId);
        if (!byUserId.isPresent()) {
            throw new UserNotFoundException(userId + " is not available");
        }
        return byUserId.get();
    }

    @PutMapping()
    public void update(@RequestBody UserEntity productEntity) {
        userService.update(productEntity);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable(name = "userId") String userId) {
        userService.deleteByUserId(userId);
    }

}
