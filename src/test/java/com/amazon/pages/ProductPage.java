package com.amazon.pages;

import org.openqa.selenium.By;

import static utils.DriverManager.getDriver;

public class ProductPage {

    public String productTitle() {
        return getDriver().findElement(By.id("productTitle")).getText();
    }
}
