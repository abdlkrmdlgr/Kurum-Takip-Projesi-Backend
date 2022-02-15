package com.restDeneme.resDeneme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ResDenemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResDenemeApplication.class, args);
	}

	public String hello()
	{
		return"Merhaba";
	}

}
