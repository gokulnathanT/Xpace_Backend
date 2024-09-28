package com.project.Xpace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class XpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(XpaceApplication.class, args);
		System.out.println("hello");
	}
}
