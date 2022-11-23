package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BasePage{
    public BookPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(css = "button[type='submit']")
    private WebElement AddToBasketButton;
    public WebElement getAddBasketButton(){
        return AddToBasketButton;
    }


    @FindBy(css = ".button.wc-forward")
    private WebElement ViewBasket;
    public WebElement getViewBasket(){
        return ViewBasket;
    }

}
