package com.medapp.api.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
private final ConfirmationTokenRepository confirmationTokenRepository;
public void saveConfirmationToken(ConfirmationToken token){
    confirmationTokenRepository.save(token);
}
public Optional<ConfirmationToken> getToken(String token){
    Optional<ConfirmationToken> byToken = confirmationTokenRepository.findByToken(token);

    return byToken;
}
public void setConfirmedAl( ){

}
}
