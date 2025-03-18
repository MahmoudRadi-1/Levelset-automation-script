package org.example;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsHandler
{
    WebDriver driver;
    public ActionsHandler(WebDriver driver)
    {
        this.driver=driver;
    }


    public void click (By locator,By validator) {
        boolean clicked=false;
        try {
            driver.findElement(locator).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
            WebElement val = wait.until(ExpectedConditions.presenceOfElementLocated(validator));
            clicked=true;

        } catch (Exception e) {
            System.out.println("single click failed");
        }
        if(!clicked) {
            try {
                Actions actions = new Actions(driver);
                WebElement element = driver.findElement(locator);
                actions.doubleClick(element).perform();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
                WebElement val = wait.until(ExpectedConditions.presenceOfElementLocated(validator));
                clicked=true;
            } catch (Exception e) {
                System.out.println("double click failed");
            }
        }
        if (!clicked) {
            try {
                driver.findElement(locator).sendKeys(Keys.ENTER);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
                WebElement val = wait.until(ExpectedConditions.presenceOfElementLocated(validator));
                clicked=true;

            } catch (Exception e) {
                System.out.println("enter failed");

            }
        }

        if (!clicked) {
            try {
                Actions actions = new Actions(driver);
                WebElement element = driver.findElement(locator);
                actions.moveToElement(element).perform();
                driver.findElement(locator).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
                WebElement val = wait.until(ExpectedConditions.presenceOfElementLocated(validator));
                clicked=true;
            }
            catch (Exception e) {
                System.out.println("hover click failed");
            }
        }

        if (!clicked) {
            throw new RuntimeException("clicks failed");
        }
    }
}
