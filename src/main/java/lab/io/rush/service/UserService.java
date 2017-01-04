package lab.io.rush.service;

import lab.io.rush.model.User;

public interface UserService {
	
	User login(User user);
	
	boolean register(User user);
	
	boolean isUserRegistered(String username);
}
