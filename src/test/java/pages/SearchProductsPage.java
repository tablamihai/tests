package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Config;
import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class SearchProductsPage {

    private WebDriver driver;
    private By isStock = By.id("eis_orderbundle_addproducts_search_in_stock");
    private By isAvaliable = By.id("eis_orderbundle_addproducts_search_is_available");
    private By isResealed = By.id("eis_orderbundle_addproducts_search_exclude_resealed");
    private By isPartNumber = By.id("eis_orderbundle_addproducts_search_part_number");
    private By productSearchBar = By.xpath(".//*[@id='eis_orderbundle_addproducts_search_name_part_number']");
    private By checkbox = By.className("product-select-checkbox");
    private By search = By.id("search-products");
    private By returnToOrderCheckbox = By.id("return-to-order-checkbox");
    private By returnToOrder = By.name("add-products-submit");

    public SearchProductsPage(WebDriver driver){ this.driver = driver; }

    private void setIsStock() { driver.findElement(isStock).click(); }
    private void setIsAvaliable() { driver.findElement(isAvaliable).click(); }
    private void setIsResealed() { driver.findElement(isResealed).click(); }
    private void setIsPartnumber() { driver.findElement(isPartNumber).click(); }
    private void setSearch() { driver.findElement(search).click(); }
    private void setReturnToOrderCheckbox() {
        driver.findElement(returnToOrderCheckbox).click();
        driver.findElement(returnToOrder).click();
    }

    private void setProductSearchBar() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config config = mapper.readValue(new File("src/config.yaml"), Config.class);
            driver.findElement(productSearchBar).sendKeys(config.getPartnumber());
//            System.out.print(config.getPartnumber());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
    }

    public void checkAll() {
        this.setIsStock();
        this.setIsAvaliable();
        this.setIsResealed();
        this.setIsPartnumber();
        this.setProductSearchBar();
        this.setSearch();
        this.setCheckbox();
        this.setReturnToOrderCheckbox();

    }
}
