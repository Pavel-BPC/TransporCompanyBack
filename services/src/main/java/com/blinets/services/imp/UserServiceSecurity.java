package com.blinets.services.imp;

import com.blinets.entity.User;
import com.blinets.repository.UserRepository;
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
public class UserServiceSecurity implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceSecurity(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    userRepository.deleteAll();
    User user = new User();
    user.setIdUser(UUID.randomUUID().toString());
    user.setLogin("user");
    user.setPassword(passwordEncoder.encode("user"));
//    List<String> objects = new ArrayList<>();
//    objects.add("USER");
    user.setRoles("USER");

    User admin = new User();
    admin.setIdUser(UUID.randomUUID().toString());
    admin.setLogin("admin");
    admin.setPassword(passwordEncoder.encode("admin"));
//    objects.add("DETONATOR");
    admin.setRoles("ADMIN");

    userRepository.save(admin);
    userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    User loggedInUser = findByLogin(login)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));

    List<SimpleGrantedAuthority> simpleGrantedAuthorities = Stream.of(loggedInUser.getRoles())
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
    System.out.println(loggedInUser.getLogin());
    System.out.println(loggedInUser.getPassword());
    return new org.springframework.security.core.userdetails.User(loggedInUser.getLogin(),
        loggedInUser.getPassword(), simpleGrantedAuthorities);
  }

  public Optional<User> findByLogin(String login) {
    return Optional.ofNullable(userRepository.findByLogin(login));
  }

}
