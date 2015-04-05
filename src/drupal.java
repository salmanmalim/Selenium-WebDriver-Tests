

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class drupal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.ca/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDrupal() throws Exception {
    driver.get(baseUrl + "/search?q=drupal&ie=utf-8&oe=utf-8&gws_rd=cr&ei=iL0gVc78FcfZsAXs24PIAw");
    driver.findElement(By.linkText("Drupal - Open Source CMS | Drupal.org")).click();
    driver.findElement(By.linkText("Log in / Register")).click();
    driver.findElement(By.linkText("Create new account")).click();
    driver.findElement(By.id("edit-name")).clear();
    driver.findElement(By.id("edit-name")).sendKeys("ert");
    driver.findElement(By.id("edit-mail")).clear();
    driver.findElement(By.id("edit-mail")).sendKeys("ert@yahoo.com");
    driver.findElement(By.id("edit-conf-mail")).clear();
    driver.findElement(By.id("edit-conf-mail")).sendKeys("ert@yahoo.com");
    driver.findElement(By.id("edit-pass-pass1")).clear();
    driver.findElement(By.id("edit-pass-pass1")).sendKeys("dfg");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
