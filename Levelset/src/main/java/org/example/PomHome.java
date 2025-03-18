package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomHome {
    WebDriver driver;
    ActionsHandler act;

    public PomHome(WebDriver driver) {
        this.driver = driver;
        act = new ActionsHandler(driver);
    }

    String homepage = "https://www.levelset.com/";
    private By getPaidButton = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
    public By getPaidVal = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and text()='$29']");

    public PomHome navhome() {  //this methods goes to homepage
        driver.get(homepage);
        return this;
    }
}