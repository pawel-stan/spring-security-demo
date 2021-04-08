package edu.logintegra.springsecuritydemo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements InitializingBean {

    @Value("${my.variable.name}")
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> my.variable.name: " + name);
    }
}
