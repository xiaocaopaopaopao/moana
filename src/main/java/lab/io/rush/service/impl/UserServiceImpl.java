package lab.io.rush.service.impl;

import lab.io.rush.dao.UserDao;
import lab.io.rush.model.User;
import lab.io.rush.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		User u = userDao.selectByEmailAndPassword(user.getEmail(),
				user.getPassword());
		return u;
	}

	@Override
	public boolean register(User user) {
		if (userDao.insert(user))
			return true;
		return false;
	}

	@Override
	public boolean isUserRegistered(String email) {
		User u = userDao.selectByEmail(email);
		if (u != null)
			return true;
		return false;
	}
}