package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinksInTheScope {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println("All links on the webpage: " + driver.findElements(By.tagName("a")).size());

        //links counted only in the footer section
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("Links only on the footer section: " + footerdriver.findElements(By.tagName("a")).size());
    }
}