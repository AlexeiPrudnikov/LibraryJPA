package ru.geekbrains.LibraryJPA.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "issues")
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rID", nullable = false)
    private long readerId;
    @Column(name = "bID", nullable = false)
    private long bookId;
    @Column (name = "issuesDate", nullable = false)
    private LocalDate issued_at;
    @Column (name = "returnedDate")
    private LocalDate returned_at;
    public Issue(long readerId, long bookId, LocalDate issued_at) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.issued_at = issued_at;
    }
    public Issue() {
    }
}
