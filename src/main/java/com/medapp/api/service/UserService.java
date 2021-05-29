package com.medapp.api.service;

import com.medapp.api.model.User;
import com.medapp.api.registration.token.ConfirmationToken;
import com.medapp.api.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.medapp.api.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
	private final static String USER_NOT_FOUND_MSG="user with %s not found";

	private final UserRepository userRepository ;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	@Override
	public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
	}

	public String signUpUser(User user){
		boolean userExists = userRepository.findByEmail(user.getUsername()).isPresent();
		if (userExists) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
//todo: send confirmation token
		String token= UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),null,
				user
		);
	confirmationTokenService.saveConfirmationToken(confirmationToken );
	// todo send email

		return token;
	}

	public void enableUser(String email){
	userRepository.setEnabledUser(email);

	}
}
