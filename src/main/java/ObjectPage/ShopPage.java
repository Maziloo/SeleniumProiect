package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends BasePage{
    public ShopPage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);

    }
    @FindBy(xpath = "//*[@id=\"content\"]/nav/a")

    private WebElement homeButton;
    public WebElement getHomeButton(){
        return homeButton;
    }

}
