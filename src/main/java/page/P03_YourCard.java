package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_bassis.Utility;

import java.util.List;

public class P03_YourCard {
    static float Totalprice = 0;
    private final By Checkout = By.className("checkout_button");
    private final By priceofproduct = By.xpath("//div[@class='inventory_item_price']");
    private final By pricesofselected = By.xpath("//button[.='REMOVE']//preceding-sibling::div[@class='inventory_item_price']");


    private WebDriver driver;


    public P03_YourCard(WebDriver driver) {
        this.driver = driver;
    }


    public String TotalpriceonCard() {
        try {
            List<WebElement> priceOFselectedproduct = driver.findElements(pricesofselected);
            for (int i = 1; i <= priceOFselectedproduct.size(); i++) {
                By price = By.xpath("(//button[.='REMOVE']//preceding-sibling::div[@class='inventory_item_price'])[" + i + "]");
                String fulltext = Utility.gettext(driver, price);
                Totalprice += Float.parseFloat(fulltext.replace("$", ""));

            }
            return String.valueOf(Totalprice);

        } catch (Exception e) {
            return "0";
        }

    }

    public boolean ComparingPrices(String price) {
        return TotalpriceonCard().equals(price);
    }


    public P04_Checkout checkoutcart() {

        Utility.clickonandwait(driver, Checkout);
        return new P04_Checkout(driver);
    }
}
