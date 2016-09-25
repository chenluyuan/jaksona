package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

import java.util.List;

/**
 * 用户
 * @author jaksona
 */
public class User extends BaseEntity {
	// members
	private String username;
	private String password;
	private Boolean enabled;

	// relations
	private List<Role> roles;
	private List<Group> groups;

	// setter and getter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				'}';
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
