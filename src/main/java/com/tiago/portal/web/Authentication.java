package com.tiago.portal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles requests for the application Authentication.
 */
public class Authentication {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public String login() {
		logger.info("Login has Call");
		
		return "index";
	}

}
