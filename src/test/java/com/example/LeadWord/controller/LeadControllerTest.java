package com.example.LeadWord.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.LeadWord.contoller.LeadController;
import com.example.LeadWord.entity.Lead;
import com.example.LeadWord.response.ApiResponse;
import com.example.LeadWord.service.LeadService;

@ExtendWith(MockitoExtension.class)
public class LeadControllerTest {

    @InjectMocks
    private LeadController leadController;

    @Mock
    private LeadService leadService;

    @Test
    public void testCreateLead_Success() {
        // Arrange
        Lead newLead = new Lead();
        newLead.setLeadId((long) 5678);
        newLead.setFirstName("Vineet");
        newLead.setLastName("KV");
        newLead.setMobileNumber(8877887788L);
        newLead.setGender("Male");
        newLead.setDob(new Date());
        newLead.setEmail("v@gmail.com");

        when(leadService.createLead(any(Lead.class))).thenReturn(newLead);

        // Act
        ResponseEntity<?> responseEntity = (ResponseEntity<?>) leadController.createLead(newLead);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.getStatus());
        assertEquals("Created Leads Successfully", apiResponse.getData());

        // Verify that the service method was called
        verify(leadService, times(1)).createLead(any(Lead.class));
    }
}
