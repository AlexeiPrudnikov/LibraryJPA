package ru.geekbrains.LibraryJPA.controllers;

import jakarta.persistence.Table;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.LibraryJPA.models.Book;
import ru.geekbrains.LibraryJPA.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable long id) {
        return bookService.getBookByID(id);
    }

    @PostMapping("/book")
    public Book addBook(@PathParam("name") String name, @PathParam("author") String author) {
        return bookService.addBook(name, author);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable long id, @PathParam("name") String name, @PathParam("author") String author) {
        return bookService.updateBook(id, name, author);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
