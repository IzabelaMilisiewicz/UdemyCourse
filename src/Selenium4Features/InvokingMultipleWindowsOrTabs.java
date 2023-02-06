package Selenium4Features;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleWindowsOrTabs {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //open another tab and take text to copy in first tab
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId= it.next();
        String childWindowID = it.next();
        driver.switchTo().window(childWindowID);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);

        //get screenshot of WebElement
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        //get height and width of the field for UI testing
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

        driver.quit();
    }
}