import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.P01_Loginpage;
import page_bassis.DataUtilities;

import java.io.IOException;
import java.time.Duration;

public class T03_Yourcard {

    private WebDriver driver;

    @BeforeMethod
    public void frist() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DataUtilities.properties("Url", "Loginurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void compringofnumberofselectedproducttestcases() throws IOException {

        new P01_Loginpage(driver).enterusername(DataUtilities.getjsondata("ValidData", "username"))
                .pasword(DataUtilities.getjsondata("ValidData", "password")).
                click().clickoncarticon();
        // Assert.assertTrue(new P02_landingpage(driver).compring());
        Assert.assertEquals(driver.getCurrentUrl(), DataUtilities.properties("Url", "Yourcard_url"));

        // Assert.assertEquals(driver.getCurrentUrl(), DataUtilities.properties("Url", "home_url"));
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

}

