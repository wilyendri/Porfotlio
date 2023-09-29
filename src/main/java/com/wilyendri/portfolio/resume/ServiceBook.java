package com.wilyendri.portfolio.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBook {
    private final BookRepository bookRepository;

    @Autowired
    public ServiceBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Integer id, NewBookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElse(null);
        assert book != null;
        book.setName(bookRequest.name);
        book.setAuthor(bookRequest.email);
        book.setYear(bookRequest.age);

        bookRepository.save(book);
    }

    public void addBook(NewBookRequest bookRequest) {
        Book book = new Book();
        book.setName(bookRequest.name);
        book.setAuthor(bookRequest.email);
        book.setYear(bookRequest.age);

        bookRepository.save(book);
    }

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    record NewBookRequest(String name, String email, Integer age){}

}
