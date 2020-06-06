package com.company.security;

import com.company.config.Config;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 17/05/2020
 * Time: 05:06
 */
@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userServiceImplData")
    private UserServiceInter userServiceInter;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userServiceInter.getByEmail(email);
        UserBuilder userBuilder = null;
        if (user != null) {
            Config.addUser(user);
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(user.getPassword());
            userBuilder.authorities("ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return userBuilder.build();
    }
}
