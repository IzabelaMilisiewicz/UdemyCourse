package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class CountLinksInTheScope {

    public static void main(String[] args) throws InterruptedException {

        //Section 11 - 91, 92, 93, 94 lesson from the course
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

        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);

        }// opens all the tabs
        Set<String> tabs = driver.getWindowHandles();//4
        Iterator<String> ite = tabs.iterator();

        while (ite.hasNext())   //hasNext will tell us if there is another tab, if there is - move with the loop
        {
            //there is difference between hasNext (tells us if there is next index presented or not) and next (it moves to next index)
            driver.switchTo().window(ite.next());
            System.out.println(driver.getTitle());

        }

    }
}
