package com.tiago.portal.bind.data;


import static org.junit.Assert.assertEquals;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiago.portal.domains.MockHttpInputMessage;
import com.tiago.portal.domains.MockHttpOutputMessage;
import com.tiago.portal.domains.Request;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testServletContext.xml")
public class RequestTest {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestTest.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MappingJacksonHttpMessageConverter converter;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	
	@Before
	public void setUp() throws Exception {
		logger.info("Request Test init");
	}
	
	@Test
	public void testRequestContext() {
		logger.info("Application Context Test!");
		Assert.assertNotNull(applicationContext);
	}
	
	@Test
	public void testObjectMapper() {
		logger.info("Application Context ObjectMapper Test!");
		Assert.assertNotNull(objectMapper);
	}
	
	@Test
	public void testJsonConverter() {
		logger.info("Application Context converter Test!");
		Assert.assertNotNull(converter);
	}
	
	@Test
	public void testRequestConvert() throws Exception {
		
		//test payload
		String jsonPayload = "{\"property\":\"teste\",\"value\":\"teste\"}";
		
		MockHttpInputMessage request = new MockHttpInputMessage(jsonPayload.getBytes("UTF-8"));
		MockHttpOutputMessage response = new MockHttpOutputMessage();
		
		MediaType jsonType = new MediaType("application", "json");
		
		//setup InputMessage
		request.getHeaders().setContentType(jsonType);
		Request requestObject = (Request) converter.read((Class)Request.class,  request);
		
		//validate payload
		Assert.assertNotNull(requestObject);
		converter.write(requestObject, jsonType, response);
		logger.debug(response.getBody().toString());
		
		logger.debug(request.toString());
		assertEquals("Incoming and outgoing JSON representations expected to match", jsonPayload, response.getBody().toString());
	}

}
