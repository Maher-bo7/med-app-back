package com.medapp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medapp.api.exception.PatientNotFoundException;
import com.medapp.api.model.Patient;
import com.medapp.api.repository.PatientRepository;

@Service
public class PatientServicesImpl implements PatientServices {

	private final PatientRepository patientRepository;

	@Autowired
	public PatientServicesImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public void savePatient(Patient P) {
		// TODO Auto-generated method stub
		patientRepository.save(P);
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public void updatePatient(Patient p) {
		// TODO Auto-generated method stub
		patientRepository.setPatientById(p);
		;
	}

	@Override
	public void deletePatientById(Long patient_id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(patient_id);
	}

	@Override
	public Patient getPatientById(Long patient_id) {
		return patientRepository.findById(patient_id)
				.orElseThrow(() -> new PatientNotFoundException("Patient with id=" + patient_id + " not found"));
	}

}
