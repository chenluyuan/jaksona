package com.jaksona.app.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jaksona.app.PageLimit;

import java.io.Serializable;

/**
 * 所有数据库实体基类
 * @author jaksona
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseEntity implements Serializable {
	private Long id;
	private Integer status;
	private PageLimit pageLimit;

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

	public PageLimit getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(PageLimit pageLimit) {
		this.pageLimit = pageLimit;
	}
}
