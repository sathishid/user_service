package com.addon.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addon.userservice.dao.UserRepository;
import com.addon.userservice.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void deleteByUserId(String userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserEntity> findByUserType(String userType) {
        return userRepository.findByUserType(userType);
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> get() {
        return userRepository.findAll();
    }

}
