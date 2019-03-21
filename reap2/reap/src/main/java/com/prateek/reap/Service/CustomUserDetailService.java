package com.prateek.reap.Service;

import com.prateek.reap.Entity.User;
import com.prateek.reap.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetail")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = loginRepository.findByEmailAndActive(email, true);

        CustomUserDetails userDetails = null;
        if (user != null) {
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User not exist with username:" + email);
        }
        return userDetails;
    }
}


    /* if (isNull(user))
            throw new UsernameNotFoundException("User Does Not Exists"+email);

        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        for (UserRole userRole : user.getRoles()) {
            auths.add(new SimpleGrantedAuthority(userRole.getName()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                auths
        );
    }
}
*/

/*

        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        for (UserRole userRole : user1.getRoles()) {
            auths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

*/

