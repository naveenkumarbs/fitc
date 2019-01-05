package com.bsn.fitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource
public class FitcApplication extends SpringBootServletInitializer {
		 
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(FitcApplication.class);
	    }
	    
	public static void main(String[] args) {
		SpringApplication.run(FitcApplication.class, args);
	}

}

