package com.library;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Library {

    private Book book = new Book();

    private List<Book> books = new LinkedList<>();

    public List<Book> createLibrary(){

        for(int i =0; i<10; i++) {
            String title = RandomStringUtils.random(8, true, false);
            String author = RandomStringUtils.random(10, true, false);
            String country = RandomStringUtils.random(6, true, false);
            String genre = RandomStringUtils.random(7, true, false);
            String year = RandomStringUtils.random(4, false, true);

            book.setTitle(title);
            book.setAuthor(author);
            book.setCountry(country);
            book.setYear(year);
            book.setGenre(genre);

        books.add(book);
        }
        log.info("Inside create Library of Books ");
        return books;
    }

   public synchronized Book takeBookToHome(){


        Random rand = new Random();
        int int_random = rand.nextInt(9);

        log.info("Inside takeBookToHome Libray Method " + books.get(int_random));
       return books.get(int_random);
   }

    public synchronized Book readBookInLibrary(){

        Random rand = new Random();
        int int_random = rand.nextInt(9);


        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        log.info("Inside readBookIn Libray Method " + books.get(int_random));

        return books.get(int_random);
    }
}
