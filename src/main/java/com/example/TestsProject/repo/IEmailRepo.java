package com.example.TestsProject.repo;

import com.example.TestsProject.models.Email;

public interface IEmailRepo {
    Email findByEmail(String email);
}
