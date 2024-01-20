package com.addon.userservice.service;

import java.util.List;
import java.util.Optional;

import com.addon.userservice.entity.UserEntity;

public interface UserService {

    UserEntity save(UserEntity userEntity);
    List<UserEntity> get();
    List<UserEntity> findByUserType(String userType);
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByUserId(String userId);


    UserEntity update(UserEntity userEntity);
    void deleteByUserId(String userId);
    
}
