package com.springbootrestapi.controllers;

import com.springbootrestapi.models.User;
import com.springbootrestapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }
    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getALlUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") int userId){
        return new ResponseEntity<User>(userService.getOneUser(userId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User user){
        System.out.println(user.getPassword());
        return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteuser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
    }

}
