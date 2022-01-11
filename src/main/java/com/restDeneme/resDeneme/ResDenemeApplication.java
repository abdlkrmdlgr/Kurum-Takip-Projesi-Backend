package com.restDeneme.resDeneme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResDenemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResDenemeApplication.class, args);
	}

	public String hello()
	{
		return"Merhaba";
	}

}
