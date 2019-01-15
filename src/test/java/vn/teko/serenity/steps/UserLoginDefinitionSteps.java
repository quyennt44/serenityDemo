package vn.teko.serenity.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import vn.teko.serenity.steps.serenity.EndUserLoginSteps;

public class UserLoginDefinitionSteps {

    @Steps
    EndUserLoginSteps endUser;

    @Given("the user is on the login page")
    public void givenTheUserIsOnTheLoginPage() {
    	endUser.is_the_home_page();
    }

    @When("the user inputs his username as '(.*)'")
    public void whenTheUserInputHisUserName(String userName) {
    	endUser.inputUserName(userName);
    }

    @When("the user inputs his password as '(.*)'")
    public void whenTheUserInputHisPassword(String password) {
    	endUser.inputPassword(password);
    }
    
    @When("the user clicks the login button")
    public void whenTheUserClickSigninButton() {
    	endUser.signIn();
    }
    
    @Then("they should see the logout button")
    public void thenTheyShouldSeeTheLogoutButton() {
    	endUser.shouldSeeLogoutButton();
    }
    
    @Then("they should see the error message for username field")
    public void showUserNameValidationMessage() {
    	endUser.validateUserNameEmpty();
    }
    
    @Then("they should see the error message for password field")
    public void showPasswordValidationMessage() {
    	endUser.validatePasswordEmpty();
    }   
    
    @Then("they should see the error message '(.*)'")
    public void showWrongAccountMessage(String message) {
    	endUser.validateAccount(message);
    }      
    

}
