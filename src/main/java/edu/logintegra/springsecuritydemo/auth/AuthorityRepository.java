package edu.logintegra.springsecuritydemo.auth;

import edu.logintegra.springsecuritydemo.enums.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
