package com.blinets.services.security;

import com.blinets.dto.ROLE;
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

    User user = new User("cbd29f42-a5cc-4e9c-a906-8b2e842244db","user",passwordEncoder.encode("user"), "USER");
    User admin = new User("f813bf5b-d797-4285-84c5-eabda5154268","admin",passwordEncoder.encode("admin"),"ADMIN");
    User carrier = new User("9cc3a063-8ba1-4321-9204-5d1bf3b67520","carrier",passwordEncoder.encode("carrier"),"CARRIER");

    userRepository.saveAll(Arrays.asList(user,admin,carrier));
  }


}
