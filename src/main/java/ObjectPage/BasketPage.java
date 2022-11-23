package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(xpath = "//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']")
    private WebElement subTotal;

    public WebElement getSubtotal(){
        return subTotal;
    }

    @FindBy(xpath = "//strong//span[@class='woocommerce-Price-amount amount']")
    private WebElement total;

    public WebElement getTotal(){
        return total;
    }

    @FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
    private WebElement Proceed;

    public WebElement getProceedButton(){
        return Proceed;
    }

}
