package com.example.TrRestfulWebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserServiceDao service;
	
//	Reterive all users
	@GetMapping(path ="/users")
	public List<User> reteriveAllUsers(){
		return service.getAllUsers();
	}
	
//	getting a specific user
	@GetMapping(path = "/users/{id}")
	public User reteriveUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Not Found");
		}
		return user;
	}
	
//	input - details of the user
//	output - Created & Return the creatd uri
	@PostMapping(path = "/users")
	public ResponseEntity<Object>  createUser(@RequestBody User user) {
		User savedUser = service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
				
	}
}
