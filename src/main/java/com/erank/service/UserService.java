package com.erank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erank.model.User;
import com.erank.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> saveUsers(List<User> users){
		return userRepo.saveAll(users);
	}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User userUpdate(User user) {
		User existingUser= userRepo.findByEmail(user.getEmail()).orElse(null);
		existingUser.setPhNum(user.getPhNum());
		existingUser.setEmail(user.getEmail());
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());	
		return userRepo.save(existingUser);
	}

}
