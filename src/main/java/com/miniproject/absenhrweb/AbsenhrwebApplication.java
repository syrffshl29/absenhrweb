package com.miniproject.absenhrweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AbsenhrwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsenhrwebApplication.class,args);
	}

}
