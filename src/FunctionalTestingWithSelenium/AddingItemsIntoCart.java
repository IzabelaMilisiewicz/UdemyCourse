package FunctionalTestingWithSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddingItemsIntoCart {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded  = {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)
        {
            String name = products.get(i).getText();
            //check whether name is present in arrayList or not
            //convert array (use less memory) into arrayList for easy search

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name))
            {
                //Click Add to cart
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //break; - we cannot use it because we would like to find multiple values
            }
        }

    }
}