package com.jaksona.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author jaksona
 */
@ControllerAdvice
public class AppControllerAdvice {

	private final Logger logger = LogManager.getLogger(getClass());

	@ExceptionHandler
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String exceptionHandler(Exception e) {
		logger.error(e);
		return "404";
	}
}
