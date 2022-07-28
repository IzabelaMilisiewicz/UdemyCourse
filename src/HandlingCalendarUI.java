import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendarUI {

    public static void main(String[] args) throws InterruptedException { //InterruptedException is connected with sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //parent to child travers - in a case if you don't want to use indexes
        // //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']

        driver.findElement(By.xpath(("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))).click();


        //if you want to use class name in css you have to use . if you want to use id you have to use #
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();


    }
}