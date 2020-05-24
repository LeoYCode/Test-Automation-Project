package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDriver {

    private static int TIME_OUT_SECONDS = 15;

    private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),TIME_OUT_SECONDS);

    public static void waitUntilElementDisplayed(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
