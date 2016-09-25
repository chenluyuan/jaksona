package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * 权限
 * @author jaksona
 */
public class Permission extends BaseEntity {
	// members
	private String name;
	private String descn;
	private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
