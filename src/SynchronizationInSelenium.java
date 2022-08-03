import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SynchronizationInSelenium {
    //implicit wait - set maximum waiting time for WHOLE PROGRAM - wait some time until element will be presented but if it will be sooner than set time, go further
    //explicit wait - can target specific element
    //combination of both above ways is an ideal solution
    //Thread.sleep - just waiting set time of second, it's a part of java not selenium as implicit and ecplicit - we shouldn't use this in our framework

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


    }
}