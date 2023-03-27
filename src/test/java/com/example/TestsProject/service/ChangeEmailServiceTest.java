package com.example.TestsProject.service;

import com.example.TestsProject.models.Email;
import com.example.TestsProject.repo.IEmailRepo;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.anyString;

public class ChangeEmailServiceTest {
    IEmailRepo repo = mock(IEmailRepo.class);
    ChangeEmailService changeEmailService = new ChangeEmailService(repo);


    @Test
    public void testChangeEmailWithValidEmail() {
        final String result = changeEmailService.changeEmail("myEmail@gmail.com");
        assertEquals("OK", result);
    }

    @Test
    public void testChangeEmailWithInValidEmail() {
        final String result = changeEmailService.changeEmail("ivan");
        assertEquals("Email is not valid!", result);
    }

    @Test
    public void testChangeEmailWithExistingEmail() {
        doReturn(new Email()).when(repo).findByEmail(anyString());
        final String result = changeEmailService.changeEmail("myExistingEmail@gmail.com");
        assertEquals("Email is already existing", result);
    }

}
