package E2EExercises;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {


    public static void main(String[] args) throws InterruptedException { //InterruptedException jest zwiazane ze sleepem)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //in selenium we don't vahe build in scroll so we can use java script:
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

}
}