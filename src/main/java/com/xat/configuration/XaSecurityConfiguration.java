package com.xat.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.xat.security.authentication.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class XaSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService mongoUserDetails() {
//        return new XaUserDetailsService();
//    }
    @Autowired
    UserDetailsService mongoUserDetails;
    
    @Autowired
	private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        UserDetailsService userDetailsService = mongoUserDetails();
//        auth.userDetailsService(userDetailsService);
        
        auth.userDetailsService(mongoUserDetails);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .antMatchers("/**")
//            .antMatchers("/users/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().antMatcher("/**")
    		.authorizeRequests()
    		.antMatchers("/users").hasAnyAuthority("ADMIN")
            .antMatchers("/management").hasAnyAuthority("ADMIN")
            .anyRequest().authenticated()
            .and().httpBasic()
            .authenticationEntryPoint(authEntryPoint)
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

}