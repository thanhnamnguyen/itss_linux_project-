/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.secretnote.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Administrator
 */
@EnableWebSecurity
public class WebSecureConf {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .antMatchers("/home").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/mylogin")
                .failureUrl("/mylogin?error=true")
                .defaultSuccessUrl("/home")
                .and().csrf().disable();
        ;
        // @formatter:on

        return http.build();
    }

    // error when have 2 bean for UserDetailsService
//    @Bean
//    public UserDetailsService users() {
//
//        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        UserDetails user = User.withUsername("siva")
//				.password("{noop}secret")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//
//	}
}
