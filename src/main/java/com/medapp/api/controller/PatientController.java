package com.medapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medapp.api.exception.PatientNotFoundException;
import com.medapp.api.model.Patient;
import com.medapp.api.service.PatientServices;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private final PatientServices patientServices;

	@Autowired
	public PatientController(PatientServices patientServices) {
		this.patientServices = patientServices;
	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		patientServices.savePatient(patient);
		return new ResponseEntity<>(patient, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = patientServices.getAllPatients();
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{patient_id}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatientById(@PathVariable("patient_id") Long patient_id) {

		try {
			Patient patient = patientServices.getPatientById(patient_id);
			return new ResponseEntity<>(patient, HttpStatus.OK);
		} catch (PatientNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		patientServices.updatePatient(patient);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{patient_id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePatientById(@PathVariable("patient_id") Long patient_id) {
		patientServices.deletePatientById(patient_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
