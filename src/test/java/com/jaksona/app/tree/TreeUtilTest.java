package com.jaksona.app.tree;

import com.google.gson.GsonBuilder;
import com.jaksona.app.bean.tree.TreeNode;
import com.jaksona.app.entity.admin.Permission;
import com.jaksona.app.utils.TreeUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaksona
 */
public class TreeUtilTest {

	private List<Permission> datas;

	@Before
	public void init() {
		datas = new ArrayList<>();
		Permission p11 = new Permission();
		p11.setName("北京");
		p11.setId(1L);
		p11.setParent(-1L);
		Permission p12 = new Permission();
		p12.setName("天津");
		p12.setId(2L);
		p12.setParent(-1L);
		Permission p13 = new Permission();
		p13.setName("河北");
		p13.setId(3L);
		p13.setParent(-1L);
		Permission p14 = new Permission();
		p14.setName("河南");
		p14.setId(4L);
		p14.setParent(-1L);
		Permission p15 = new Permission();
		p15.setName("湖南");
		p15.setId(5L);
		p15.setParent(-1L);
		Permission p16 = new Permission();
		p16.setName("湖北");
		p16.setId(6L);
		p16.setParent(-1L);
		datas.add(p11);
		datas.add(p12);
		datas.add(p13);
		datas.add(p14);
		datas.add(p15);
		datas.add(p16);

		Permission p111 = new Permission();
		p111.setName("海淀区");
		p111.setId(7L);
		p111.setParent(1L);
		Permission p112 = new Permission();
		p112.setName("昌平区");
		p112.setId(8L);
		p112.setParent(1L);
		Permission p113 = new Permission();
		p113.setName("房山区");
		p113.setId(9L);
		p113.setParent(1L);
		datas.add(p111);
		datas.add(p112);
		datas.add(p113);


	}

	@Test
	public void testBuild() {
		TreeNode<Permission> treeNode = new TreeNode<>();
		Permission p = new Permission();
		p.setName("中国");
		p.setParent(-1L);
		p.setId(-1L);
		treeNode.setMe(p);
		TreeUtil.buildFromList(treeNode, datas);
		System.out.println(new GsonBuilder().create().toJson(treeNode));
	}
}
