package com.jaksona.app.entity.admin;

import com.jaksona.app.entity.BaseEntity;

/**
 * 资源
 * @author jaksona
 */
public class Resource extends BaseEntity {
	// members
	private String name;
	private Integer type;
	private String resource;
	private String descn;

	// setter and getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}
}
