package com.blinets.services.security;

import com.blinets.entity.User;
import com.blinets.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceSecurity {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceSecurity(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    userRepository.deleteAll();

    User user = new User(UUID.randomUUID().toString(),"user",passwordEncoder.encode("user"),"USER","");
    User admin = new User(UUID.randomUUID().toString(),"admin",passwordEncoder.encode("admin"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");

    userRepository.saveAll(Arrays.asList(user,admin));
  }


}
