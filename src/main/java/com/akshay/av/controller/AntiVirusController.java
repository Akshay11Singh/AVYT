package com.akshay.av.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.av.exception.ExceptionMd5;
import com.akshay.av.exception.ExceptionServerErrorMd5;
import com.akshay.av.model.Md5_encrypted;
import com.akshay.av.service.AntiVirusService;

@RestController
public class AntiVirusController {

	@Autowired(required = true)
	HttpServletRequest httpServletRequest;

	@Autowired(required = true)
	AntiVirusService antiVirusService;

	@RequestMapping("status")
	public String appStatus(){
		return "Application is started";
	}

	@GetMapping(value = "Ram_Cloud_Scan", produces = { "application/json" })
	public ResponseEntity<Md5_encrypted> md5Status(@RequestParam (name ="md5" )  String md5) throws ExceptionMd5,ExceptionServerErrorMd5, IncorrectResultSizeDataAccessException{
		Md5_encrypted md5_encrypted = new Md5_encrypted();
		md5=md5.trim();
		if (md5 != null || !("".equals(md5))) {
			try {
				Optional<Md5_encrypted> mOptional = antiVirusService.getMD5(md5);
				
				if (mOptional.isPresent()) {
					md5_encrypted = mOptional.get();
				} else
				{
					md5_encrypted.setRansomWare("Not Found");
					md5_encrypted.setMd5(md5);
					md5_encrypted.setID(null);
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(md5_encrypted);
				}
			} catch (Exception e ) {
			
				throw new ExceptionServerErrorMd5("Internal Server Exception while fetching MD5 "+ e.getMessage() +" :" +md5);	
			}
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(md5_encrypted);
		}
		return ResponseEntity.status(HttpStatus.OK).body(md5_encrypted);

	}
}
