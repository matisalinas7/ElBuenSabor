package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.User;

import java.util.Optional;

public interface UserService extends BaseService<User, Long>{
    Optional<User> findByUsername(String username);
}
