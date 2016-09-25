package com.jaksona.app.service;

/**
 * @author jaksona
 */
import com.jaksona.app.dao.admin.UserDAO;
import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import com.jaksona.app.service.admin.imp.UserServiceImp;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {WebApplicationStartup.class})
public class UserServiceTest {

//	@Autowired
	private UserDAO userDAO;

//	@InjectMocks
	private UserService userService = new UserServiceImp();

//	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

//	@Test
	public void testLoadUser() {
		long id = 1;
		User user = userService.load(id);
		System.out.println(user);
	}
}
