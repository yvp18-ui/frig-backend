package com.frig.frig_backend.service;

import com.frig.frig_backend.model.UserModel;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface FrigService {
    void insertUser(UserModel userModel);
    List<UserModel> getUsers();
    String validateUser(UserModel userModel);
}
