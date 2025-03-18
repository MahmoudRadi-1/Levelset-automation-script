
package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestFile {
    WebDriver driver;
    Pom home;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        home=new Pom(driver);
    }
    @Test
    public void getPaidTest(){
        home.navhome().clickGetPaidButton();
        Assert.assertEquals(home.counter(home.countable),2,"2 free docs not present");
        Assert.assertEquals(home.counter(home.countable2),1,"1 doc bet 30 and 60$ not present");
        System.out.println("Document Name is: "+home.eleText(home.docname));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


