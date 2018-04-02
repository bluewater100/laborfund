package com.hcsc.laborfund.auth.laborfundauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcsc.laborfund.auth.laborfundauth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}


