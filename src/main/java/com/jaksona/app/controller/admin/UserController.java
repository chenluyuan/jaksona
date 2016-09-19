package com.jaksona.app.controller.admin;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 * @author jaksona
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@RequestMapping(value = "/{userId}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("userId") Long id) {
		User user = getUserService().loadUser(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Collection<User>> search(@RequestBody User user) {
		Collection<User> users = getUserService().getUsersForCondition(user);
		if(users == null) {
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
		}
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
