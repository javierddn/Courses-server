package com.eagerminds.courses.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class CoursesSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/a")
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated();
//        http.antMatcher("/**")
//            .authorizeRequests()
        //            .antMatchers(HttpMethod.GET, "/rest/**").hasAnyRole("ADMIN", "USER")
        //            .antMatchers(HttpMethod.POST, "/rest/**").hasRole("ADMIN")
//            .antMatchers("/", "/login**").permitAll()
//            .anyRequest().authenticated();
    }

}
