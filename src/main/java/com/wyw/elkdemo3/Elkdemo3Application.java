package com.wyw.elkdemo3;

import com.wyw.elkdemo3.services.logFactory.LogFactory;
import com.wyw.elkdemo3.services.logFactory.LogProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elkdemo3Application {

	public static void main(String[] args) {
		LogFactory logFactory = new LogProduct();
		logFactory.createUserLogThread().start();

		SpringApplication.run(Elkdemo3Application.class, args);
	}

}
