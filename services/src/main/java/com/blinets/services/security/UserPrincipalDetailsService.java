package com.blinets.services.security;

import com.blinets.entity.User;
import com.blinets.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = this.userRepository.findByLogin(s);
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//
//        return userPrincipal;
//    }


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
