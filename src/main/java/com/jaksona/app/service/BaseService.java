package com.jaksona.app.service;

import com.jaksona.app.service.admin.exception.DataExistsException;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * The base class of service
 * @author jaksona
 */
public interface BaseService<T> {

	/**
	 * Load the T for the condition
	 * @param obj the condition
	 * @return The users for the condition
	 */
	Collection<T> search(T obj);

	/**
	 * Load a T by id
	 * @param id The id of the user
	 * @return The User that was read
	 */
	T load(Long id);

	/**
	 * Create the T
	 * @param obj The T that was added
	 */
	void create(T obj) throws DataExistsException;

	/**
	 * Create the Ts
	 * @param objs The T's that was added
	 */
	void create(Collection<T> objs) throws DataExistsException;

	/**
	 * Edit the T
	 * @param obj The T that was edited, must contain id
	 */
	void edit(T obj);

	/**
	 * Remove the T by id
	 * @param id The T's id that will remove
	 */
	void remove(Long id);

	/**
	 * Remove the Ts by ids
	 * @param ids The collections of id
	 */
	void remove(Collection<Long> ids);
}
