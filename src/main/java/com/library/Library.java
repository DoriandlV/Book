package com.library;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Library {

    private Book book;

    public List<Book> books = new ArrayList<>();

    public List<Book> createBook(){

        for(int i =0; i<10; i++) {
            String title = RandomStringUtils.random(10, true, false);
            String author = RandomStringUtils.random(10, true, false);
            String country = RandomStringUtils.random(10, true, false);
            String genre = RandomStringUtils.random(10, true, false);
            String year = RandomStringUtils.random(4, false, true);

            book.setTitle(title);
            book.setAuthor(author);
            book.setCountry(country);
            book.setYear(year);
            book.setGenre(genre);

            books.add(book);
        }

        return books;
    }

   public synchronized Book takeBookToHome(){

        Random rand = new Random();
        int int_random = rand.nextInt(10);
        log.info("Inside takeBookToHome Libray Method");

       return books.get(int_random);
    }

    public synchronized Book readBookInLibrary(){

        Random rand = new Random();
        int int_random = rand.nextInt(10);


        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        log.info("Inside readBookIn Libray Method");
        return books.get(int_random);
    }
}
