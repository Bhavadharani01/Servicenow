package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class Usersviewpage extends CommonClass{
	public Usersviewpage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}	
public NewRecordpage clickNew() throws InterruptedException{
	WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	return new NewRecordpage(driver,node,dom);
}
public UsersviewUpdatepage clickSearch(String srch) throws InterruptedException {
	WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(srch,Keys.ENTER);
	Thread.sleep(2000);
	return new UsersviewUpdatepage(driver, node, dom);
}
}

