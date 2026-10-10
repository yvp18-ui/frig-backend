package com.frig.frig_backend.repository;

import com.frig.frig_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FrigJpaRespository extends JpaRepository<UserModel, String> {
}
