package ru.geekbrains.LibraryJPA.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.LibraryJPA.models.Book;
import ru.geekbrains.LibraryJPA.models.Reader;
import ru.geekbrains.LibraryJPA.services.ReaderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    @GetMapping("/all")
    public List<Reader> getAll(){
        return readerService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reader> getReaderByID(@PathVariable long id){
        return readerService.getReaderByID(id);
    }
    @PostMapping("/reader")
    public Reader addReader(@PathParam("name") String name) {
        return readerService.addReader(name);
    }

    @PutMapping("/{id}")
    public Reader updateReader(@PathVariable long id, @PathParam("name") String name) {
        return readerService.updateReader(id, name);
    }
}
