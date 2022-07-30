package com.proj.books.controller;

import com.proj.books.model.User;
import com.proj.books.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        if((user != null && StringUtils.isNotBlank(user.getUsername()))
        && StringUtils.isNotBlank(user.getPassword())){
            return userService.createUser(user);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable(name = "username")String username){
        return userService.getUserByUsername(username);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        if(user == null || StringUtils.isBlank(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return userService.updateUser(user);
    }
}
