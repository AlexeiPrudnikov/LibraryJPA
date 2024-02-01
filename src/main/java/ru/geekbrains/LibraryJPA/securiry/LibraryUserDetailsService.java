package ru.geekbrains.LibraryJPA.securiry;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.geekbrains.LibraryJPA.models.Role;
import ru.geekbrains.LibraryJPA.models.User;
import ru.geekbrains.LibraryJPA.repositories.UserRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class LibraryUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                roles);
    }
}
