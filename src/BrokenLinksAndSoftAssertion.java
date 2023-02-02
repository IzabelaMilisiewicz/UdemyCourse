import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksAndSoftAssertion {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//        broken link = URL attached to the link throws 404
//        Java methods will call URL's and gets status code
//        URL's we have to get with selenium, they will be scanned with selenium
//
//        Step I - get all URL's tied up to the links using selenium, get attribute
//        Step II - java methods to call urls and get status code
//        if status > 400 - URL is not working

//        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for(WebElement link : links)
        {
            String url = link.getAttribute("href");

            //openConnection is method in url class, http is parent class of url
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);

            //soft assertion from testNg - it will iterate on all links, won't stop on first failed:
            //logic: respCode<400 -> if for example respCode is 401 then 401 is not less than 400 so we have in result false, as assertTrue then we will have fail here
            a.assertTrue(respCode<400, "The link with text " + link.getText() + " is broken with code " + respCode);
//
//            below we have hard assertion in if section - if we will use it, the code will be stopped after first broken link, we have to use soft assertion
//            if(respCode>400)
//            {
//                System.out.println("The link with text " + link.getText() + " is broken with code " + respCode);
//                Assert.assertTrue(false);
//            another way to write hard assertion intead of whole if section below:
//            Assert.assertTrue(respCode>400, "The link with text " + link.getText() + " is broken with code " + respCode);
            }

        //this is needed to do assertion on all links and it will report filed cases:
        a.assertAll();
        }
    }