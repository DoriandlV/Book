package com.library;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Book {

    private String author;
    private int year;
    private String country;
    private String genre;
}
