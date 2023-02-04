package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortingWithJavaStreams {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.xpath("//span[contains(text(), 'Veg/fruit name')]")).click();

        //capture all webelements into list
        List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all elements into new list
        List<String> originalList = products.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
        System.out.println("Assert passed");


        //using for loop to exercise plus condition statements
//        for(WebElement s : products){
//            String myProduct = products.get(0).getText();
//            count ++;
//            System.out.println(myProduct);
//        }

        driver.close();
    }
}
