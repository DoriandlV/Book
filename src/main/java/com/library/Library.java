package com.library;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Slf4j
public class Library {

    public final List<Book> books = new ArrayList<>();

    Random rand = new Random();

    public List<Book> createLibrary(){

        for(int i =0; i<10; i++) {
            String title = RandomStringUtils.random(8, true, false);
            String author = RandomStringUtils.random(10, true, false);
            String country = RandomStringUtils.random(6, true, false);
            String genre = RandomStringUtils.random(7, true, false);
            String year = RandomStringUtils.random(4, false, true);

            Book book = new Book();
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

   public Book takeBookToHome(){

        synchronized (books){
            int int_random = rand.nextInt(9);
            log.info("Inside takeBookToHome Libray Method ");

            return books.get(int_random);
        }

   }
   public void returnBook(Book book){

       ReadWriteLock lock = new ReentrantReadWriteLock();
       Lock lock1 = lock.readLock();

        lock1.lock();
        System.out.println("");
        lock1.unlock();

   }

   public List<String> returnNames() {

        synchronized (books) {
            return books
                    .stream()
                    .map(Book::getTitle)
                    .collect(Collectors.toList());
        }

   }

    public Book readBookInLibrary(){

        synchronized (books) {
            int int_random = rand.nextInt(9);

            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            log.info("Inside readBookIn Libray Method ");

            return books.get(int_random);
        }
    }
}
