package com.example.TrRestfulWebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class UserServiceDao {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"bala", new Date()));
		users.add(new User(2,"krishna", new Date()));
		users.add(new User(3,"bala krishna", new Date()));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			Integer id = users.size();
			user.setId(++id);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {

		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
