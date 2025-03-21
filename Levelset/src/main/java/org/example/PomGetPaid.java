package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PomGetPaid {
    WebDriver driver;
    ActionsHandler act;

    public PomGetPaid(WebDriver driver) {
        this.driver = driver;
        act = new ActionsHandler(driver);
    }

    String fromPrice = "30";
    String toPrice = "60";
    String docXpath = "//div[@class='right panel-heading--price']/span[@class='price-amount' and number(substring(., 2)) >= " + fromPrice + " and number(substring(., 2)) <= " + toPrice + "]";
    String docNameFinder = "/ancestor::div[@class='panel-heading left-right-pair']/div[@class='left']";
    public By getPaidVal = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and text()='$29']");
    public By Freedocs = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and text()='Free']");
    public By paidDocs = By.xpath(docXpath);
    public By docname = By.xpath(docXpath + docNameFinder);


    public int counter(By locator) {    // this method counts the number of webelements by the locator
        List<WebElement> elements = driver.findElements(locator);
        int count = elements.size();
        return count;
    }

    public PomGetPaid elementText(By locator) {   //this function gets the text from the locator
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String name = element.getText();
            System.out.println(name);
        }
        return this;
    }
}