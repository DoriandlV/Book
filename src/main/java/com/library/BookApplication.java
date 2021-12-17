package com.library;

public class BookApplication {

	private static Library library = new Library();

	public static void main(String[] args) {

		library.createLibrary();
		library.readBookInLibrary();
		library.takeBookToHome();

	}

}
