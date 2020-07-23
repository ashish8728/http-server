package com.my.simple.http.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class MyHttpServer {

	public static void main(String[] args) throws IOException {

		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		server.createContext("/test", new MyHttpHandler());

		server.setExecutor(threadPoolExecutor);

		server.start();

		System.out.println("Server started at localhost:" + 8080);
	}

}
