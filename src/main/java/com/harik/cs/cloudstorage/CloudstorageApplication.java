package com.harik.cs.cloudstorage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudstorageApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(CloudstorageApplication.class, args);
		System.out.println("Application Started Successfully");			
	}

}
