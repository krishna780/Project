package com.enrolee.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dependent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	@NotEmpty(message = "name cannot be empty/null")
	public String name;
	@NotEmpty(message = "Date of birth cannot be empty/null")
	public Date dob;
	public Integer enrolee_id;
	
}
