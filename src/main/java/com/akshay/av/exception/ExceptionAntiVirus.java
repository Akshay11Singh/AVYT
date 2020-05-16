package com.akshay.av.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionAntiVirus extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errMsg;
	private String errCode;

	public ExceptionAntiVirus() {

	}

	public ExceptionAntiVirus(String errMsg,String errCode) {
		this.errMsg=errMsg;
		this.errCode=errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
