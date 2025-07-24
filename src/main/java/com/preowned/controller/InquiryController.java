package com.preowned.controller;

import com.preowned.model.Inquiry;
import com.preowned.service.EmailService;
import com.preowned.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/inquiry")
    public String handleInquirySubmission(@ModelAttribute Inquiry inquiry, RedirectAttributes redirectAttributes) {
        inquiryService.saveInquiry(inquiry);
        emailService.sendInquiryEmail("dhkcarsdvg@gmail.com", inquiry);
        redirectAttributes.addFlashAttribute("message", "✅ Your inquiry has been submitted successfully!");
        return "redirect:/#contact";
    }
}
