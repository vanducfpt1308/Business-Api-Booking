package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.Users;
import com.example.businessapibooking.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users user = userRepo.findByUsername(username);
		System.out.println(user);
		if(user == null) {
			throw new UsernameNotFoundException("Acount không tồn tại");
		}
		String password = user.getPassword();
		String[] roles = {user.getRole().getRole()};
//		String[] roles = user.getUserole().stream().map(rn -> rn.getRole().getName())
//							.collect(Collectors.toList()).toArray(new String[0]);
		return User.withUsername(username).password(password).roles(roles).build();
	}
}




























