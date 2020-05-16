package com.akshay.av.AvYT;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class AvytServletInitializer extends SpringBootServletInitializer	{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AvYtApplication.class);
	}

}
