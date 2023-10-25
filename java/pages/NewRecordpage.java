package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class NewRecordpage extends CommonClass{
	public NewRecordpage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}
	public NewRecordpage clickX() {
	driver.findElement(By.xpath("//button[@id='close-messages-btn']")).click();
	return this;
	}
	public NewRecordpage enterFirstname(String fname) {
	driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
	return this;
	}
	public NewRecordpage enterLastname(String lname) {
	driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
	return this;
	}
	public NewRecordpage enterTitle(String title) {
	driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
	return this;
	}
//	public void enterBusphnnum() {
//		driver.findElement(By.xpath("//input[@id='sys_user.phone']"))
//	}
	public UsersviewVerificationpage clickSubmit() throws InterruptedException {
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	Thread.sleep(1000);
	return new UsersviewVerificationpage(driver,node,dom);
	}
	
}
