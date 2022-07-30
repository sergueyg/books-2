package com.proj.books.service;

import com.proj.books.model.User;
import com.proj.books.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public User updateUser(User user){
        User userInDB = getUserByUsername(user.getUsername());
        userInDB.setUsername(user.getUsername() != null ? user.getUsername() : userInDB.getUsername());
        userInDB.setPassword(user.getPassword() != null ? user.getPassword() : userInDB.getPassword());
        userInDB.setName(user.getName() != null ? user.getName() : userInDB.getName());
        userInDB.setHomeAddress(user.getHomeAddress() != null ? user.getHomeAddress() : userInDB.getHomeAddress());
        return userRepository.save(userInDB);
    }
}
