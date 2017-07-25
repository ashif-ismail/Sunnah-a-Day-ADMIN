package me.ashif.sunnah.backend.config;

import com.vaadin.spring.access.SecuredViewAccessControl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@Configuration
public class BeanConfig {
    @Bean
    public org.springframework.web.client.RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecuredViewAccessControl securedViewAccessControl()
    {
        return new SecuredViewAccessControl();
    }
}
