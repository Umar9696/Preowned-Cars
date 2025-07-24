package com.preowned.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preowned.model.Inquiry;
import com.preowned.repository.InquiryRepository;

@Service
public class InquiryService {

	
	 @Autowired
	    private InquiryRepository inquiryRepo;

	    public void saveInquiry(Inquiry inquiry) {
	        inquiryRepo.save(inquiry);
	    }

	    public List<Inquiry> getAllInquiries() {
	        return inquiryRepo.findAll();
	    }
}
