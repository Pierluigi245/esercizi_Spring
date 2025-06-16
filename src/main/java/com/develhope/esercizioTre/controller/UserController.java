package com.develhope.esercizioTre.controller;

import com.develhope.esercizioTre.model.User;
import com.develhope.esercizioTre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/V3")
public class UserController {
    @Autowired
    private UserRepository userRepo ;


    @GetMapping("/ciao")
    public List<User> getAllUtenti() {



        Iterable<User> users = userRepo.findAll();
        List<User> userList = new ArrayList<>();
        for (User u : users){
            userList.add(u);
        }
        return userList;

    }



}
