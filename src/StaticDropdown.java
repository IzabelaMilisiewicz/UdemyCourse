import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag - static dropdown (jak tag jest select to bedzie static lista)
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);  //creating object "dropdown" of class "Select"
        //dzieki temu co wyzej bedziemy mogli uzywac metody z clasy select na naszej dropdown
        dropdown.selectByIndex(3); //USD
        System.out.println(dropdown.getFirstSelectedOption().getText()); //it returns webelement
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR"); //value="INR"
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}