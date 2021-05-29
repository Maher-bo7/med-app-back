package  com.medapp.api.service;


import java.util.List;

import  com.medapp.api.model.Patient;



public interface PatientServices {

	 void savePatient( Patient p);
	 List<Patient> getAllPatients();
	 Patient getPatientById( Long id_patient);
	 void updatePatient( Patient p);
	 void deletePatientById( Long patient_id);
	
	
	
}
