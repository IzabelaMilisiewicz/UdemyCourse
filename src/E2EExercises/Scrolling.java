package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scrolling {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //in selenium we don't vahe build in scroll so we can use java script:
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        //SUM UP VALUES FROM THE TABLE
        List<WebElement> values =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for(int i =0;i<values.size();i++)
        {
            sum = sum +Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

        //assertion of sum from webpage and sum from our calculation
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println();
        Assert.assertEquals(sum, total);   //assert comes from testNg

        //sum up values from second table
        List<WebElement> values2 = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
        int sum2 = 0;
        for(int j =0;j<values2.size();j++)
        {
            sum2 = sum2 +Integer.parseInt(values2.get(j).getText());
        }
        System.out.println(sum2);

        //assingment 1 - show size of rows and columns in the table
        System.out.println(driver.findElements(By.cssSelector(".table-display td:nth-child(3)")).size());
}
}