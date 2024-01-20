package com.addon.userservice.controller;
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
import com.addon.userservice.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserEntity save(@RequestBody UserEntity userEntiy) {
        return userService.save(userEntiy);
    }

    @GetMapping()
    public List<UserEntity> get() {
        return userService.get();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable(name = "id") Long id) {
         Optional<UserEntity> byId = userService.findById(id);
         return byId.isPresent()?byId.get():null;
    }

    @GetMapping("/{userId}")
    public UserEntity getById(@PathVariable(name = "userId") String userId) {
        Optional<UserEntity>  byUserId = userService.findByUserId(userId);
          return byUserId.isPresent()?byUserId.get():null;
    }



    @PutMapping()
    public void update(@RequestBody UserEntity productEntity) {
         userService.update(productEntity);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable(name="userId") String userId){
        userService.deleteByUserId(userId);
    }

}
