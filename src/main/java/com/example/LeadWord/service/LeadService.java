package com.example.LeadWord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LeadWord.entity.Lead;
import com.example.LeadWord.exception.LeadAlreadyExistsException;
import com.example.LeadWord.repository.LeadRepository;

@Service
public class LeadService {


    @Autowired
    private LeadRepository leadRepository;

    public Lead createLead(Lead lead) {
        if (leadRepository.existsByLeadId(lead.getLeadId())) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the lead id");
        }

        if (leadRepository.existsByEmail(lead.getEmail())) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the email");
        }

        // Perform other validations if necessary

        return leadRepository.save(lead);
    }

}
