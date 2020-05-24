package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitDriver;

import static utils.DriverManager.getDriver;

public class FilterPagePart {

    public FilterPagePart sortBy(String sortBy) {
        WaitDriver.getWait().until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-0-announce")));
        getDriver().findElement(By.id("a-autoid-0-announce")).click();
        getDriver().findElement(By.linkText(sortBy)).click();
        return this;
    }
}
