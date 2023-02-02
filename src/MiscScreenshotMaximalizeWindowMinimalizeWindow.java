import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class MiscScreenshotMaximalizeWindowMinimalizeWindow {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximalizing the window
        driver.manage().window().maximize();

        //clear cookies
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("qwerty");
        driver.get("http://google.com");

        //screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //coping the file to our local machine
        FileUtils.copyFile(src, new File("C:\\Users\\IzabelaMilisiewicz\\screenshot.png"));
    }
}