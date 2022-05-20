package src.test.tramtester.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import src.test.tramtester.base.ValidateHelpers;
import src.test.tramtester.pages.DashboardPage;
import src.test.tramtester.pages.SignupPage;

public class SingInTest {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignupPage signupPage;
    private DashboardPage dashboardPage;
    private By loginbtn = By.xpath("//a[contains(text(),'Log in with username and password')]");
    //private By selectDropDown = By.id("dropdown");

    @Test
    public void abc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        validateHelpers = new ValidateHelpers(driver);

        signupPage = new SignupPage(driver);

        driver.get("https://www.24htuhoc.com/wp-login.php?redirect_to=https%3A%2F%2Fwww.24htuhoc.com%2Fwp-admin%2Fadmin.php%3Fpage%3Dgooglesitekit-dashboard&reauth=1");
        validateHelpers.waitForPageLoaded();
        validateHelpers.clickElement(loginbtn);

        signupPage.signIn("bichtram13197@gmail.com", "01675754800");

        //validateHelpers.selectOptionByText(selectDropDown, "Automation Testing");

        Thread.sleep(2000);
        driver.quit();





    }

}
