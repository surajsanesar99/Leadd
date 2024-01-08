package com.example.LeadWord.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LeadWord.entity.Lead;
import com.example.LeadWord.exception.LeadAlreadyExistsException;
import com.example.LeadWord.response.ApiResponse;
import com.example.LeadWord.response.ErrorResponse;
import com.example.LeadWord.service.LeadService;

@RestController
public class LeadController {

	@Autowired
	private LeadService leadService;

//	@PostMapping("/create")
//	public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
//		try {
//			Lead createdLead = leadService.createLead(lead);
//			return ResponseEntity.ok(new ApiResponse("success", "Created Leads Successfully"));
//		} catch (LeadAlreadyExistsException e) {
//			ErrorResponse errorResponse = new ErrorResponse("E10010", e.getMessage());
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("error", errorResponse));
//		}
//	}
	@PostMapping("/create")
	public Object createLead(Lead lead) {
		try {
			Lead createdLead = leadService.createLead(lead);
			return ResponseEntity.ok(new ApiResponse("success", "Created Leads Successfully"));
		} catch (LeadAlreadyExistsException e) {
			ErrorResponse errorResponse = new ErrorResponse("E10010", e.getMessage());

			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("error", errorResponse));
		}

	}
}
