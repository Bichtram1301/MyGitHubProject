package src.test.tramtester.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateHelpers {

    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;
    private String text;
    private By element;

    //Ham xay dung
    public ValidateHelpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    public void setText(By element, String value) {

        //sendKeys mot gia tri la value cho element truyen vao
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }

    public void clickElement(By element) {

        //click vao mot phan tu element truyen vao
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        //click cua selenium hoac click cua js executor
        //js.executeScript("arguments[0].click()", driver.findElement(element));
    }

    public void selectOptionByText(By selectDropDown, String automation_testing) {

        //Chuyen tu doi tuong By sang WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    //Hàm đợi trang load xong rồi thao tác
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }



}
