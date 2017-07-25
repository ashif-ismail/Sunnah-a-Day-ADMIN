package me.ashif.sunnah.backend.service;

import me.ashif.sunnah.backend.model.User;
import me.ashif.sunnah.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by Ashif on 17/7/17.
 * github.com/SheikhZayed
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
        }
    }

    public String encodePassword(String value) {
        return passwordEncoder.encode(value);
    }

    public Page<User> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return userRepository.findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(repositoryFilter,
                    repositoryFilter, repositoryFilter, pageable);
        } else {
            return find(pageable);
        }
    }

    public Page<User> find(Pageable pageable) {
        return userRepository.findBy(pageable);
    }
}
