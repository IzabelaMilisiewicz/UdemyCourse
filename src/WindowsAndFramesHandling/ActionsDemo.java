package WindowsAndFramesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver); //now drive obcjet gain capabilities of Action class methods
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        //moves mouse to specific element
        a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform(); //build means that this step is ready to execute; perform = execute (build and perfom are operations assigned to class Acion

        //capital letters and double click which will select the text
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //right cick on specific element
        a.moveToElement(move).contextClick().build().perform();
    }
}
