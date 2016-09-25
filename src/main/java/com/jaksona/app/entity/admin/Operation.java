package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * @author jaksona
 */
public class Operation extends BaseEntity {
	// members
	private String code;
	private String name;
	private String descn;

	// setter and getter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
}
