package com.addon.userservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addon.userservice.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>
{
    List<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findByUserId(String userId);
    Optional<UserEntity> findById(Long id);

    // re-use findBy*
    // boolean isValidUserById(Long userId);
    // boolean isValidUserByName(String userName);

    List<UserEntity> findByUserType(String userType);
    List<UserEntity> findAll();


}
