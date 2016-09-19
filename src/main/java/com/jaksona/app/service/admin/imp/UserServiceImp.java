package com.jaksona.app.service.admin.imp;

import com.jaksona.app.dao.admin.UserDAO;
import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import com.jaksona.app.service.admin.exception.TableFieldUniqueException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public Collection<User> getUsersForCondition(User user) {
		Assert.notNull(user, "user is null");
		if(log.isDebugEnabled()) {
			log.debug("select user ==>" + user);
		}
		return getUserDAO().selectByEntity(user);
	}

	@Override
	public User loadUser(Long id) {
		Assert.notNull(id, "id is null");
		if(log.isDebugEnabled()) {
			log.debug("select id ==>" + id);
		}
		return getUserDAO().selectByPrimaryKey(id);
	}

	@Override
	public int addUser(User user) throws TableFieldUniqueException {
		if(log.isDebugEnabled()) {
			log.debug("add user ==>" + user);
		}

		if(!existUser(user.getUsername())) {
			return getUserDAO().insertSelective(user);
		}else {
			throw new TableFieldUniqueException(user.getUsername() + " have already exited");
		}
	}

	@Override
	public int modifyUser(User user) {
		return 0;
	}

	@Override
	public int removeUser(Long id) {
		return 0;
	}

	/**
	 * Indicates whether or not exists the user that has the username
	 *
	 * @param username The user that has the username
	 * @return whether or not exists
	 */
	@Override
	public boolean existUser(String username) {
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
