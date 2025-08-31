package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_bassis.Utility;

public class P04_Checkout {
    private final By fristname = By.id("first-name");
    private final By lastname = By.id("last-name");
    private final By zipcod = By.id("postal-code");
    private final By contionsbutton = By.className("cart_button");
    private WebDriver driver;

    public P04_Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public P04_Checkout enterfields(String Fristname, String Lastname, String Zipcodes) {
        Utility.sendkeytoelementandwait(driver, fristname, Fristname);
        Utility.sendkeytoelementandwait(driver, lastname, Lastname);
        Utility.sendkeytoelementandwait(driver, zipcod, Zipcodes);
        return this;

    }

    public P05_Overview clickoncheckout() {
        Utility.clickonandwait(driver, contionsbutton);
        return new P05_Overview(driver);
    }
}
