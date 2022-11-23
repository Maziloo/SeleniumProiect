package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends BasePage{
    public FramePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }
    @FindBy(xpath = "/html/ins/ins/ins/iframe")
    private WebElement frame2;
    public WebElement getFrameElement(){
        return frame2;
    }
    @FindBy(id = "dismiss-button")
    private WebElement dismiss;
    public WebElement getDismiss(){
        return dismiss;
    }
}
