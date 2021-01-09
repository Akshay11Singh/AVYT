package com.akshay.av.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping("/mycartreg")
public class MyRegistrationController {

	@PostMapping(value="/registration",consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registration(@RequestBody Header header) {
	
		System.out.println(header);
		
		return ResponseEntity.ok(header);

	}
	@GetMapping("/registration")
	public String registration() {

		return "my registraion is called!!";

	}
}

class Header {
	@JsonProperty("ChannelId")
	String channelId;
	@JsonProperty("Timestamp")
	Date timeStamp;
	@JsonProperty("ServiceProvider")
	String serviceProvider;

	protected Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the serviceProvider
	 */
	public String getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider the serviceProvider to set
	 */
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Header [channelId=" + channelId + ", timeStamp=" + timeStamp + ", serviceProvider=" + serviceProvider
				+ "]";
	}
	
	
}
