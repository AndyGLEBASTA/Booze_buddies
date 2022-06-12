package com.example.exampleproject.Service.Configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


@Component
@EnableAutoConfiguration
public class WebSecConf extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAP aadapter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(aadapter);

    }
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration", "/suggestion").permitAll()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                .antMatchers("/business-page").hasAuthority("ROLE_BUSINESS")
                .antMatchers("/product-category").hasAnyAuthority( "ROLE_USER")

                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html",true)
//                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/suggestion").permitAll()
//                .defaultSuccessUrl("/admin").usernameParameter("ROLE_ADMIN")
//                .defaultSuccessUrl("/business-page").usernameParameter("ROLE_BUSINESS")




                .and()
                .httpBasic()
                .and()
                .logout()
                .permitAll()

                .logoutSuccessUrl("/login");


    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN")
                .and()
                .withUser("business").password("password").roles("BUSINESS");
    }



}