package com.jaksona.app.service.admin.imp;

import com.jaksona.app.dao.admin.PermissionDAO;
import com.jaksona.app.entity.admin.Permission;
import com.jaksona.app.service.admin.PermisService;
import com.jaksona.app.service.admin.exception.DataExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author jaksona
 */
@Service
public class PermisServiceImpl implements PermisService {


	private PermissionDAO permissionDAO;

	/**
	 * Load the T for the condition
	 *
	 * @param obj the condition
	 * @return The users for the condition
	 */
	@Override
	public Collection<Permission> search(Permission obj) {
		return getPermissionDAO().selectByEntity(obj);
	}

	/**
	 * Load a T by id
	 *
	 * @param id The id of the user
	 * @return The User that was read
	 */
	@Override
	public Permission load(Long id) {
		return getPermissionDAO().selectByPrimaryKey(id);
	}

	/**
	 * Create the T
	 *
	 * @param obj The T that was added
	 */
	@Override
	public void create(Permission obj) throws DataExistsException {
		getPermissionDAO().insertSelective(obj);
	}

	/**
	 * Create the Ts
	 *
	 * @param objs The T's that was added
	 */
	@Override
	public void create(Collection<Permission> objs) throws DataExistsException {

	}

	/**
	 * Edit the T
	 *
	 * @param obj The T that was edited, must contain id
	 */
	@Override
	public void edit(Permission obj) {
		getPermissionDAO().updateByPrimaryKeySelective(obj);
	}

	/**
	 * Remove the T by id
	 *
	 * @param id The T's id that will remove
	 */
	@Override
	public void remove(Long id) {
		getPermissionDAO().deleteByPrimaryKey(id);
	}

	/**
	 * Remove the Ts by ids
	 *
	 * @param ids The collections of id
	 */
	@Override
	public void remove(Collection<Long> ids) {

	}

	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	@Autowired
	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}
}
