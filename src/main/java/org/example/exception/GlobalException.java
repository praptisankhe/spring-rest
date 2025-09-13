package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException bookNotFoundException)
    {
        return new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LibraryEmptyException.class)
    public ResponseEntity<String> handleEmptyLibrary(LibraryEmptyException libraryEmptyException)
    {
        return new ResponseEntity<>(libraryEmptyException.getMessage(), HttpStatus.NOT_FOUND);
    }


}
