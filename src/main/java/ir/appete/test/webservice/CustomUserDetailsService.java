package ir.appete.test.webservice;

import ir.appete.test.webservice.persistant.entity.UserEntity;
import ir.appete.test.webservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by  sajad on 5/29/18
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;



    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        try {
            UserEntity user = userService.readUserByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException(
                        "No user found with username: " + username);
            }

            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            boolean active=true;
            return new User(
                    user.getUsername(),
                    user.getPassword(),
                    active,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    grantedAuthorities);
        } catch (UsernameNotFoundException e) {
            throw new RuntimeException("user not found");
        }
    }
}