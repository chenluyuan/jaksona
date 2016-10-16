package com.jaksona.app.controller.admin;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登陆控制器
 * @author jaksona
 */
@Controller
public class LoginController {

	private UserService userService;

	@PostMapping(value = "/login")
	public ResponseEntity login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		User user = userService.findByUsername(username);
		if(new BCryptPasswordEncoder(8).matches(password, user.getPassword())) {
			user.setPassword(null);
			session.setAttribute("user", user);
		}else {

		}
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
