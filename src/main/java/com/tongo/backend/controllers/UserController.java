package com.tongo.backend.controllers;

import com.tongo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getAllUsers() { return new ResponseEntity(userService.getUsers(), HttpStatus.OK); }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getUsersById(@PathVariable int id){
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }


}
