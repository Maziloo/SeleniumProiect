package sel;

import ObjectPage.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PageObjectTest extends BaseTest{

    @Test
    public void PageObjectTest() throws InterruptedException {
        ShopPage shopPage = new ShopPage(driver);
        // Click on Shop Menu
        shopPage.getShopButton().click();
        Thread.sleep(3000);
        /*
        inchidere pop-up, daca exista probleme, de exemplu daca fereastra de pop-up nu este deschisa,
            se poate comenta codul sau se poate comenta si apoi schimba pe firefox din app properites,
                care, in testele mele nu a deschis deloc o fereastra pop-up
        */
        FramePage frame1 = new FramePage(driver);
        driver.switchTo().frame(frame1.getFrameElement());
        frame1.getDismiss().click();

        // Now click on Home menu button
        shopPage.getHomeButton().click();

        // Test whether the Home page has Three Arrivals only
        HomePage homePage = new HomePage(driver);
        assertEquals(3,homePage.getNewArrivals().size());

        // Now click on one of the images in Arrivals
        homePage.getNewArrivals().get(2).click();
        Thread.sleep(2000);

        // Click on the ADD TO BASKET button
        BookPage bookPage = new BookPage(driver);
        bookPage.getAddBasketButton().click();
        Thread.sleep(2000);

        // Test whether the VIEW BASKET button is visible and click on it
        Assert.assertTrue(bookPage.getViewBasket().isDisplayed());
        bookPage.getViewBasket().click();


        // Now user can find total and subtotal values just above the Proceed to Checkout button, test if the total is greater than the subtotal
        BasketPage basketPage = new BasketPage(driver);
        String subtotalText = basketPage.getSubtotal().getText();
        String subtotalNumberOnly = subtotalText.replaceAll("[^-.0-9]", "");
        String totalText = basketPage.getTotal().getText();
        String totalNumberOnly = totalText.replaceAll("[^-.0-9]", "");
        double subtotal = Double.parseDouble(subtotalNumberOnly);
        double total = Double.parseDouble(totalNumberOnly);
        Assert.assertTrue(total>subtotal);

        // Click the PROCEED TO CHECKOUT button
        basketPage.getProceedButton().click();

        // Fill in all required fields, set Cash on Delivery as your payment method, and click PLACE ORDER.
        CheckoutPage billingPage = new CheckoutPage(driver);
        billingPage.getFirstName().sendKeys("Eduard");
        billingPage.getLastName().sendKeys("Mazilescu");
        billingPage.getEmail().sendKeys("edymazilescu@gmail.com");
        billingPage.getPhone().sendKeys("0746892270");
        Select sel1 =new Select(billingPage.getCountry());
        sel1.selectByValue("RO");
        billingPage.getAddress1().sendKeys("Str.Burebista");
        billingPage.getCity().sendKeys("Pitesti");
        billingPage.getZIP().sendKeys("110236");
        billingPage.getPaymentMethod().click();
        billingPage.getPlaceOrder().click();
        Thread.sleep(4000);

        OrderPage orderPage = new OrderPage(driver);
        System.out.println(driver.getCurrentUrl());
        String text1 = orderPage.getPayment1().getText();
        System.out.println(text1);
        String text2 = orderPage.getPayment2().getText();
        System.out.println(text2);
        assertEquals(text1,text2);


    }


}
