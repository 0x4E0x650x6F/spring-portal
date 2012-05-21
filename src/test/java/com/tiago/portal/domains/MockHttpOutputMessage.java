package com.tiago.portal.domains;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;

public class MockHttpOutputMessage  implements HttpOutputMessage {
	
	private final HttpHeaders headers = new HttpHeaders();

	private final ByteArrayOutputStream body = new ByteArrayOutputStream();

	public HttpHeaders getHeaders() {
		return headers;
	}

	public OutputStream getBody() throws IOException {
		return body;
	}

	public byte[] getBodyAsBytes() {
		return body.toByteArray();
	}

	public String getBodyAsString(Charset charset) {
		byte[] bytes = getBodyAsBytes();
		return new String(bytes, charset);
	}
}
