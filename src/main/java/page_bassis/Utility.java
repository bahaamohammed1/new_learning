package page_bassis;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class Utility {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void clickonandwait(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void sendkeytoelementandwait(WebDriver driver, By locotor, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locotor));
        driver.findElement(locotor).sendKeys(text);
    }

    public static void selectbyindex(WebDriver driver, By locotor, int index) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locotor));
        Select select = new Select(driver.findElement(locotor));
        select.selectByIndex(index);
    }

    public static void selectbyvisibaletext(WebDriver driver, By locotr, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locotr));
        Select select = new Select(driver.findElement(locotr));
        select.selectByVisibleText(text);

    }

    public static void selectbyvulu(WebDriver driver, By locotor, String vulue) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locotor));
        Select select = new Select(driver.findElement(locotor));
        select.selectByValue(vulue);
    }

    public static String gettext(WebDriver driver, By locotor) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locotor));
        return driver.findElement(locotor).getText();
    }

    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void scrolling(WebDriver driver, By locotor) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoview();", changewebelement(driver, locotor));
    }

    public static WebElement changewebelement(WebDriver driver, By locotor) {
        return driver.findElement(locotor);

    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();

    }

    public static int genertrendomnumber(int uperbound) {

        return new Random().nextInt(uperbound) + 1;
    }

    public static Set<Integer> generuniq(int uperbound, int totalnumberofproduct) {
        Set<Integer> genertednumber = new HashSet<>();
        while (genertednumber.size() < uperbound) {
            int rendomnumbe = genertrendomnumber(totalnumberofproduct);
            genertednumber.add(rendomnumbe);
        }
        return genertednumber;

    }
}
