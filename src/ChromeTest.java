import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/salman/workspace/Selenium files/chromedriver.exe");

		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.wikipedia.org");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement link;
		  link = driver.findElement(By.linkText("English"));
		  link.click();
		  Thread.sleep(5000);
		  WebElement searchbox;
		  searchbox = driver.findElement(By.id("searchInput"));
		  searchbox.sendKeys("Software");
		  Thread.sleep(5000);
		  driver.quit();

	}

}
