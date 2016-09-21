package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * @author jaksona
 */
public class Group extends BaseEntity {
	// members
	private String groupName;

	// setter and getter

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
