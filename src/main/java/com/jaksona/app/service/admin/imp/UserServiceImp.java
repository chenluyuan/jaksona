package com.jaksona.app.service.admin.imp;

import com.jaksona.app.dao.admin.UserDAO;
import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import com.jaksona.app.service.admin.exception.DataExistsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 *
 * @author jaksona
 */
@Service
public class UserServiceImp implements UserService {

	private final Log log = LogFactory.getLog(getClass());

	private UserDAO userDAO;

	/**
	 * Load the T for the condition
	 *
	 * @param user the condition
	 * @return The users for the condition
	 */
	@Override
	public Collection<User> search(User user) {
		Assert.notNull(user, "user is null");
		if(log.isDebugEnabled()) {
			log.debug("search user by condition ==>" + user);
		}
		return getUserDAO().selectByEntity(user);
	}

	/**
	 * Load a T by id
	 *
	 * @param id The id of the user
	 * @return The User that was read
	 */
	@Override
	public User load(Long id) {
		Assert.notNull(id, "id is null");
		if(log.isDebugEnabled()) {
			log.debug("select user by id ==>" + id);
		}
		return getUserDAO().selectByPrimaryKey(id);
	}

	/**
	 * Create the T
	 *
	 * @param user The T that was added
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void create(User user) throws DataExistsException {
		if(log.isDebugEnabled()) {
			log.debug("create user ==>" + user);
		}

		if(!exists(user.getUsername())) {
			user.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
			getUserDAO().insertSelective(user);
		}else {
			throw new DataExistsException(user.getUsername() + " have already exited");
		}
	}

	/**
	 * Create the Ts
	 *
	 * @param objs The T's that was added
	 */
	@Override
	public void create(Collection<User> objs) throws DataExistsException {

	}

	/**
	 * Edit the T
	 *
	 * @param obj The T that was edited, must contain id
	 */
	@Override
	public void edit(User obj) {

	}

	/**
	 * Remove the T by id
	 *
	 * @param id The T's id that will remove
	 */
	@Override
	public void remove(Long id) {

	}

	/**
	 * Remove the Ts by ids
	 *
	 * @param ids The collections of id
	 */
	@Override
	public void remove(Collection<Long> ids) {

	}

	/**
	 * Indicates whether or not exists the user that has the username
	 *
	 * @param username The user that has the username
	 * @return whether or not exists
	 */
	@Override
	public boolean exists(String username) {
		return getUserDAO().selectByUsername(username) == 1;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
