package QA.SeleniumWithTestNG2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.sun.tools.javac.util.Assert;

public class AppTest {
  @Test
  public void test1() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\mukulvarshney\\Downloads\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://hris.qainfotech.com/login.php");
      driver.manage().window().maximize();
      driver.findElement(By.id("txtUserName")).sendKeys("mukulvarshney");
      driver.findElement(By.id("txtPassword")).sendKeys("njnnjn");
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      driver.findElement(By.name("Submit")).click();
      String etitle = "QAIT Resource Management Tool ";
      String atitle = driver.getTitle();
      SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(atitle, etitle);
  }
}
