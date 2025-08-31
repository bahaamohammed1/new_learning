import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.P01_Loginpage;
import page.P02_landingpage;
import page.P04_Checkout;
import page.P05_Overview;
import page_bassis.DataUtilities;
import page_bassis.Logutilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class T05_Overview {
    private final String Fristname = DataUtilities.getjsondata("Data", "fristname");
    private final String Lastname = DataUtilities.getjsondata("Data", "lastname");

    private final String Zipcode = DataUtilities.getjsondata("Data", "zipcode");


    private WebDriver driver;

    public T05_Overview() throws FileNotFoundException {
    }

    @BeforeMethod
    public void frist() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DataUtilities.properties("Url", "Loginurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void compringofnumberofselectedproducttestcases() throws IOException {
        //TODO Login steps

        new P01_Loginpage(driver)
                .enterusername(DataUtilities.getjsondata("ValidData", "username"))
                .pasword(DataUtilities.getjsondata("ValidData", "password")).
                click().allproduc();
        Logutilities.info("enter mesaga");
        //TODO Clickoncarticon steps
        new P02_landingpage(driver).clickoncarticon().checkoutcart();
        Logutilities.debug("enter mesaga");

        //TODO filloftextandclickoncheckoutbutton steps
        new P04_Checkout(driver).enterfields(Fristname, Lastname, Zipcode).clickoncheckout();
        Assert.assertEquals(driver.getCurrentUrl(), DataUtilities.properties("Url", "Checkout"));
        //TODO CHECKOUT PAGE COMPARING
        new P05_Overview(driver).compringpriceof();


    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

}
