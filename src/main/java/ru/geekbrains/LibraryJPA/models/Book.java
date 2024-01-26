package ru.geekbrains.LibraryJPA.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table (name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "bId")
    private long id;
    @Column (name = "bName", nullable = false)
    private String name;
    @Column(name = "bAuthor", nullable = false)
    private String author;
    @OneToMany
    @JoinColumn (name = "bID")
    private List<Issue> issues = new ArrayList<>();

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public Book(){

    }
}
