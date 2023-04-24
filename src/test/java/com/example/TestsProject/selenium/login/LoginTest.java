package com.example.TestsProject.selenium.login;


import com.example.TestsProject.selenium.models.TestLoginScreen;
import com.example.TestsProject.selenium.models.SuccessfulLoginScreen;
import com.example.TestsProject.selenium.utils.SeleniumParent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginTest extends SeleniumParent {

    @Parameterized.Parameters(name = "Test {index}. Input username: {0}; password: {1}")
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"incorrectStudent", "Password123"},
                {"student", "Password123"},
                {"student", "incorrectPassword"}
        });
    }
    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String pass;


    @Test
    public void testLogin() {
        TestLoginScreen loginScreen = new TestLoginScreen(getDriver());
        SuccessfulLoginScreen successfulLoginScreen = loginScreen.login(username, pass);
        if(username.equals("incorrectStudent")){
            Assert.assertEquals("Your username is invalid!", successfulLoginScreen.getErrorMessage());
        }else if (pass.equals("incorrectPassword")){
            Assert.assertEquals("Your password is invalid!", successfulLoginScreen.getErrorMessage());
        }
        else{
            Assert.assertEquals("Logged In Successfully", successfulLoginScreen.getTitle());
        }

    }

}
