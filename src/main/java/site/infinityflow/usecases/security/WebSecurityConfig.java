package site.infinityflow.usecases.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


public class WebSecurityConfig extends WebSecurityConfiguration {



    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .authorizeHttpRequests().requestMatchers("/buscar_usuario/**").permitAll();


    }
}
