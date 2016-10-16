package com.jaksona.app.bean.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形数据结构
 * @author jaksona
 */
public class TreeNode<T extends TreeBean> {
	private T me;
	private List<TreeNode<T>> childrens = new ArrayList<>();
	private TreeNode<T> parent;

	public T getMe() {
		return me;
	}

	public void setMe(T me) {
		this.me = me;
	}

	public List<TreeNode<T>> getChildrens() {
		return childrens;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
}
