package com.sda.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class DemoProjectApplication {


	public static void main(String[] args) {

		log.info("Am pornit, sefule!!!");
		SpringApplication.run(DemoProjectApplication.class, args);
		log.info("Gata, final, sefule!!!");
	}

}
