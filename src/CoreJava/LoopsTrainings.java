package CoreJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LoopsTrainings {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column
        driver.findElement(By.xpath("//span[contains(text(), 'Veg/fruit name')]")).click();

        //capture all webelements into list
        List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));


        //for loop to collect all elements fom product list
        List<String> originList = new ArrayList<>();
        for (WebElement element : products) {
            originList.add(element.getText()); }
            for(int i=0;i<originList.size();i++){
                System.out.println(originList.get(i));
        }

        System.out.println("OriginList printed: " + originList);
        System.out.println(originList.size());

        List<String> originListToBeSorted = new ArrayList<>();
        for (WebElement element : products) {
            originListToBeSorted.add(element.getText()); }

        Collections.sort(originListToBeSorted);
        System.out.println("OriginListToBeSorted printed after sorting: " + originListToBeSorted);

        Assert.assertTrue(originList.equals(originListToBeSorted));
        System.out.println("test passed");

        //BELOW SOLUTION FOR IT WITH STREAMS

//        //capture text of all elements into new list
//        zList<String> originalList = products.stream().map(s->s.getText()).collect(Collectors.toList());
//
//        //sort on the original zlist
//        zList<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
//
//        //compare original list vs sorted list
//        Assert.assertTrue(originalList.equals(sortedList));
//        System.out.println("Assert passed");

        driver.close();
    }
}