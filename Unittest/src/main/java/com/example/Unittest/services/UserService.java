package com.example.Unittest.services;

import com.example.Unittest.entities.Users;
import com.example.Unittest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Users createUser(Users user) {
        return userRepository.saveAndFlush(user);
    }

    public Users getSingleUser(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public void setUserActive(Long UserId, boolean isActive) {
        Optional<Users> user = userRepository.findById(UserId);
        if (user.isEmpty()) {
            return;
        } else {
            user.get().setActive(isActive);
            userRepository.saveAndFlush(user.get());
        }
    }

    public Users updateUser(Long id, Users user) {
        Users updatedUser = getSingleUser(id);
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setActive(user.isActive());
        return userRepository.saveAndFlush(updatedUser);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }
}

