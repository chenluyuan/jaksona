package com.jaksona.app.service.admin;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.BaseService;

/**
 *
 * @author jaksona
 */
public interface UserService extends BaseService<User> {

	/**
	 * Indicates whether or not exists the user that has the username
	 * @param username The user that has the username
	 * @return whether or not exists
	 */
	boolean exists(String username);
}
