package lab.io.rush.service;

import lab.io.rush.dto.UserStatusDto;
import lab.io.rush.model.User;

public interface UserService {
	
	User login(User user);
	
	UserStatusDto register(User user);
	
	boolean isUserRegistered(String username);
}
