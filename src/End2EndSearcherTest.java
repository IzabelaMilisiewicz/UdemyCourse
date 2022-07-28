import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class End2EndSearcherTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);  //creating object "dropdown" of class "Select"
        //dzieki temu co wyzej bedziemy mogli uzywac metody z clasy select na naszej dropdown
        dropdown.selectByIndex(3); //USD
        System.out.println(dropdown.getFirstSelectedOption().getText()); //it returns webelement
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR"); //value="INR"
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //


        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        /*int i =1;
        while(1<5)
        {
            //it will happen until it's true
            driver.findElement(By.id("hrefIncAdt")).click(); //4 times
            i++;
        }"
        */

        //and now the same but with for loop

        for(int i=1;i<5;i++){
            driver.findElement(By.id("hrefIncAdt")).click(); //4 times

        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //

        // (//a[@value="MAA"])[2] - xpath for chennai but second one is found!!!
        // //a[@value="BLR"] - Bengaluru
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //parent to child travers - in a case if you don't want to use indexes
        // //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']

        driver.findElement(By.xpath(("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

        //

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option :options){

            if (option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }

        //

        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //check if checkbox is selected - true = selected, false = not selected
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //show the number of checkboxes on the page - all have in common type=checkbox, so we can use it in css selector
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //




    }
}


