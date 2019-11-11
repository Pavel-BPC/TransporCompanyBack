package com.blinets.config.security;

import com.blinets.entity.User;
import com.blinets.services.imp.UserServiceSecurity;
import com.blinets.services.security.constant.Roles;
import com.blinets.services.security.filter.RequestBodyReaderAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@CrossOrigin
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserServiceSecurity userService;
  private final ObjectMapper objectMapper;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

  public WebSecurityConfig(UserServiceSecurity userService, ObjectMapper objectMapper,
      PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.objectMapper = objectMapper;
    this.passwordEncoder = passwordEncoder;
  }

  @Bean
  public RequestBodyReaderAuthenticationFilter authenticationFilter() throws Exception {
    RequestBodyReaderAuthenticationFilter authenticationFilter
        = new RequestBodyReaderAuthenticationFilter();
    authenticationFilter.setAuthenticationSuccessHandler(this::loginSuccessHandler);
    authenticationFilter.setAuthenticationFailureHandler(this::loginFailureHandler);
    authenticationFilter
        .setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    authenticationFilter.setAuthenticationManager(authenticationManagerBean());
    return authenticationFilter;
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userService);
    authProvider.setPasswordEncoder(passwordEncoder);
    return authProvider;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
//        .csrf().disable()
        .cors().disable()
        .authorizeRequests()

//        .antMatchers("/users").hasRole(Roles.USER_ROLE)

//        .anyRequest().hasRole(Roles.ADMIN_ROLE)
        .anyRequest().authenticated()


        .and()
        .addFilterBefore(
            authenticationFilter(),
            UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessHandler(this::logoutSuccessHandler)


        .and()
        .exceptionHandling()

        .authenticationEntryPoint(authenticationEntryPoint)

    ;
  }

//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    final CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowedOrigins(ImmutableList.of("*"));
//    configuration.setAllowedMethods(ImmutableList.of("HEAD",
//        "GET", "POST", "PUT", "DELETE", "PATCH"));
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
//  }

  private void loginSuccessHandler(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException {

    User loggedInUser = userService.findByLogin(authentication.getName())
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found: " + authentication.getName()));
    response.setStatus(HttpStatus.OK.value());
    objectMapper.writeValue(response.getWriter(), loggedInUser);
  }

  private void loginFailureHandler(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException e) throws IOException {

    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    objectMapper.writeValue(response.getWriter(), "Nopity nop!");
  }

  private void logoutSuccessHandler(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException {

    response.setStatus(HttpStatus.OK.value());
    objectMapper.writeValue(response.getWriter(), "Bye!");
  }
}
