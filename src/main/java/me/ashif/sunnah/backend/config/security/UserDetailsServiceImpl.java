package me.ashif.sunnah.backend.config.security;

import me.ashif.sunnahaday.backend.UserRepository;
import me.ashif.sunnahaday.backend.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//	private final UserRepository userRepository;
//
//	@Autowired
//	public UserDetailsServiceImpl(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(username);
//		if (null == user) {
//			throw new UsernameNotFoundException("No user present with username: " + username);
//		} else {
//			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//					Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
//		}
//	}
}
