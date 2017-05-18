package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class OrderDetailsPage {

    private WebDriver driver;
    private By addClient = By.linkText("Adauga client");
    private By addClientButton = By.xpath(".//*[@id='search_contact_btn']/i");
    private By email = By.xpath("//input[@name='email']");
    private By selectClient = By.xpath("//i[@class='icon-check']");


    public OrderDetailsPage(WebDriver driver) { this.driver = driver; }

    private void setAddClient() { this.wait(addClient); }
    private void setAddClientButton() {
        WebElement frame = driver.findElement(By.id("changeCustomerIframe"));
        driver.switchTo().frame(frame);
        this.wait(addClientButton); }

    private void wait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    private void waitSendKeys(By by) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            this.wait(email);
            Config config = mapper.readValue(new File("src/config.yaml"), Config.class);
            driver.findElement(by).sendKeys(config.getEmail());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void addExistingClient() {
        try {
            this.waitSendKeys(email);
            this.wait(selectClient);
            driver.wait(5);
        } catch ( Exception exception) {
            exception.printStackTrace();
        }
    }

    public void addClient() {
        this.setAddClient();
        this.setAddClientButton();
        this.addExistingClient();
    }

}
