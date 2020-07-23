package com.my.simple.http.server;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHttpHandler implements HttpHandler {

	public void handle(HttpExchange httpExchange) throws IOException {

		String requestParamValue = null;

		if ("GET".equals(httpExchange.getRequestMethod())) {

			//requestParamValue = handleGetRequest(httpExchange);

		} else if ("POST".equals(httpExchange)) {

			//throw new RuntimeException("Currently cannot handle POST requests.");

		}

		handleResponse(httpExchange, requestParamValue);

	}

	private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {

		OutputStream outputStream = httpExchange.getResponseBody();
		StringBuilder htmlBuilder = new StringBuilder();

		htmlBuilder.append("Hello from My HTTP Server.");

		httpExchange.sendResponseHeaders(200, htmlBuilder.toString().length());

		outputStream.write(htmlBuilder.toString().getBytes());

		outputStream.flush();

		outputStream.close();

	}
}
