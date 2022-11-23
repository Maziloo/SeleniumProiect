package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
}

    @FindBy(id = "billing_first_name")
    private WebElement firstName;
    public WebElement getFirstName(){return firstName;}


    @FindBy(id = "billing_last_name")
    private WebElement lastName;
    public WebElement getLastName(){return lastName;}


    @FindBy(id = "billing_email")
    private WebElement email;
    public WebElement getEmail(){return email;}


    @FindBy(id = "billing_phone")
    private WebElement phone;
    public WebElement getPhone(){return phone;}


    @FindBy(id = "billing_country")
    private WebElement country;
    public WebElement getCountry(){return country;}


    @FindBy(id = "billing_address_1")
    private WebElement address;
    public WebElement getAddress1(){return address;}


    @FindBy(id = "billing_city")
    private WebElement city;
    public WebElement getCity(){return city;}


    @FindBy(id = "billing_postcode")
    private WebElement postCode;
    public WebElement getZIP(){return postCode;}


    @FindBy(id = "payment_method_cod")
    private WebElement paymentMethod;
    public WebElement getPaymentMethod(){return paymentMethod;}

    @FindBy(id = "place_order")
    private WebElement placeOrder;
    public WebElement getPlaceOrder(){return placeOrder;}
}
