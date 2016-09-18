package com.jaksona.app.entity.admin;

import com.jaksona.app.BaseEntity;

/**
 * @author jaksona
 */
public class GroupMember extends BaseEntity {
	// members
	private String username;
	private Long groupId;

	// setter and getter

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
