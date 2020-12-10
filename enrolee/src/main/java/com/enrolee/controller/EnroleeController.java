package com.enrolee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.enrolee.dto.Enrolee;
import com.enrolee.service.EnroleeService;

import io.swagger.annotations.Api;


@Validated
@Api(tags = "Enrolee APIs")
@RestController
@RequestMapping(value = "/enrolee")
public class EnroleeController {
	
	@Autowired
	private EnroleeService enroleeService;

	@GetMapping(value="/{enroleeId}")
	 public Enrolee getEnrolee(@PathVariable Integer enroleeId) {
		return enroleeService.getEnroleeById(enroleeId);
	} 
	
	@PostMapping
	 public Enrolee createEnrolee(@RequestBody @Valid Enrolee enrolee) {
		return enroleeService.createEnrolee(enrolee);
	 } 
	
	@PutMapping
	 public String updateEnrolee(@RequestBody @Valid Enrolee enrolee) {
		enroleeService.updateEnrolee(enrolee);
	        return "Update Enrolee";
	    } 
	
	@DeleteMapping(value="/{enroleeId}")
	 public String deleteEnrolee(@PathVariable Integer enroleeId) {
		enroleeService.deleteEnrolee(enroleeId);
	        return "Delete Enrolee";
	    } 
	
}
