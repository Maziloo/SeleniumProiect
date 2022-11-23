package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"page-35\"]/div/div[1]/ul/li[4]/strong")
    private WebElement paymentMethod1;

    public WebElement getPayment1(){return paymentMethod1;}

    @FindBy(xpath = "//*[@id=\"page-35\"]/div/div[1]/table/tfoot/tr[3]/td")
    private WebElement paymentMethod2;

    public WebElement getPayment2(){return paymentMethod2;}

}
