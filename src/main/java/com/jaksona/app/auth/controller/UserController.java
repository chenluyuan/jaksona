package com.jaksona.app.auth.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jaksona
 */
@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger logger = LogManager.getLogger(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> hello() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
}
