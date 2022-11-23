package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    private WebDriver webDriver;

    BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @FindBy(id = "menu-item-40")
    private WebElement ShopButton;

    public WebElement getShopButton(){
        return ShopButton;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }
}
