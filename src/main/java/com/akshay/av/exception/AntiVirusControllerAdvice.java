package com.akshay.av.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AntiVirusControllerAdvice {
	
	@ExceptionHandler(ExceptionMd5.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionAntiVirus handleResourceNotFound(final ExceptionAntiVirus exception,
			final HttpServletRequest request) {

		ExceptionAntiVirus error = new ExceptionAntiVirus();
		error.setErrMsg(exception.getMessage());
		error.setErrCode(request.getRequestURI());

		return error;
	}
	@ExceptionHandler(ExceptionServerErrorMd5.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionAntiVirus handleServerError(final ExceptionAntiVirus exception,
			final HttpServletRequest request) {

		ExceptionAntiVirus error = new ExceptionAntiVirus();
		error.setErrMsg(exception.getMessage());
		error.setErrCode(request.getRequestURI());

		return error;
	}


}
