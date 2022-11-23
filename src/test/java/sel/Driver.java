package sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        FileReader fileReader = new FileReader("src\\main\\resources\\app.properties");
        Properties properties = new Properties();
        properties.load(fileReader);

        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        System.out.println("Browser: "+ browser);
        driver.get(url);


        return driver;


    }
}
