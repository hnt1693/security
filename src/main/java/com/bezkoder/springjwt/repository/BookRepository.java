package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query(value = "select b from Book b where b.type.name='TRUYỆN TRANH' or b.type is null")
//    List<Book> search();

//    @Query(value = "select * from book left join type_of_book on book.type=type_of_book.id where type_of_book.name like'%%' or type_of_book.id is null",nativeQuery = true)
//    List<Book> search();

    @Query(value = "select * from Book as b left join type_of_book t on b.type=t.id", nativeQuery = true)
    List<Book> search();
}
