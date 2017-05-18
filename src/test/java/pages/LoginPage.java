package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.cssSelector("button");
    private By addNewOrder = By.linkText("Comanda noua");
    private By next = By.id("search-products");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void wait(By by) {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(addNewOrder)).click();

}

    private void setUsername(){
        driver.findElement(username).sendKeys("test.programareD");
    }

    private void setPassword(){
        driver.findElement(password).sendKeys("Programare2015?");
    }

    private void setSubmit() {
        driver.findElement(submit).click();
    }

    private void setNext() { driver.findElement(next).click(); }

    private void setAddNewOrder() {
    this.wait(addNewOrder);
//    wait.until(ExpectedConditions.elementToBeClickable(addNewOrder)).click();
    Select dropdownPlatform = new Select(driver.findElement(By.id("platformId")));
    dropdownPlatform.selectByVisibleText("eMAG.ro");
    }


    public void login(){
        this.setUsername();
        this.setPassword();
        this.setSubmit();
    }

    public void newOrder(){
        this.setAddNewOrder();
        this.setNext();
    }

//    public void setUrl() { driver.navigate().to();}

}
