package com.frig.frig_backend.controller;

import com.frig.frig_backend.model.UserModel;
import com.frig.frig_backend.service.FrigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrigController {

    @Autowired
    FrigService frigService;

    @PostMapping("/add/user")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserModel user){
        frigService.insertUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/validate/user")
    public String validateUser(@RequestBody UserModel user){
        return frigService.validateUser(user);
    }

    @PostMapping("/get/users")
    public List<UserModel> getUsers(){
        return frigService.getUsers();
    }

}
