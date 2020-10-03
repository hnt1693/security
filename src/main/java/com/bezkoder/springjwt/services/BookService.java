package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    List<Book> getAllSearch();
    void save(Book book);
}
