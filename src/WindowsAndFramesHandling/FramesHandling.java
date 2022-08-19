package WindowsAndFramesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

    //frame is like a container with independend content on the webpage, those elements may come from outside of the webpage

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        //selunium cannot manage frames until we tell it
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //"iframe[class='demo-frame']"
//        driver.findElement(By.id("dragabble")).click();
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent(); //we nedd to add it if we would like to do something in main window, not in frame
    }
}