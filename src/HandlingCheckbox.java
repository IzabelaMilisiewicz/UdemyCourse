import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckbox {

    public static void main(String[] args) throws InterruptedException { //InterruptedException jest zwiazane ze sleepem)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //check if checkbox is selected - true = selected, false = not selected
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //show the number of checkboxes on the page - all have in common type=checkbox, so we can use it in css selector
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


    }
}