package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Pedido;
import com.peso.elBuenSabor.entities.User;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
