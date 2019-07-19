package QA.SeleniumWithTestNG2;


import java.util.Set;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TatocBasicCourse {

	public static void main(String[] args) throws InterruptedException{
		String box1Color, box2Color; 
		Boolean result;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mukulvarshney\\Downloads\\chromedriver_win32\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
	      
	      driver.findElement(By.className("greenbox")).click();
	      
	      driver.switchTo().frame(0);
	      do {
	    	  box1Color = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
		      driver.switchTo().frame(0);
		      box2Color = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
		      driver.switchTo().parentFrame();
		      //System.out.println(box2Color);
		      box1Color = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
		      //System.out.println(box1Color);
		      result = box1Color.equals(box2Color); 
		      if(!result) {
		    	  driver.findElement(By.linkText("Repaint Box 2")).click();
		      }else {
		    	  driver.findElement(By.linkText("Proceed")).click();
		      }
	      }while(!result);
	      WebElement sourceBox = driver.findElement(By.id("dragbox"));
	      WebElement destinationBox = driver.findElement(By.id("dropbox"));
	      //System.out.println(driver.findElement(By.className("ui-draggable")).getLocation());
	      Actions action = new Actions(driver);
	      System.out.println(driver.getTitle());
	      action.dragAndDrop(sourceBox, destinationBox).build().perform();
	      driver.findElement(By.linkText("Proceed")).click();
	      driver.findElement(By.partialLinkText("Popup")).click();
	      
	      //String title = driver.getTitle();
	      //System.out.println(title);
	      //System.out.println(driver.getCurrentUrl());
	      //Set<String> windowHandles = driver.getWindowHandles();
	      
	      
	      String parentWindow = driver.getWindowHandle();
	      Set<String> openWindows = driver.getWindowHandles();
	      for (String windowHandle : openWindows) {
	    	  if(!windowHandle.equals(parentWindow)) {
	    		  driver.switchTo().window(windowHandle);
	    		  driver.findElement(By.id("name")).sendKeys("muk");
	    	      driver.findElement(By.id("submit")).click();;
	    	  }
	      }
	      
	      
	      driver.switchTo().window(parentWindow);
	      //System.out.println(driver);
	      driver.findElement(By.linkText("Proceed")).click();
	      driver.findElement(By.linkText("Generate Token")).click();
	      String tokenValue = driver.findElement(By.id("token")).getText().split(": ")[1];
	      Cookie cookie = new Cookie("Token", tokenValue);
	      driver.manage().addCookie(cookie);
	      //System.out.println(driver);
	      //driver.close();
	      driver.findElement(By.linkText("Proceed")).click();
	}

}
