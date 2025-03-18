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
        act= new ActionsHandler(driver);
    }

    private By getPaidButton = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
    public By getPaidVal = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and text()='$29']");
    public By countable = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and text()='Free']");
    public By countable2 = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and number(substring(., 2)) >= 30 and number(substring(., 2)) <= 60]");
    public By docname = By.xpath("//div[@class='right panel-heading--price']/span[@class='price-amount' and number(substring(., 2)) >= 30 and number(substring(., 2)) <= 60]/ancestor::div[@class='panel-heading left-right-pair']/div[@class='left']");
    public PomGetPaid clickGetPaidButton(){
        act.click(getPaidButton,getPaidVal);
        return this;
    }

    public int counter(By locator){    // this method counts the number of webelements by the locator
        List<WebElement> elements = driver.findElements(locator);
        int count = elements.size();
        return count;
    }
    public String eleText(By locator){   //this function gets the text from the locator
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
        }
        WebElement element = driver.findElement(locator);
        String name = element.getText();
        return name;
    }

}