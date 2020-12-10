package com.enrolee.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.enrolee.dto.Dependent;
import com.enrolee.exception.EnroleeException;
import com.enrolee.service.DependentService;
import io.swagger.annotations.Api;

@Validated
@Api(tags = "Dependent APIs")
@RestController
@RequestMapping(value = "/dependent")
public class DependentController {
	@Autowired
	private DependentService dependentService;

	@GetMapping(value="/{dependentId}")
	 public Dependent getDependent(@PathVariable Integer dependentId) {
		return dependentService.getDependentById(dependentId);
	} 
	
	@PostMapping
	 public Dependent createDependent(@RequestBody @Valid Dependent dependent) {
		return dependentService.createDependent(dependent);
	} 

	@PutMapping
	 public Dependent updateDependent(@RequestBody @Valid Dependent dependent) {
		return dependentService.updateDependent(dependent);
	} 
	
	@DeleteMapping(value="/{dependentId}")
	 public String deleteDependent(@PathVariable Integer dependentId) {
		
		dependentService.deleteDependent(dependentId);
		return "Deleteed dependent";
	}
	
	private void validateDependent(@Valid Dependent dependent, boolean isUpdate) {
		if(!StringUtils.hasText(dependent.getName())) {
			throw new EnroleeException("Dependent name cannot be empty or null");
		}
		if(dependent.getDob() == null) {
			throw new EnroleeException("Dependent Date of Birth cannot be empty or null");
		}		
		if(isUpdate && (dependent.getId() == null || dependent.getId() == 0)) {
			throw new EnroleeException("Id cannot be null or 0 for update");
		}
	}
}
