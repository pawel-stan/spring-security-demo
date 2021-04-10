package edu.logintegra.springsecuritydemo.config;

import edu.logintegra.springsecuritydemo.auth.Authority;
import edu.logintegra.springsecuritydemo.auth.AuthorityRepository;
import edu.logintegra.springsecuritydemo.enums.AuthorityName;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements InitializingBean {

    private final AuthorityRepository authorityRepository;

    public Bootstrap(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Rozpoczynamy przygotowywanie aplikacji...");

        prepareAuthorities();
    }

    private void prepareAuthorities() {
        for (AuthorityName name : AuthorityName.values()) {
            Authority existingAuthority = authorityRepository.findByName(name);
            if (existingAuthority == null) {
                Authority authority = new Authority(name);

                authorityRepository.save(authority);
            }
        }
    }
}
