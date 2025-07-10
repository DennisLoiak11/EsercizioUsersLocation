package com.dennisdebiasi.eserciziocybercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EserciziocybercoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EserciziocybercoreApplication.class, args);
	}
}
