package vn.teko.serenity.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://test-counter-em.teko.vn/")
public class LogoutPage extends PageObject {

    @FindBy(xpath="//a[contains(@href, '/logout/')]")
    private WebElementFacade logoutButton;
 
    public void checkThatLogoutButtonIsVisible() {
        element(logoutButton).shouldBeVisible();
    }
}