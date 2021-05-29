package com.medapp.api.registration.token;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>{
Optional <ConfirmationToken> findByToken(String token);
    @Modifying
    @Query("update ConfirmationToken set confirmedAt = ?#{T(java.sql.Timestamp).valueOf(T(java.time.LocalDateTime).now())} where token=?1")

    void setConfirmationAt( String token);
}
