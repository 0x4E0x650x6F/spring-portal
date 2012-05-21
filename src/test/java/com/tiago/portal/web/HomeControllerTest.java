package com.tiago.portal.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testServletContext.xml")
public class HomeControllerTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private HomeController homeController;
	
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private AnnotationMethodHandlerAdapter handlerAdapter;


	private static final Logger logger = LoggerFactory
			.getLogger(HomeControllerTest.class);

	@Before
	public void setUp() throws Exception {
		logger.info("HomeController Test init");
		request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
		handlerAdapter = new AnnotationMethodHandlerAdapter();
	}
	
	@Test
	public void testContext() {
		logger.info("Application Context Test!");
		Assert.assertNotNull(applicationContext);
	}

	@Test
	public void testHomeController() throws Exception {
		 request.setRequestURI("/");  
	     request.setMethod("GET");  
	     final ModelAndView mav = handlerAdapter.handle(request, response, homeController);
	     logger.info("Controller Test!");
	     Assert.assertEquals(mav.getViewName(), "home");  

	}

}
