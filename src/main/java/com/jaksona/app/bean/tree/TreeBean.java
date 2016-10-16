package com.jaksona.app.bean.tree;

/**
 * 树形数据结构基类
 * @author jaksona
 */
public class TreeBean {
	private Long id;
	private Long parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}
}
