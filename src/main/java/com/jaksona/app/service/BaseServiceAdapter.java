package com.jaksona.app.service;

import com.jaksona.app.service.admin.exception.DataExistsException;

import java.util.Collection;

/**
 * @author jaksona
 */
public abstract class BaseServiceAdapter<T> implements BaseService<T> {
	/**
	 * Load the T for the condition
	 *
	 * @param obj the condition
	 * @return The users for the condition
	 */
	@Override
	public Collection<T> search(T obj) {
		return null;
	}

	/**
	 * Load a T by id
	 *
	 * @param id The id of the user
	 * @return The User that was read
	 */
	@Override
	public T load(Long id) {
		return null;
	}

	/**
	 * Create the T
	 *
	 * @param obj The T that was added
	 */
	@Override
	public void create(T obj) throws DataExistsException {

	}

	/**
	 * Create the Ts
	 *
	 * @param objs The T's that was added
	 */
	@Override
	public void create(Collection<T> objs) throws DataExistsException {

	}

	/**
	 * Edit the T
	 *
	 * @param obj The T that was edited, must contain id
	 */
	@Override
	public void edit(T obj) {

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
}
