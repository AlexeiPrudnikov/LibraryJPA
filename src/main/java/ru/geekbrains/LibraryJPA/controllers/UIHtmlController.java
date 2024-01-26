package ru.geekbrains.LibraryJPA.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.LibraryJPA.models.Book;
import ru.geekbrains.LibraryJPA.models.Issue;
import ru.geekbrains.LibraryJPA.models.Reader;
import ru.geekbrains.LibraryJPA.services.BookService;
import ru.geekbrains.LibraryJPA.services.IssueService;
import ru.geekbrains.LibraryJPA.services.ReaderService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
public class UIHtmlController {
    private final BookService bookService;
    private final ReaderService readerService;
    private final IssueService issueService;
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping("/readers")
    public String getAllReaders(Model model){
        List<Reader> readers = readerService.getAll();
        model.addAttribute("readers", readers);
        return "readers";
    }
    @GetMapping("/readers/{id}")
    public String getBooksByReader (Model model, @PathVariable long id){
        Reader reader = readerService.getReaderByID(id).get();
        List<Book> books = issueService.getBooksByReader(id);
        model.addAttribute("reader", reader);
        model.addAttribute("books", books);
        return "booksbyreader";

    }
    @GetMapping("/issues")
    public String getAllIssues(Model model){
        List<Issue> issues = issueService.getAll();
        model.addAttribute("issues", issues);
        model.addAttribute("readerService", readerService);
        model.addAttribute("bookService", bookService);
        return "issues";
    }
    /*


    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookRepository.getAllBooks();
        model.addAttribute("books", books);
        return "books";
        }
    @GetMapping("/readers")
    public String getAllReaders (Model model){
        List<Reader> readers = readerRepository.getAllReaders();
        model.addAttribute("readers", readers);
        return "readers";
    }
    @GetMapping("/issues")
    public String getAllIssues(Model model){
        List<Issue> issues = issueReposirory.getAllIssue();
        model.addAttribute("issues", issues);
        model.addAttribute("readerRepository", readerRepository);
        model.addAttribute("bookRepository", bookRepository);
        return "issues";
    }
    @GetMapping("/readers/{id}")
    public String getBooksByReader (Model model, @PathVariable long id){
        Reader reader = readerRepository.getReaderById(id);
        List<Book> books = issueService.getBooksByReader(id);
        model.addAttribute("reader", reader);
        model.addAttribute("books", books);
        return "booksbyreader";

    }
     */

}
