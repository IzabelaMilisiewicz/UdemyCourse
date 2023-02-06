package Selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

//        - above(): element located above with respect to the specified element;
//        - below():  element located below with respect to the specified element;
//        - toLeftOf():  element located to the left of respect to the specified element;
//        - toRightOf(): element located to the right of respect to the specified element;

//        Syntax:
//        driver.findElement(with(By.tagName("XX").above(WebElement))

        //above
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        //below
        WebElement labelDob = driver.findElement(By.xpath("//label[contains(text(), 'Date of Birth')]"));
        driver.findElement(with(By.tagName("input")).below(labelDob)).click();

        System.out.println("The text which actually appears: " + driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']")).getText()
                .contains("Success! The Form has been submitted successfully!."));
        System.out.println("Assert successful");

        //toLeftOf
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[contains(text(), 'Check me out if you Love IceCreams!')]"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
        System.out.println("Is checkbox selected?; " + driver.findElement(By.xpath("//label[contains(text(), 'Check me out if you Love IceCreams!')]/preceding-sibling::input")).isSelected());

        //toRightOf
        //I would like to get to know what is the first riado button label - it may change
        WebElement firstRadioButton = driver.findElement(By.id("inlineRadio1"));
        System.out.println("The label of radiobutton is: " + driver.findElement(with(By.tagName("label")).toRightOf(firstRadioButton)).getText());

        driver.close();
    }
}