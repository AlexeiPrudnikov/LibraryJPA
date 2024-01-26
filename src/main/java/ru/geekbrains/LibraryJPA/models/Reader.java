package ru.geekbrains.LibraryJPA.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "readers")
@Data
public class Reader {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "rId")
    private long id;
    @Column(name = "rName", nullable = false)
    private String name;
    @OneToMany
    @JoinColumn (name = "rID")
    private List<Issue> issues = new ArrayList<>();
    public Reader(){
    }
    public Reader(String name) {
        this.name = name;
    }
}
