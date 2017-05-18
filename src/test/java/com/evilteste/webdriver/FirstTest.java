package com.evilteste.webdriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Config;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.SearchProductsPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private SearchProductsPage searchProduct;
    private OrderDetailsPage orderDetailsPage;
    private Config config;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://s18.eis-rbh.eis-all5303-all-dev.om1.c.emag.network/ieis/ro/order-details/1002360835");
//        driver.get("http://mihai-tabla-dev.eis-rbh.eis-all8596-all-dev.om1.c.emag.network/ieis");
    }

    @Test
    public void startWebDriver(){

        loginPage  = new LoginPage(driver);
        loginPage.login();
//        loginPage.newOrder();

//        searchProduct = new SearchProductsPage(driver);
//        searchProduct.checkAll();

        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.addClient();

    }
}
