package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.entities.TypeOfBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfBookRepository extends JpaRepository<TypeOfBook, Long> {
}
