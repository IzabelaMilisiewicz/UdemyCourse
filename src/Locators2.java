import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "iza";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait - wait at least x seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        System.out.println("Text about loggin is correct");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        System.out.println("Welcome message is correct");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        System.out.println("User is correctly logged out");
        driver.close();
    }


    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
        //w efekcie powyższego splita mamy:
        //0 inxex - Please use temporary password
        //1st index - rahulshettyacademy' to Login.

//        String[] passwordArray2 = passwordArray[1].split("'");
//        passwordArray2[0]
//        te dwie powyzsze linie to to samo co ta ponizsza
        String password = passwordArray[1].split("'")[0];

        //0 index - rahulshettyacademy
        //1st index -  to Login.

        return password;
    }
}
