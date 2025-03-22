
package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestFile {
    WebDriver driver;
    PomHome homePage;
    PomGetPaid paidPage;
    ActionsHandler act;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        homePage =new PomHome(driver);
        paidPage =new PomGetPaid(driver);
    }
    @Test
    public void countFreeDocs(){
        homePage.nav().clickGetPaidButton();
        Assert.assertEquals(paidPage.counter(paidPage.Freedocs),2,"2 free docs not present");
    }
    @Test
    public void paidDocs(){
        homePage.nav().clickGetPaidButton();
        Assert.assertEquals(paidPage.counter(paidPage.paidDocs),1,"1 doc bet 30 and 60$ not present");
        System.out.println("Doc name:");
        paidPage.elementText(paidPage.docname);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


