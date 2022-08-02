package FunctionalTestingWithSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddingItemsIntoCart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        int j=0;

        String[] itemsNeeded  = {"Cucumber","Brocolli","Beetroot","Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)
        {
            //Brocolli - 1 Kg - this is name of product, we have to extract name of vegetable
            String[] name = products.get(i).getText().split("-");
            //trim() deletes empty spaces:
            String formattedName = name[0].trim();

            //check whether name is present in arrayList or not
            //convert array (use less memory) into arrayList for easy search

            List itemsNeededList = Arrays.asList(itemsNeeded);
//            int j=0;

            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //Click Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //we shouldn't relay on text locator because it can change like here from ADD TO CART to ADDED
                //break; - we cannot use it because we would like to find multiple values
                //what to do to stop the test after adding all needed items to the cart and not iterate thru other products without any sense?
                //3 times - 3 products from list itemsNeeded have been added to the cart
                if(j==itemsNeeded.length) {
                    break;
                }

            }
        }

    }
}