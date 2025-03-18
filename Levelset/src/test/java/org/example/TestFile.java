
package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestFile {
    WebDriver driver;
    PomHome home1;
    PomGetPaid home2;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        home1=new PomHome(driver);
        home2 =new PomGetPaid(driver);
    }
    @Test
    public void countFreeDocs(){
        home1.navhome();
        home2.clickGetPaidButton();
        Assert.assertEquals(home2.counter(home2.Freedocs),2,"2 free docs not present");
    }
    @Test
    public void paidDocs(){
        home1.navhome();
        home2.clickGetPaidButton();
        Assert.assertEquals(home2.counter(home2.paidDocs),1,"1 doc bet 30 and 60$ not present");
        System.out.println("Doc name:");
        home2.elementText(home2.docname);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


