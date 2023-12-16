package com.wilyendri.portfolio.booksDB;

import com.wilyendri.portfolio.booksDB.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
