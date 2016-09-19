package com.jaksona.app.service.admin;

import com.jaksona.app.entity.admin.User;

import java.util.Collection;

/**
 *
 * @author jaksona
 */
public interface UserService {

	/**
	 * Load the users for the condition
	 * @param user the condition
	 * @return The users for the condition
	 */
	Collection<User> getUsersForCondition(User user);

	/**
	 * Load a user by id
	 * @param id The id of the user
	 * @return The User that was read
	 */
	User loadUser(Long id);

	/**
	 * Add the user
	 * @param user The user that was added
	 * @return The result of add, -1 for fail
	 */
	int addUser(User user);

	/**
	 * Modify the user
	 * @param user The user that was modified
	 * @return The result of modify, -1 for fail
	 */
	int modifyUser(User user);

	/**
	 * Remove the user by id
	 * @param id The id of the user
	 * @return The result of action, -1 for fail
	 */
	int removeUser(Long id);
}
