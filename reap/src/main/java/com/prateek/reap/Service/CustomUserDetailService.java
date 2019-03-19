package com.prateek.reap.Service;

import com.prateek.reap.Entity.User;
import com.prateek.reap.Entity.UserRole;
import com.prateek.reap.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service("userDetail")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User>  user = null;
      user = loginRepository.findByEmail(email);

    User user1=user.get();
        if (isNull(user))
            throw new UsernameNotFoundException("User Does Not Exists");

        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        for(UserRole userRole:user1.getRoles())
        {
            auths.add(new SimpleGrantedAuthority(userRole.getName()));
        }
       /* auths.add(new SimpleGrantedAuthority("ROLE_" + user1.getRoles()
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.toSet())
        ));*/
        return new org.springframework.security.core.userdetails.User(
                user1.getEmail(),
                user1.getPassword(),
                true,
                true,
                true,
                true,
                auths
        );
    }
}

