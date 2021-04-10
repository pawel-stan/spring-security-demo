package edu.logintegra.springsecuritydemo.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public CustomUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);

        System.out.println("Znaleziony użytkownik: " + person);

        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        return buildUserDetails(person);
    }

    private UserDetails buildUserDetails(Person person) {
        // TODO: Pobierz uprawnienia użytkownika
        return new User(person.username, person.password, new ArrayList<>());
    }
}
