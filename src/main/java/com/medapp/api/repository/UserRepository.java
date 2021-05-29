package com.medapp.api.repository;

import java.util.Optional;

import com.medapp.api.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.medapp.api.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	@Modifying
	@Query("update User u set u.enabled=true where u.email=?1")
	void setEnabledUser( String email);


}
