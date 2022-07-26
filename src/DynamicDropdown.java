import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

    public static void main(String[] args) throws InterruptedException { //InterruptedException jest zwiazane ze sleepem)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // (//a[@value="MAA"])[2] - xpath for chennai ale drugi znaleziony!!!
        // //a[@value="BLR"] - Bengaluru
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.close();
        System.out.println("All elements found correctly, the browser is closed");


    }
}
