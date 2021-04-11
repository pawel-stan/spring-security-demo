package edu.logintegra.springsecuritydemo.auth;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {

    @GetMapping("/")
    @Secured("ROLE_USERS_TAB")
    public String index() {
        return "people/index";
    }
}
