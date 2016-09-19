package com.jaksona.app.service.admin.imp;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 *
 * @author jaksona
 */
@Service
public class UserServiceImp implements UserService {

	private final Log log = LogFactory.getLog(getClass());

	@Override
	public Collection<User> getUsersForCondition(User user) {
		return null;
	}

	@Override
	public User loadUser(Long id) {
		return null;
	}

	@Override
	public int addUser(User user) {
		return 0;
	}

	@Override
	public int modifyUser(User user) {
		return 0;
	}

	@Override
	public int removeUser(Long id) {
		return 0;
	}
}
