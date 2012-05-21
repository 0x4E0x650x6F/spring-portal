package com.tiago.portal.domains;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.util.Assert;

public class MockHttpInputMessage implements HttpInputMessage {
	
	private final HttpHeaders headers = new HttpHeaders();

	private InputStream body = null;

	public MockHttpInputMessage(byte[] contents) {
		Assert.notNull(contents, "'contents' must not be null");
		this.body = new ByteArrayInputStream(contents);
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public InputStream getBody() throws IOException {
		return body;
	}

	
}
