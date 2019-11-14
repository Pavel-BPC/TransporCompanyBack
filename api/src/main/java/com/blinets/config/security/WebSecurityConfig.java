package com.blinets.config.security;

import com.blinets.services.security.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final MyBasicAuthenticationEntryPoint authenticationEntryPoint;
  private UserPrincipalDetailsService userPrincipalDetailsService;

  @Autowired
  public WebSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService,
      MyBasicAuthenticationEntryPoint authenticationEntryPoint) {
    this.userPrincipalDetailsService = userPrincipalDetailsService;
    this.authenticationEntryPoint = authenticationEntryPoint;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.NEVER)

        .and()
        .csrf().disable()
        .cors().and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**", "/swagger-ui.html").permitAll()
        .antMatchers("/login").authenticated()
        .antMatchers("/point", "/user/**").hasRole("ADMIN")
        .antMatchers("/userseeee").hasRole("USER")
//        .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
//        .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
//        .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
//        .antMatchers("/api/public/users").hasRole("ADMIN")
        .and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint);
  }

  @Bean
  DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

    return daoAuthenticationProvider;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


}
