package com.library;

public class BookApplication {

	private static Library library = new Library();

	public static void main(String[] args) {

		library.readBookInLibrary();
		library.takeBookToHome();

	}

}
