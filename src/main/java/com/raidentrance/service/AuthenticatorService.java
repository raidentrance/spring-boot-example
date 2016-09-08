/**
 * 
 */
package com.raidentrance.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raidentrance.entities.User;
import com.raidentrance.repositories.UserRepository;

/**
 * @author raidentrance
 *
 */
@Service
public class AuthenticatorService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticatorService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.info("Trying to authenticate to {}", username);
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		} else {
			Collection<? extends GrantedAuthority> authorities = getGrantedAuthorities(user);
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
		}
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthority() {
			private static final long serialVersionUID = 2409931876244987359L;

			@Override
			public String getAuthority() {
				return user.getRole().getName();
			}
		});
		return list;
	}

}
