package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	@Autowired
	private static Library library;

	public static void main(String[] args) {

		library.readBookInLibrary();
		library.takeBookToHome();

		SpringApplication.run(BookApplication.class, args);
	}

}
