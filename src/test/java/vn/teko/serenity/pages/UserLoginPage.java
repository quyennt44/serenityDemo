package vn.teko.serenity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://test-counter-em.teko.vn/login/")
public class UserLoginPage extends PageObject {

	
    @FindBy(name="username")
    private WebElementFacade usernameInput;

    @FindBy(name="password")
    private WebElementFacade passwordInput;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade signinButton;
    
    @FindBy(xpath="//*[contains(text(), 'Thông tin người dùng hoặc mật khẩu không hợp lệ')]")
    private WebElementFacade wrongAccountMessage;
    

    public void enterUserName(String userName) {
    	usernameInput.type(userName);    	
    }
    
    public void enterPassword(String password) {
    	passwordInput.type(password);
    }    

    public void signin() {    	
    	signinButton.click();
    }
    
     
    public String checkUserNameErrorMessage() {
    	String message = (String) evaluateJavascript("return arguments[0].validationMessage;",usernameInput);    	
    	System.out.println("Error message:" + message);
    	return message;   	
    }
    
    public String checkPasswordErrorMessage() {
    	String message = (String) evaluateJavascript("return arguments[0].validationMessage;",passwordInput);    	
    	System.out.println("Error message:" + message);
    	return message;   	
    }    
    
    public String checkAccountErrorMessage() {
    	String errorMessage = wrongAccountMessage.getText();
    	System.out.println("account message:" + errorMessage);
    	return errorMessage;
    }
    
}


