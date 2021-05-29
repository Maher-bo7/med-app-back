package  com.medapp.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Patient", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email") })
	
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private	Long  patient_id ;

private String fName;
private String	  lName ;
private String  address ;
private String  phone ;
private String  job ;
private String	  email;
private Date  dateBirth ;
public Patient(String fName, String lName, String address, String phone, String email, Date dateBirth, String job) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.address = address;
	this.phone = phone;
	this.phone = job;
	this.email = email;
	this.dateBirth = dateBirth;
}



	
	
	
}
