package com.jaksona.app;

import com.jaksona.app.bean.tree.TreeNode;
import com.jaksona.app.entity.admin.Permission;
import com.jaksona.app.service.admin.PermisService;
import com.jaksona.app.utils.TreeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jaksona
 */
@Configuration
public class AppStartup implements ApplicationListener<ContextRefreshedEvent> {

	private Logger logger = Logger.getLogger(AppStartup.class);

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	private PermisService permisService;

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("应用程序监听>>>" + event.getApplicationContext().getApplicationName());
		if(event.getApplicationContext().getParent() == null) {
			initMenu();
			initRole();
		}
	}

	private void initRole() {

	}

	private void initMenu() {
		logger.info("初始化菜单开始>>>");
		List<Permission> menus = new LinkedList<>(getPermisService().search(null));
		TreeNode<Permission> root = new TreeNode<>();
		Permission permis = new Permission();
		permis.setId(-1L);
		root.setMe(permis);
		TreeUtil.buildFromList(root, menus);

		logger.info("初始化菜单结束>>>");
	}

	public PermisService getPermisService() {
		return permisService;
	}

	@Autowired
	public void setPermisService(PermisService permisService) {
		this.permisService = permisService;
	}
}
