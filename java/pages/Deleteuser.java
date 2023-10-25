package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class Deleteuser extends CommonClass{
	String Mobilenumber;
	public Deleteuser(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	} 
	
	public Deleteuser getPhnnum() throws InterruptedException {
		Thread.sleep(2000);
		String getPhnnum = driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).getAttribute("value");
		System.out.println("Mobilenumber: "+getPhnnum);
		Mobilenumber=getPhnnum;
		//System.out.println(Mobilenumber);
		return this;
	}
	public Deleteuser clickDeletebutton() {
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
		return this;
	}
	
	public Deleteuser clickOkdeletebutton() throws InterruptedException {
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public Deleteuser deleteCallerverification() throws InterruptedException{
		Thread.sleep(2000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(2000);
		searchbox.click();
		searchbox.sendKeys("Mobilenumber",Keys.RETURN);
		Thread.sleep(1000);
		String confirmation = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if (confirmation.equals("No records to display")) {
			System.out.println("User successfully deleted!");
		} else {
			System.out.println("User not deleted");
		}
		return this;
	}
}
