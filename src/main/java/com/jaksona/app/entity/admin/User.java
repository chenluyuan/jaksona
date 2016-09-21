package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * @author jaksona
 */
public class User extends BaseEntity {
	// members
	private String username;
	private String password;
	private Boolean enabled;

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

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				'}';
	}
}
