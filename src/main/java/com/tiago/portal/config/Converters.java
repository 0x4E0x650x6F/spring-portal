package com.tiago.portal.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@Configuration
public class Converters {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Bean
	public  MappingJacksonHttpMessageConverter jsonMessageConveter(){
		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		return converter;
	}
	
	@Bean
	public ObjectMapper createObjectMapper(){
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		return objectMapper;
	}
	
}
