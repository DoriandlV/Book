package com.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class Library {

    Book book;

   public synchronized Book takeBookToHome(){

       log.info("Inside takeBookToHome Libray Method");
        book.setAuthor("Abcde");
        book.setCountry("Italy");
        book.setYear(2013);
        book.setGenre("Thriller");
       return book;
    }

    public synchronized Book readBookInLibrary(){
        log.info("Inside readBookIn Libray Method");
        book.setAuthor("Abcde");
        book.setCountry("Italy");
        book.setYear(2013);
        book.setGenre("Thriller");
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
       return book;
    }
}
