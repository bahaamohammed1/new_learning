package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_bassis.Utility;

public class P01_Loginpage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By clk = By.className("btn_action");
    private WebDriver driver;

    public P01_Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_Loginpage enterusername(String user) {
        Utility.sendkeytoelementandwait(driver, username, user);
        return this;
    }

    public P01_Loginpage pasword(String ps) {
        Utility.sendkeytoelementandwait(driver, password, ps);
        return this;
    }

    public P02_landingpage click() {
        Utility.clickonandwait(driver, clk);
        return new P02_landingpage(driver);
    }


}
