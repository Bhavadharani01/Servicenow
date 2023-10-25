package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class UsersviewUpdatepage extends CommonClass{
	public UsersviewUpdatepage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}
	
	public UsersviewUpdatepage clicki() {
		driver.findElement(By.xpath("(//a[contains(@class,'btn btn-icon')])[2]")).click();
		return this;
	}
	public Updateuser clickOpenrecord() {
		//WebElement openrecord = driver.findElement(By.xpath("(//div[@role='dialog'])[2]"));
		driver.findElement(By.xpath("//a[text()='Open Record']")).click();
		//driver.findElement(By.xpath("//a[text()='Open Record']"));
		return new Updateuser(driver, node, dom);
	}
	
	public Deleteuser clickOpenrecordfrDelete() {
		driver.findElement(By.xpath("//a[text()='Open Record']")).click();
		return new Deleteuser(driver, node, dom);
	}
}
