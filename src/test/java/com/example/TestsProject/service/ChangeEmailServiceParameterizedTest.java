package com.example.TestsProject.service;

import com.example.TestsProject.repo.IEmailRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class ChangeEmailServiceParameterizedTest {
    IEmailRepo repo = mock(IEmailRepo.class);
    ChangeEmailService changeEmailService = new ChangeEmailService(repo);

    @Parameterized.Parameters(name = "Test {index}. Input email: {0}; expected message: {1}")
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"myValidEmail@gmail.com", ChangeEmailService.OK},
                {"invalidEmail", ChangeEmailService.NOT_VALID_EMAIL},
                {"", ChangeEmailService.NOT_VALID_EMAIL},
                {null, ChangeEmailService.NOT_VALID_EMAIL},
        });
    }
    @Parameterized.Parameter
    public String email;
    @Parameterized.Parameter(1)
    public String expectedMessage;

    @Test
    public void testLogin(){
        final String result = changeEmailService.changeEmail(email);
        assertEquals(expectedMessage, result);
    }

}
