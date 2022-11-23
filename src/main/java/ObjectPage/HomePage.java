package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(css = ".woocommerce")
    private List<WebElement> NewArrivals;

    public List<WebElement> getNewArrivals(){
        return NewArrivals;
    }
}
