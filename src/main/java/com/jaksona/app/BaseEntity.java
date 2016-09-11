package com.jaksona.app;

import java.io.Serializable;

/**
 * 所有数据库实体基类
 * @author jaksona
 */
public class BaseEntity implements Serializable {
	private Long id;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
