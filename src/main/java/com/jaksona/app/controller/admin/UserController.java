package com.jaksona.app.controller.admin;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import com.jaksona.app.service.admin.exception.TableFieldUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 * @author jaksona
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userId") Long id) {
		User user = getUserService().loadUser(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> searchUser(@RequestBody User user) {
		Collection<User> users = getUserService().getUsersForCondition(user);
		if(users == null) {
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		try {
			getUserService().addUser(user);
			return new ResponseEntity<String>("添加成功", headers, HttpStatus.CREATED);
		} catch (TableFieldUniqueException e) {
			return new ResponseEntity<String>(user.getUsername() + "已经存在", headers, HttpStatus.EXPECTATION_FAILED);
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
