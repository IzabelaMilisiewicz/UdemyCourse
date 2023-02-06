package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CheckingIfFilterTableWorks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String lookingFor = "Ch";
        //we filter using Rice word
        driver.findElement(By.id("search-field")).sendKeys(lookingFor);
        //all results after filter - we are creating list veggies with all results
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        //what should be filtered - we are creating new list and we are checking if all filttered texts contains searched word
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains(lookingFor)).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filteredList.size());
        System.out.println("Filter works correctly");
    }
}