package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Exercise6 {

    public static void main(String[] args) throws InterruptedException {

        //Section 11 - exercise 6

        //checkbox
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption2")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());
        String label = driver.findElement(By.xpath("//body/div/div[4]/fieldset/label[2]")).getText();
        while (driver.findElement(By.id("checkBoxOption2")).isSelected()) {
            System.out.println(label);
            break;
        }

        //dropdown
        WebElement dropdownExample = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdownExample);
        dropdown.selectByVisibleText(label);

        //edit box
        driver.findElement(By.id("name")).sendKeys(label);

        //alert
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if (alertText.contains(label)) {
            System.out.println("Alert message success");

        } else

            System.out.println("Something wrong with execution");

        driver.close();
    }
}