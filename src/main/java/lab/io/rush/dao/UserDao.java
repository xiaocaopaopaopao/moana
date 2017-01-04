package lab.io.rush.dao;

import lab.io.rush.model.User;

public interface UserDao {

	boolean insert(User user);

	User selectByEmail(String email);

	User selectByEmailAndPassword(String email, String password);
}