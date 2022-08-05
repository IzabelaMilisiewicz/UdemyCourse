import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SynchronizationInSelenium {
    //implicit wait - set maximum waiting time for WHOLE PROGRAM - wait some time until element will be presented but if it will be sooner than set time, go further
        //advantages: readable code; disadvantages: if in requirements we have assumption that something should work faster, we can miss it (performance issues skipped)
    //explicit wait - can target specific element
    //combination of both above ways is an ideal solution
    //Thread.sleep - just waiting set time of second, it's a part of java not selenium as implicit and ecplicit - we shouldn't use this in our framework

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait (it is applied to every line in our test):
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        addItems(driver, itemsNeeded);
//        below lines should be here if we wouldn't set "static" for class addItems below, but we did so we can use method from
//        SynchronizationInSelenium s = new SynchronizationInSelenium();
//        s.addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        //it's reusable method this is why is out from above one
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1 Kg - this is name of product, we have to extract name of vegetable
            String[] name = products.get(i).getText().split("-");
            //trim() deletes empty spaces:
            String formattedName = name[0].trim();

            //check whether name is present in arrayList or not
            //convert array (use less memory) into arrayList for easy search

            List itemsNeededList = Arrays.asList(itemsNeeded);
//            int j=0;

            if (itemsNeededList.contains(formattedName)) {
                j++;
                //Click Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //we shouldn't relay on text locator because it can change like here from ADD TO CART to ADDED
                //break; - we cannot use it because we would like to find multiple values
                //what to do to stop the test after adding all needed items to the cart and not iterate thru other products without any sense?
                //3 times - 3 products from list itemsNeeded have been added to the cart
                if (j == itemsNeeded.length) {
                    break;
                }

            }
        }

    }
}
