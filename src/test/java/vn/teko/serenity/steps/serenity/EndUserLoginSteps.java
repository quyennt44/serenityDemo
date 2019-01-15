package vn.teko.serenity.steps.serenity;

import static org.junit.Assert.assertEquals;

import net.thucydides.core.annotations.Step;
import vn.teko.serenity.pages.LogoutPage;
import vn.teko.serenity.pages.UserLoginPage;

public class EndUserLoginSteps {

    UserLoginPage userLoginPage;
    LogoutPage logoutPage;

    @Step
    public void inputUserName(String userName) {
    	userLoginPage.enterUserName(userName);
    }

    @Step
    public void inputPassword(String password) {
    	userLoginPage.enterPassword(password);
    }
    
    @Step
    public void signIn() {    	
    	userLoginPage.signin();
    }
    

    @Step
    public void shouldSeeLogoutButton() {    	
    	logoutPage.checkThatLogoutButtonIsVisible();
    }

    @Step
    public void is_the_home_page() {
    	userLoginPage.open();
    }

//    @Step
//    public void inputLoginDetail(String userName, String password) {
//        inputUserName(userName);
//        inputPassword(password);
//        userLoginPage.signin();
//    }
    
    @Step
    public void validateUserNameEmpty() {
    	assertEquals("Please fill out this field.", userLoginPage.checkUserNameErrorMessage());
    }   
    
    @Step
    public void validatePasswordEmpty() {
    	assertEquals("Please fill out this field.", userLoginPage.checkPasswordErrorMessage());
    } 
    
    @Step
    public void validateAccount(String message) {
    	assertEquals(message, userLoginPage.checkAccountErrorMessage());
    }  
    
    
}