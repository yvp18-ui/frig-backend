package com.frig.frig_backend.service.impl;

import com.frig.frig_backend.model.UserModel;
import com.frig.frig_backend.repository.FrigJpaRespository;
import com.frig.frig_backend.service.FrigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrigServiceImpl implements FrigService {

    @Autowired
    FrigJpaRespository frigJpaRespository;

    @Override
    public void insertUser(UserModel user) {
        frigJpaRespository.save(user);
    }

    @Override
    public List<UserModel> getUsers() {
        return frigJpaRespository.findAll();
    }

    @Override
    public String validateUser(UserModel requestUser) {
        Optional<UserModel> storedUser = frigJpaRespository.findById(requestUser.getUsername());
        if(storedUser.isEmpty()) return "ERROR: USER NOT FOUND";

        if(!requestUser.getPassword().equals(storedUser.get().getPassword())){
            return "ERROR: INCORRECT PASSWORD";
        }

        return "SUCCESS: USER FOUND";
    }
}
