import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait - wait at least x seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://sso.teachable.com/secure/9521/identity/login");
        driver.findElement(By.id("email")).sendKeys("Iza");
        driver.findElement(By.name("password")).sendKeys("Iza");
        driver.findElement(By.className("btn-primary")).click();
        System.out.println(driver.findElement(By.cssSelector("div.auth-flash-error")).getText());


    }
}
