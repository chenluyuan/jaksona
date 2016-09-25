package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

import java.util.List;

/**
 * 角色
 * @author jaksona
 */
public class Role extends BaseEntity {
	// members
	private String name;
	private String descn;

	// relations
	private List<User> users;
	private List<Permission> permissions;

	// setter and getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
