package com.jaksona.app.auth.controller;

import com.jaksona.app.auth.mapper.UserDAO;
import com.jaksona.app.auth.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jaksona
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		return new ResponseEntity<List<User>>(userDAO.selectAll(), HttpStatus.OK);
	}
}
