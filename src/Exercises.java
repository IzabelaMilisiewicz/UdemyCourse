import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercises {
    public static void main(String[] args) throws InterruptedException { //InterruptedException is connected with sleep)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //checkboxes exercises
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.findElement(By.id("checkBoxOption1")).click();
//        System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
//        driver.findElement(By.id("checkBoxOption1")).click();
//        System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //UI(Dropdowns,EditBoxes,Error Valdiation) Assignment exercises
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        String name = "Iza";
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("iza@iza.pl");
        driver.findElement(By.cssSelector("input[id='exampleInputPassword1']")).sendKeys("izaizaiza");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
        //static dropdown
        WebElement staticDropdown2 = driver.findElement(By.id("exampleFormControlSelect1"));
        Select myDropdown = new Select(staticDropdown2);
        myDropdown.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/04/1987");
        driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

    }
}