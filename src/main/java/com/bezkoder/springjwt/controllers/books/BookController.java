package com.bezkoder.springjwt.controllers.books;

import com.bezkoder.springjwt.entities.Book;
import com.bezkoder.springjwt.entities.TypeOfBook;
import com.bezkoder.springjwt.services.BookService;
import com.bezkoder.springjwt.services.TypeOfBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
@CrossOrigin(allowedHeaders = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private TypeOfBookService typeOfBookService;

    @GetMapping(value = "/all")
    public List<Book> findAll() {
        return bookService.getAllSearch();
    }
    @GetMapping(value = "/type")
    public List<TypeOfBook> findAllType() {
        return typeOfBookService.getAll();


    }
    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody Book book)
    {
           bookService.save(book);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
