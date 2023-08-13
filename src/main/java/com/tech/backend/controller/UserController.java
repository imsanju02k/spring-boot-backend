package com.tech.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.backend.exception.UserNotFoundException;
import com.tech.backend.model.User;
import com.tech.backend.repository.UserRepositoty;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepositoty userRepositoty;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepositoty.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepositoty.findAll();
	}
	
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepositoty.findById(id).orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userRepositoty.findById(id).map(user->{
			user.setUsername(newUser.getUsername());
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			return userRepositoty.save(user);
		}).orElseThrow(()-> new UserNotFoundException(id)); 
	}
	
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userRepositoty.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepositoty.deleteById(id);
		return "User with id " +id+ " has been deleted successfully. ";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
