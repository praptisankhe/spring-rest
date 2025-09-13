package org.example.controller;

import org.example.exception.BookNotFoundException;
import org.example.exception.LibraryEmptyException;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book)
    {
        Book insertedBook = bookService.saveBook(book);
        return new ResponseEntity<>(insertedBook, HttpStatus.CREATED);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) throws BookNotFoundException
    {
        Book book = bookService.getBook(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() throws LibraryEmptyException
    {
        List<Book> allBook = bookService.getAllBooks();
        return new ResponseEntity<>(allBook,HttpStatus.OK);
    }
}
