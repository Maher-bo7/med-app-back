package  com.medapp.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import  com.medapp.api.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	
	Optional<Patient> findByEmail(String email);
	
	@Modifying
	@Query("update Patient p set p.fName = ?1, p.lName = ?2, p.address=?3, p.job=?4, p.email=?5, p.phone=?6, dateBirth=?7 where p.patient_id = ?8")
	void setPatientById( Patient p);
	
	
	
//	Optional<Patient> findPatientById(Long patient_id);
	
	

}