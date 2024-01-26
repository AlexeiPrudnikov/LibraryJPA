package ru.geekbrains.LibraryJPA.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.LibraryJPA.models.Issue;
import ru.geekbrains.LibraryJPA.services.IssueService;

import javax.naming.directory.NoSuchAttributeException;
import java.util.List;

@RestController
@RequestMapping("/issues")
@AllArgsConstructor
public class IssueController {
    private final IssueService issueService;
    @GetMapping("/all")
    public List<Issue> getAll(){
        return issueService.getAll();
    }
    @PutMapping("/{id}")
    public Issue returnBook(@PathVariable long id) throws NoSuchAttributeException {
        issueService.closeIssue(id);
        return issueService.getIssueByID(id).get();
    }
}
