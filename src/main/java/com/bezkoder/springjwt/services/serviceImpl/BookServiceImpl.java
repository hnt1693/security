package com.bezkoder.springjwt.services.serviceImpl;

import com.bezkoder.springjwt.entities.Book;
import com.bezkoder.springjwt.repository.BookRepository;
import com.bezkoder.springjwt.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repo;
    @Override
    public List<Book> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Book> getAllSearch() {
        return repo.search();
    }

    @Override
    public void save(Book book) {
        repo.save(book);
    }
}
