package lab.io.rush.dao.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import lab.io.rush.dao.UserDao;
import lab.io.rush.model.User;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {

	@Autowired
	private PersistenceManagerFactory persistenceManagerFactory;

	@Override
	public boolean insert(User user) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		User u = pm.makePersistent(user);
		if (u != null)
			return true;
		return false;
	}
	
	@Override
	public User selectById(String uid) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		Query<?> q = pm.newQuery(User.class, "uid =='" + uid + "'");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) q.execute();
		User u = null;
		if (users != null && !users.isEmpty())
			u = users.get(0);
		return u;
	}

	@Override
	public User selectByEmail(String email) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		Query<?> q = pm.newQuery(User.class, "email =='" + email + "'");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) q.execute();
		User u = null;
		if (users != null && !users.isEmpty())
			u = users.get(0);
		return u;
	}

	@Override
	public User selectByEmailAndPassword(String email, String password) {
		PersistenceManager pm = persistenceManagerFactory
				.getPersistenceManager();
		Query<?> q = pm.newQuery(User.class, "email =='" + email
				+ "'&& password == '" + password + "'");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) q.execute();
		User u = null;
		if (users != null && !users.isEmpty())
			u = users.get(0);
		return u;
	}
}
