package sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import java.io.IOException;
import java.util.List;

public class TemaSelenium extends BaseTest{

//    @Before
//    public void setUp() throws IOException {
//
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.get("http://practice.automationtesting.in/");
//        driver.manage().window().maximize();
//
//    }

    @Test
    public void mainTest() throws InterruptedException {
        // Click on Shop Menu
        driver.findElement(By.id("menu-item-40")).click();
        //Thread.sleep(7000);
        /*
        code to close pop-up if it appears, in my tests it didn't happen, don on firefox
        */
        Thread.sleep(5000);
        /*
        //WebElement frame1 = driver.findElement(By.xpath("/html/ins/ins/ins/iframe"));
        //driver.switchTo().frame(frame1);
        //Thread.sleep(7000);
        //driver.findElement(By.id("dismiss-button")).click();
        //driver.switchTo().defaultContent();
        //Thread.sleep(3000);
        */
        // Now click on Home menu button
        driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
        // Test whether the Home page has Three Arrivals only
        Assert.assertEquals(3, driver.findElements(By.cssSelector(".woocommerce")).size());
        // Now click on one of the images in Arrivals
        driver.findElements(By.cssSelector(".woocommerce")).get(2).click();
        //Click on the ADD TO BASKET button
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();

        //Test whether the VIEW BASKET button is visible and click on it
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a")).isDisplayed());
        Assert.assertEquals("VIEW BASKET", driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a")).getText());
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a")).click();

        // Now user can find total and subtotal values just above the Proceed to Checkout button, test if the total is greater than the subtotal
        // valoarea subtotal in string
        String subtotalText = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
        // valoarea subtotal fara caractere speciale
        String subtotalNumberOnly = subtotalText.replaceAll("[^-.0-9]", "");
        // valoarea subtotal in double
        double subtotal = Double.parseDouble(subtotalNumberOnly);
        String totalText = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")).getText();
        String totalNumberOnly = totalText.replaceAll("[^-.0-9]", "");
        double total = Double.parseDouble(totalNumberOnly);
        Assert.assertTrue(total > subtotal);

        //Click the PROCEED TO CHECKOUT button
        driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
        //Fill in all required fields, set Cash on Delivery as your payment method, and click PLACE ORDER.
        driver.findElement(By.id("billing_first_name")).sendKeys("Eduard");
        driver.findElement(By.id("billing_last_name")).sendKeys("Mazilescu");
        driver.findElement(By.id("billing_email")).sendKeys("edymazilescu@gmail.com");
        driver.findElement(By.id("billing_phone")).sendKeys("0746892270");
        driver.findElement(By.id("billing_address_1")).sendKeys("Str. Burebista");
        driver.findElement(By.id("billing_city")).sendKeys("Pitesti");
        driver.findElement(By.id("billing_postcode")).sendKeys("110236");
        WebElement countrySel = driver.findElement(By.id("billing_country"));
        Select sel = new Select(countrySel);
        sel.selectByValue("RO");
        //radio button
        List<WebElement> radioGroup = driver.findElements(By.id("payment_method_cod"));
        for(WebElement radio : radioGroup){
            if(radio.getAttribute("value").equals("cod")){
                radio.click();
            }
        }
        WebElement cod = driver.findElement(By.xpath("//*[@id=\"payment_method_cod\"]"));
        Assert.assertTrue(cod.isSelected());
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(5000);

        // Check if the Payment method is set to Cash on Delivery in both fields
        String text1 = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/ul/li[4]/strong")).getText(); //first paymentMethod
        System.out.println(text1);
        String text2 = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/table/tfoot/tr[3]/td")).getText(); //second paymentMethod
        System.out.println(text2);
        Assert.assertEquals("Cash on Delivery", text1);
        Assert.assertEquals("Cash on Delivery", text2);

    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }

}
