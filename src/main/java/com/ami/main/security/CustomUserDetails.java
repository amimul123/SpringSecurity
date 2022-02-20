package com.ami.main.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ami.main.model.CustomUser;


public class CustomUserDetails implements UserDetails {
	
	private int id;
	private String userName;
	private String password;
	private int isActive;
	private List<GrantedAuthority> roles;
	
	// mapping by user object -- JPA auto generated query
	public CustomUserDetails(CustomUser user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.getIsActive();
		this.id = user.getId();
		this.roles = new ArrayList<GrantedAuthority>();
		for (String role : user.getRoles().split(",")) {
			this.roles.add(new SimpleGrantedAuthority(role));
		}
		
	}
	
	// mapping by 2D string -- custom query
	public CustomUserDetails(String [][] userRecords) {
		for (String[] userRecord : userRecords) {
			if (this.userName == null) {
				this.roles = new ArrayList<GrantedAuthority>();
				this.userName = userRecord[0];
				this.password = userRecord[1];
				this.isActive = Integer.parseInt(userRecord[2]);
				this.roles.add(new SimpleGrantedAuthority(userRecord[3]));
			}
			else if(this.userName == userRecord[0]) {
				this.roles.add(new SimpleGrantedAuthority(userRecord[3]));
			}
		}
		
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// hard code value
		//List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		//authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return (this.isActive == 1) ? true: false;
	}

}
