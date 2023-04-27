package com.finalproject.urproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrprojectApplication {


	public static void main(String[] args) {

		SpringApplication.run(UrprojectApplication.class, args);
		MyBean test = new MyBean();
		//System.out.println(test.getMessage("2022-2-2","2022-3-17"));
	}

}
