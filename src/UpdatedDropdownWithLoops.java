import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdownWithLoops {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
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

    }
}
