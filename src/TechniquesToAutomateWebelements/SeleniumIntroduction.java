package TechniquesToAutomateWebelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		//najpierw zainstaluj java jdk
		//zaintsaluj eclipse
		//pobierz chromedriver odpowiedni dla Twojej przegladarki
		//utwórz projekt i przekonweruj go na maven
		//w pliku pom dodaj dependencies ze strony maven repository
		
		//Invoking Browser
		//Chrome - ChromeDriver -> all methods to run chrome
		//Firefox - FirefoxDriver 
		// selenium rozumie ze wszytskie przegládarki majá te same metody, wystarczy zmienić nazwe przegladarki
		//webdriver to interfejs czyli grupa metod (takich samych jak przyinnych driverach jak close, get) webdriver ujednolica metody jesli jest zaimplementowany w klasie jak tutaj
		//webdriver methods + class methods
		//Chromedriver driver = new ChromeDriver();
		//webdriver methods: wtedy nie mamy dostepu do metod chromedrivera i mozemy łatwo zmieniac nazwy przegladarek
		
	//	WebDriver driver = new ChromeDriver();
		
		//selenium will invoke chrome driver from exe file -> chromedriver.exe jest od chrome i nie ma nic wspólnego z selenium
		// to middle man proxy, should be privided by chrome team
		//webdriver.chrome.driver -> trzeba podac sciezke do miejsca, w któeym jest zapisany na naszym komuterze chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IzabelaMilisiewicz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Get title: " + driver.getTitle());
		System.out.println("Checking current URL: " + driver.getCurrentUrl());
		driver.close();
		System.out.println("Web browser closed correctly");
		//difference between .close and .quit - close zamyka tylko naszego taba a quit zamyka wszystkie powiazane taby w tym oknie, nie mozna ich używać razem
		
		//Firefox launch
		//geckodriver
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Milisiza\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

	}

}
