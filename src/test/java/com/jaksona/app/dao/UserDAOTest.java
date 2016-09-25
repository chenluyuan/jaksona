package com.jaksona.app.dao;

import com.jaksona.app.config.WebMvcConfig;
import com.jaksona.app.dao.admin.UserDAO;
import com.jaksona.app.entity.admin.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author jaksona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class UserDAOTest {

	@Autowired private UserDAO userDAO;

	@Before
	public void setUp() {
	}

	@Test
	public void testSelect() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword(new BCryptPasswordEncoder(8).encode("admin"));
		user.setEnabled(true);
		System.out.println(userDAO.selectByPrimaryKey(1L));
	}
}
