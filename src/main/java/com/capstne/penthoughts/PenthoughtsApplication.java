package com.capstne.penthoughts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.capstne.penthoughts"})
public class PenthoughtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenthoughtsApplication.class, args);
	}

}
