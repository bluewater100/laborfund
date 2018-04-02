package com.hcsc.laborfund.auth.laborfundauth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcsc.laborfund.auth.laborfundauth.exception.UserNotFoundException;
import com.hcsc.laborfund.auth.laborfundauth.model.User;
import com.hcsc.laborfund.auth.laborfundauth.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);

        userOptional.orElseThrow(() -> new UserNotFoundException("The requested user was not found. id:"+id));

        return userOptional.get();
    }


}
