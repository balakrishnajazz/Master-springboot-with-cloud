package com.example.TrRestfulWebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceBean {

	
	@Autowired
	private UserDaoService service;
	
//	Reterving all the users 
	@GetMapping("/users")
	public List<User> ReteriveAllUsers(){
		return service.findAll();
	}
	
	
//	Reterving the user based on the id
	@GetMapping(path="/users/{id}")
	public User ReteriveBasedOnId(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user== null) {
			throw new UserNotFoundExcception("User Not Found");
		}
		return user;
	}
	
//	creating the user
//	and saving it in the list.
	@PostMapping(path ="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user ) {
		
		User userSaved = service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
//	Deleting a User
	@DeleteMapping(path="/users/{id}")
	public void deleteBasedOnId(@PathVariable int id) {
		
		User user = service.deleteById(id);
		if(user== null) {
			throw new UserNotFoundExcception("User doesnot exists");
		}
		
	}
}
