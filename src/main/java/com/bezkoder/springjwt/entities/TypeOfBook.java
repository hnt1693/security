package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "type_of_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfBook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    @OneToMany(targetEntity = Book.class)
    @JoinTable(name = "book_type")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    List<Book> books;
}
