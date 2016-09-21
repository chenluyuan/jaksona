package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * @author jaksona
 */
public class GroupAuthority extends BaseEntity {
	// members
	private Long groupId;
	private String authority;

	// setter and getter

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
