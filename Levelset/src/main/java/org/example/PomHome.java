package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomHome {
    WebDriver driver;
    ActionsHandler act;
    PomGetPaid paid;
    public PomHome(WebDriver driver) {
        this.driver = driver;
        act = new ActionsHandler(driver);
        paid= new PomGetPaid(driver);
    }

    String homepage = "https://www.levelset.com/";
    private By getPaidButton = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");


    public PomHome nav() {  //this methods goes to homepage
        driver.get(homepage);
        return this;
    }
    public PomHome clickGetPaidButton(){
        act.click(getPaidButton,paid.getPaidVal);
        return this;
    }
}