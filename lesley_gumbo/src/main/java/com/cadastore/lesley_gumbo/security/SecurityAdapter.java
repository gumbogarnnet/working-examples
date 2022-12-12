package com.cadastore.lesley_gumbo.security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author garnnet
 */
@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetaledService customUserDetaledService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetaledService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/forgot-password").permitAll()
                .antMatchers("/postregisteruser").permitAll()
                .antMatchers("/360_F_275471448_JVqZr4pwfoqFMo5KXTaaXAAt0tlcQvSZ.jpg").permitAll()
                .antMatchers("/*.jpg").permitAll()
                .antMatchers("/**/*.js").permitAll()
                .antMatchers("/**.js").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/*.js").permitAll()
                .antMatchers("/vendor/fontawesome-free/css/all.min.css").permitAll()
                .antMatchers("/css/sb-admin-2.min.css").permitAll()
                .antMatchers("/vendor/fontawesome-free/webfonts/fa-brands-400.woff2").permitAll()
                .antMatchers("/vendor/fontawesome-free/webfonts/fa-brands-400.woff").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                        .loginPage("/login")
                        .usernameParameter("userName")
//                        .defaultSuccessUrl("/pages",true).permitAll()
//                .successHandler(appAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    static class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        protected void handle(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {
        }

    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails> user = new ArrayList<>();
        user.add(User.withDefaultPasswordEncoder().username("user").password("password").roles("user").build());

        return new InMemoryUserDetailsManager(user);
    }
}
