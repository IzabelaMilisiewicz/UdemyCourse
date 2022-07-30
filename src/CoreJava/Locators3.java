package CoreJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Sibling - parent traverse
        // absolut - start from the top of the page - you can start with single slash /
         //header/div/button[1]/following-sibling::button[1]
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("pierwszy: " + driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

        //46
        //header/div/button[1]/parent::div/button[2]
        System.out.println("drugi: " + driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        driver.close();

    }
}
