package com.jaksona.app.controller.admin;

import com.jaksona.app.entity.admin.User;
import com.jaksona.app.service.admin.UserService;
import com.jaksona.app.service.admin.exception.DataExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
		User user = getUserService().load(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> searchUser(@RequestParam(value = "user", required = false) User user) {
		Collection<User> users = getUserService().search(user);
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
			getUserService().create(user);
			return new ResponseEntity<String>("添加成功", headers, HttpStatus.CREATED);
		} catch (DataExistsException e) {
			return new ResponseEntity<String>(user.getUsername() + "已经存在", headers, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeUser(@PathVariable("userId") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		getUserService().remove(id);
		return new ResponseEntity<String>("删除用户成功", headers, HttpStatus.NO_CONTENT);
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
