package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

import java.util.List;

/**
 * 组
 * @author jaksona
 */
public class Group extends BaseEntity {
	// members
	private String name;
	private String descn;
	private Group parent;

	// relations
	private List<User> users;
	private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}
}
