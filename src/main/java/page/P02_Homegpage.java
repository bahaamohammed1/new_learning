package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_bassis.Logutilities;
import page_bassis.Utility;

import java.util.List;

public class P02_Homegpage {
    private static final Logger log = LoggerFactory.getLogger(P02_Homegpage.class);
    static float Totalprice = 0;
    private static List<WebElement> addallproduct;
    private static List<WebElement> selected;
    private final By clickoncarticon = By.cssSelector("path[fill]");
    private final By addtocard = By.xpath("//button[@class]");
    private final By shopingcard = By.className("shopping_cart_badge");
    private final By selectedproduct = By.xpath("//button[.='REMOVE']");
    private final By pricesofselected = By.xpath("//button[.='REMOVE']//preceding-sibling::div[@class='inventory_item_price']");
    private final WebDriver driver;


    public P02_Homegpage(WebDriver driver) {
        this.driver = driver;
    }


    public P02_Homegpage allproduc() {
        addallproduct = driver.findElements(addtocard);
        Logutilities.info("write number of selected product : " + addallproduct.size());
        for (int i = 1; i <= addallproduct.size(); i++) {
            By addtocard = By.xpath("(//button[@class])[" + i + "]");
            Utility.clickonandwait(driver, addtocard);


        }
        return this;
    }

    public String getnumber() {
        try {
            Logutilities.info("write number of product on card :" + Utility.gettext(driver, shopingcard));

            return Utility.gettext(driver, shopingcard);

        } catch (Exception e) {
            Logutilities.error(e.getMessage());
            return "0";
        }

    }

    public boolean compring() {
        return selectedallproductincarticon().equals(getnumber());


    }

    public String selectedallproductincarticon() {
        try {
            selected = driver.findElements(selectedproduct);
            Logutilities.info("write selected produc in card : " + selected.size());

            return String.valueOf(selected.size());
        } catch (Exception e) {
            Logutilities.error(e.getMessage());
            return "0";
        }

    }

    public String getTotalprice() {
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


    public P03_YourCard clickoncarticon() {
        Utility.clickonandwait(driver, clickoncarticon);
        return new P03_YourCard(driver);
    }


}
