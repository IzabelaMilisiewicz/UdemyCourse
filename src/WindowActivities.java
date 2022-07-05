import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");  //selenium will wait until page will be fully loaded
        driver.navigate().to("https://rahulshettyacademy.com"); //it doesn't wait
        driver.navigate().back();
        driver.navigate().forward();


    }
}
