package com.jaksona.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jaksona
 */
@ControllerAdvice
public class AppControllerAdvice {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView exceptionHandler(Exception e) {
		return new ModelAndView("404", "msg", e.getMessage());
	}
}
