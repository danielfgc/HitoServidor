package com.springbootrestapi.services.impl;

import com.springbootrestapi.exception.ResourceNotFoundException;
import com.springbootrestapi.models.User;
import com.springbootrestapi.repository.UserRepository;
import com.springbootrestapi.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUser(int id) {
/*        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new ResourceNotFoundException("User","id", id);
        }*/
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
    }

    @Override
    public Boolean getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.isPresent();
    }


    @Override
    public User updateUser(User user, int id) {
        User existsUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
        existsUser.setUsername(user.getUsername());
        existsUser.setEmail(user.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "";
        password = user.getPassword();
        System.out.println(password);
        String encodedPassword = passwordEncoder.encode(password);
        existsUser.setPassword(encodedPassword);
        userRepository.save(existsUser);
        return existsUser;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
        userRepository.deleteById(id);
    }
}
