package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_bassis.Utility;

public class P05_Overview {
    private final By itemtotal = By.className("summary_subtotal_label");
    private final By tex = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");

    private final WebDriver driver;

    public P05_Overview(WebDriver driver) {
        this.driver = driver;

    }

    public float getitemtotal() {
        return Float.parseFloat(Utility.gettext(driver, itemtotal).replace("Item total: $", ""));
    }

    public float texget() {
        return Float.parseFloat(Utility.gettext(driver, tex).replace("Tax: $", ""));
    }

    public float totalprice() {
        return Float.parseFloat(Utility.gettext(driver, total).replace("Total: $", ""));
    }

    public String calculte() {
        return String.valueOf(getitemtotal() + texget());
    }

    public boolean compringpriceof() {
        return calculte().equals(String.valueOf(totalprice()));
    }
}
