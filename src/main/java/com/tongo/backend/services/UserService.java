package com.tongo.backend.services;


import com.tongo.backend.data.models.User;
import com.tongo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){

        List<User> allUsers= (List<User>) userRepository.findAll();
        return allUsers;
    }


    public Optional<User> getUserById (int id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }


}
