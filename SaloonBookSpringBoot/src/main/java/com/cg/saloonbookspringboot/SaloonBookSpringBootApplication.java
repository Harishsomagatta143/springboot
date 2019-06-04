package com.cg.saloonbookspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.SaloonBookSpringBoot")
/**
 *  * @author hsomagat
   **class can be used to start spring application framework from main method**
 */
public class SaloonBookSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaloonBookSpringBootApplication.class, args);
		System.out.println("welcome spring boot");
	}

}
