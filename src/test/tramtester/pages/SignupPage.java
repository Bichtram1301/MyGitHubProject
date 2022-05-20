package src.test.tramtester.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src.test.tramtester.base.ValidateHelpers;

public class SignupPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;

    private By emailInput = By.xpath("//input[@id='user_login']");
    private By passwordInput = By.xpath("//input[@id='user_pass']");
    private By SignInbtn = By.xpath("//input[@id='wp-submit']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);

    }

    public DashboardPage signIn(String email, String password) {
        validateHelpers.waitForPageLoaded();
        validateHelpers.setText(emailInput, email);
        validateHelpers.setText(passwordInput, password);
        validateHelpers.clickElement(SignInbtn);

        driver.findElement(SignInbtn).click();

        return new DashboardPage(driver);
    }

}



