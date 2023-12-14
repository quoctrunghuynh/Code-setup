package com.trunghuynh.auth.entity;

import lombok.RequiredArgsConstructor;

import jakarta.transaction.Transactional;

import com.trunghuynh.auth.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + "was not found in database!");
        }
        Set<Role> roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roles == null) roles =  new HashSet<>();
        for (Role role: roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            grantedAuthorities.add(authority);
        }

        return new CurrentUserServiceImpl(user.getId(), user.getEmail(), user.getPassword(), user.getUserName(), grantedAuthorities);
    }
}
