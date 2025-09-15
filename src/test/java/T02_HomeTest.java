import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.P01_Loginpage;
import page.P02_Homegpage;
import page_bassis.DataUtilities;
import page_bassis.Utility;

import java.io.IOException;
import java.time.Duration;

public class T02_HomeTest {
    private static final Logger LOGGER = LogManager.getLogger();

    private WebDriver driver;

    @BeforeMethod
    public void frist() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DataUtilities.properties("Url", "Loginurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Description("this verify that user name logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("bahaa")
    @Test
    public void compringofnumberofselectedproducttestcases() throws IOException {

        new P01_Loginpage(driver).enterusername(DataUtilities.getjsondata("ValidData", "username"))
                .pasword(DataUtilities.getjsondata("ValidData", "password")).
                click().allproduc();
        Assert.assertTrue(new P02_Homegpage(driver).compring());
        Utility.takingscreenshot(driver, "landingTest");

        // Assert.assertEquals(driver.getCurrentUrl(), DataUtilities.properties("Url", "home_url"));
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

}
