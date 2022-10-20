package pageFactory;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverSetup {

    public static void basicDriverSetup(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
}
