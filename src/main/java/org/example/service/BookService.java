package org.example.service;

import org.example.exception.BookNotFoundException;
import org.example.exception.LibraryEmptyException;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public Book saveBook(Book book)
    {
        if(book != null)
        {
            bookRepository.save(book);
        }
        return book;
    }

    public List<Book> getAllBooks()
    {
        List<Book> allBooks = bookRepository.findAll();
        if(allBooks.isEmpty())
        {
            throw new LibraryEmptyException("Ah ! Library is empty at the moment. Come Again in some time !!!!");
        }
        return allBooks;
    }

    public Book getBook(Long id)
    {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(()->new BookNotFoundException("Book not found in our library with id: "+id));
    }
}
