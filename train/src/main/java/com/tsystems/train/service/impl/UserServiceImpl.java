package com.tsystems.train.service.impl;

import com.tsystems.train.entity.Role;
import com.tsystems.train.entity.User;
import com.tsystems.train.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name)
                .map(this::toUserDetails)
                .orElse(anonymousUser(name));
    }

    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .authorities("ROLE_" + user.getRole().toString())
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }

    private UserDetails anonymousUser(String name) {
        return org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .authorities("ROLE_" + Role.ANONYMOUS)
                .username(name)
                .password("")
                .build();
    }
}

