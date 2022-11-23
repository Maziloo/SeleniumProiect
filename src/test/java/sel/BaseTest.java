package sel;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import java.io.FileReader;
import java.io.IOException;
//import java.util.Properties;

import static sel.Driver.getDriver;

public class BaseTest {
    public static WebDriver driver;

    JavascriptExecutor js;

    @Before
    public void setUp() throws IOException {
        driver = getDriver(); //original
        /*
       WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();*/


        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }

    @After
    public void after(){
        driver.quit();
    }

}
