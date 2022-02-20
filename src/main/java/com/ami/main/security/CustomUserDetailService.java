package com.ami.main.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ami.main.model.CustomUser;
import com.ami.main.repository.CustomUserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	CustomUserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		CustomUser user = userRepo.findByUserName(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("Username not found");
//		}
//		return new CustomUserDetails(user);
		String[][] userRecords = userRepo.getUserDetailsByUserName(username);
		if (userRecords.length == 0) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(userRecords);
	}

}
