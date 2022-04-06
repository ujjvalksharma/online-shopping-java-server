package com.cyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication : @Configuration, @EnableAutoConfiguration and @ComponentScan
	
Component: @Resposity,@Service, @ResController, @Controller,@Compoenent : This is used to register the class object as a bean 
	                                                                  which can be autoriwed to get singleton object
	
	@ComponentScan: is used by spring to scan all the componenets in the class path
		
		@EnableAutoConfiguration: it automatically creates and registers beans based on both the 
		included jar files in the classpath and the beans defined by us.
			
			@Configration: is used defined some config for the project like spring security.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
