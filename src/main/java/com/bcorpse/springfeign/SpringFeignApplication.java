package com.bcorpse.springfeign;

import com.bcorpse.springfeign.client.BookClient;
import com.bcorpse.springfeign.model.BookResource;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFeignApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringFeignApplication.class, args);
		BookClient bookClient = Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(BookClient.class))
				.logLevel(Logger.Level.FULL)
				.target(BookClient.class, "http://localhost:8081/api/books");
		for (BookResource bookResource:bookClient.findAll()) {
			System.out.println(bookResource.getBook());
		}
	}
}
