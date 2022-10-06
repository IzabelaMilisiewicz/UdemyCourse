import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandlingHTTPDCertifications {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        Proxy proxy =new Proxy();

       // proxy.getHttpProxy("ipaddress:4444");   //ip address we should get from support team in  the company
        //options.setCapability("proxy", proxy);

        //block popup windows
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        //setting default downoload directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "Downloads");
        options.setExperimentalOption("prefs", prefs);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}