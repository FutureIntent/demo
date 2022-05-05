package com.example.demo.security;

import com.example.demo.user.model.myUser;
import com.example.demo.user.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private user_repository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final myUser user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails foundUser = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(user.getRole()).accountLocked(user.getBlackListed()).build();
        return foundUser;
    }
}