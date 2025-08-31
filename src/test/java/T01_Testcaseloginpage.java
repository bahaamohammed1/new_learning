import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.P01_Loginpage;
import page_bassis.DataUtilities;

import java.io.IOException;
import java.time.Duration;

public class T01_Testcaseloginpage {

    private WebDriver driver;

    @BeforeMethod
    public void frist() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtilities.properties("Url", "Loginurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void start() throws IOException {
        new P01_Loginpage(driver).enterusername(DataUtilities.getjsondata("ValidData", "username")).pasword(DataUtilities.getjsondata("ValidData", "password")).click();
        Assert.assertEquals(driver.getCurrentUrl(), DataUtilities.properties("Url", "home_url"));
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }
}
