package com.example.TestsProject.service;

import com.example.TestsProject.models.Email;
import com.example.TestsProject.repo.IEmailRepo;

import java.util.regex.Pattern;

public class ChangeEmailService {
    public static final String OK = "OK";
    public static final String NOT_VALID_EMAIL = "Email is not valid!";
    public static final String ALREADY_EXISTING_EMAIL = "Email is already existing";
    private final IEmailRepo emailRepo;

    public ChangeEmailService(final IEmailRepo emailRepo) {
        this.emailRepo = emailRepo;
    }

    public String changeEmail(String email) {
        if(email == null) return NOT_VALID_EMAIL;
        String regexPattern = "^(.+)@(\\S+)$";
        boolean isValidEmail = Pattern.compile(regexPattern)
                .matcher(email)
                .matches();

        if(!isValidEmail){
            return NOT_VALID_EMAIL;
        }
        Email existingEmail = emailRepo.findByEmail(email);
        return existingEmail != null? ALREADY_EXISTING_EMAIL : OK;

    }
}
