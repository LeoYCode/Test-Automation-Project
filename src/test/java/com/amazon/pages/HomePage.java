package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitDriver;

import static utils.DriverManager.getDriver;

public class HomePage extends FilterPagePart {

    private String PRODUCT_LINKS = "h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2 a";

    public HomePage clickHamburgerMenu() {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        String HAMBURGER_MENU = "#nav-hamburger-menu";
        WaitDriver.getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(HAMBURGER_MENU))));
        getDriver().findElement(By.cssSelector(HAMBURGER_MENU)).click();
        return this;
    }

    public HomePage clickCategory(String categoryName) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.linkText(categoryName)));
        getDriver().findElement(By.linkText(categoryName)).click();
        return this;
    }

    public HomePage clickSubCategory(String subCategory) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.linkText(subCategory)));
        getDriver().findElement(By.linkText(subCategory)).click();
        return this;
    }

    public HomePage clickDisplaySize(String displaySize) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        String DISPLAY_SIZE_CONTAINER = ".a-unordered-list.a-nostyle.a-vertical.a-spacing-base";
        WaitDriver.waitUntilElementDisplayed(getDriver().findElement(By.cssSelector(DISPLAY_SIZE_CONTAINER)));
        getDriver().findElement(By.cssSelector(String.format("div[data-a-input-name=s-ref-checkbox-%s]", displaySize))).click();
        return this;
    }

    public HomePage clickCPUType(String cpuType) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        getDriver().findElement(By.id(String.format("p_n_feature_fifteen_browse-bin/%s",cpuType))).click();
        return this;
    }

    public HomePage clickStorageType(String storageType) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        getDriver().findElement(By.cssSelector(String.format("#p_n_feature_eleven_browse-bin\\/%s > span > a",storageType))).click();
        return this;
    }

    public HomePage clickStarRating(String rating) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        getDriver().findElement(By.cssSelector(String.format("i.a-icon.a-icon-star-medium.a-star-medium-%s", rating))).click();
        return this;
    }

    public ProductPage clickProduct(int productIndex) {
        getDriver().findElements(By.cssSelector(PRODUCT_LINKS)).get(productIndex).click();
        return new ProductPage();
    }

    public String productHref(int productIndex) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        WaitDriver.getWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElements(By.cssSelector(PRODUCT_LINKS)).get(productIndex)));
        return getDriver().findElements(By.cssSelector(PRODUCT_LINKS)).get(productIndex).getAttribute("href");
    }

    public String productTitle(int productIndex) {
        WaitDriver.getWait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        return getDriver().findElements(By.cssSelector(PRODUCT_LINKS)).get(productIndex).getText();
    }
}
