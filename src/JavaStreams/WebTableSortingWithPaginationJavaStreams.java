package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortingWithPaginationJavaStreams {

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

        //get price the particular element - scan name column and get text -> Beans -> print price
        //getPriceVeggie is custom method! there is new class below
        List<String> price1= products.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
        price1.forEach(a -> System.out.println("Beans price is: " + a));

        //solution for pagination
        //getPrice for Rice (Beans was on the first page)
        List<String> price2;
        do {
            List<WebElement> productsOnRows = driver.findElements(By.xpath("//tr/td[1]"));
            price2 = productsOnRows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price2.forEach(a -> System.out.println("Rice price is: " + a));
            //if price wasn't found because is on different price we will use below logic
            if (price2.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
             }
             }while(price2.size() < 1);
    }

    private static String getPriceVeggie(WebElement s) {
        //below we are not starting from driver find, we can start from ours s=beans
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}