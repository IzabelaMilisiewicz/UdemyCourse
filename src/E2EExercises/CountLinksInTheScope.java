package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinksInTheScope {

    public static void main(String[] args) {

        //92 lesson from the course
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println("All links on the webpage: " + driver.findElements(By.tagName("a")).size());

        //links counted only in the footer section
        WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
        System.out.println("Links only on the footer section: " + footerdriver.findElements(By.tagName("a")).size());

        //links counted in footer section but only in first column
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("Links only in first column from the footer section: " + columndriver.findElements(By.tagName("a")).size());

        //click on each link from the column and check if the pages are opened
        for(int i=1;1<columndriver.findElements(By.tagName("a")).size();i++)
        {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
    }
}