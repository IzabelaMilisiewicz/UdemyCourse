package E2EExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingCalendarUI {


    public static void main(String[] args) throws InterruptedException { //InterruptedException jest zwiazane ze sleepem)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //"iframe[class='demo-frame']"
        driver.findElement(By.id("datepicker")).click();


        //choose the month
        while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title']")).getText().contains("November"))
        {
               driver.findElement(By.xpath("//a[@data-handler='next']")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));

        //grab the common attribute, save it to list and iterate on that list
        int count = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).size();
        System.out.println(count);

        for(int i=0; i<count; i++)
        {
            String text = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).get(i).getText();
            System.out.println(text);
            String wantedDate = "23";

            if(text.equalsIgnoreCase(wantedDate))
            {
                driver.findElements(By.xpath("//td[@data-handler='selectDay']/a")).get(i).click();
                break;
            }
        }

}
}