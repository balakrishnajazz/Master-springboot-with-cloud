package com.example.TrRestfulWebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"bala",new Date()));
		users.add(new User(2,"krishna",new Date()));
		users.add(new User(3,"remo",new Date()));
	}
	
//	Returning all the users
	public List<User> findAll(){
		return users;
	}
	
//	Saving the new user
//	And returning the created user
	public User saveUser(User user) {
		if(user.getId() == null) {
			int id = users.size();
			user.setId(++id);
		}
		users.add(user);
		return user;
	}
	
//	finding the user based upon the user ID
	public User findOne(int id) {
		
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	
}
