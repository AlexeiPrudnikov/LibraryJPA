package ru.geekbrains.LibraryJPA.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.LibraryJPA.models.User;
import ru.geekbrains.LibraryJPA.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping
    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        /*
        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        /
         */
        return userRepository.findAll();
    }
}
