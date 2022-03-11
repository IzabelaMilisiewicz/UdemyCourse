import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait - wait at least x seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://sso.teachable.com/secure/9521/identity/login");
        driver.findElement(By.id("email")).sendKeys("Iza");
        driver.findElement(By.name("password")).sendKeys("Iza");
        driver.findElement(By.className("btn-primary")).click();
        //<div class="bodySmall m-b-3-xs text-center-xs auth-flash-error">Your email or password is incorrect.</div>
        System.out.println(driver.findElement(By.cssSelector("div.auth-flash-error")).getText());
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.linkText("Forgot Password")).click();
        //<input type="email" name="email" id="email" required="" autofocus="autofocus" autocomplete="email" class="form-input p-v-1-xs p-l-2-xs p-r-4-xs col-12-xs bodyMain error" aria-live="polite">
        // //Tagname[atribute='value'][index]
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("input[name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email'][1]")).sendKeys("test2@gmail.com");
        //in css you cannot use [index]
        //driver.findElement(By.cssSelector("input[name='email']:nth-child(1)")).clear();
        //parent XPATH
        // //parentTagname/childTagname[index]
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        // css selector = .classname
        driver.findElement(By.cssSelector(".dsp-flex-xs")).click();
        //partent on css
        // PartentTagname childTagname
        System.out.println(driver.findElement(By.xpath("//div/p[1]")).getText());
//        System.out.println(driver.findElement(By.cssSelector("div p")).getText());
        //method title - zczytaj tytul, sprawdz, i dopiero wtedy wez get text z tego elementu
    }
}
