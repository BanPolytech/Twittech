//package org.polytech.business;

import org.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Qualifier("userRepository")
//    @Autowired
//    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//
//        User user = userRepository.findByName(name);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User `" + name + "` was not found");
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new HashSet<>());
//    }
//
//}
