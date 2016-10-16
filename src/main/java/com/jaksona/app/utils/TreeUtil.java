package com.jaksona.app.utils;

import com.jaksona.app.bean.tree.TreeBean;
import com.jaksona.app.bean.tree.TreeNode;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 树数据结构工具
 * @author jaksona
 */
public class TreeUtil {

	private TreeUtil(){}

	public static void buildFromList(TreeNode<? extends TreeBean> parent, List<? extends TreeBean> datas) {
		Assert.notNull(parent, "parent node is null");
		Assert.notNull(datas, "list is null");
		datas.forEach(data -> {
			if(parent.getMe().getId().equals(data.getParent())) {
				TreeNode treeNode = new TreeNode<>();
				treeNode.setMe(data);
				parent.getChildrens().add(treeNode);
			}
		});
		List<? extends TreeNode<?>> childs = parent.getChildrens();
		childs.forEach(child -> buildFromList(child, datas));
	}
}
