package com.erank.controller;

import com.erank.exception.ResourceNotFoundException;
import com.erank.model.User;
import com.erank.repo.UserRepository;
import com.erank.security.CurrentUser;
import com.erank.security.UserPrincipal;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    
}