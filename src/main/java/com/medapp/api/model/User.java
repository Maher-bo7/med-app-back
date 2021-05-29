
package com.medapp.api.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

@Entity
@Table(name = "User", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email") })
public
class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	private String email;
	private String fName;
	private String lName;
	private String phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	private Boolean locked=false;
	private Boolean enabled =false;
	private Boolean isActive;

	public User(String email, String fName, String lName, String phone, String password, UserRole userRole) {
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.password = password;
		this.userRole = userRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
	 SimpleGrantedAuthority authority =
			 new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}

