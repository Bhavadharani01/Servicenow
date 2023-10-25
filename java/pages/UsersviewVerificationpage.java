package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class UsersviewVerificationpage extends CommonClass{
	String Mobilenumber;
	public UsersviewVerificationpage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}
	
	public UsersviewVerificationpage callerVerification() {
		String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		if (text.contains("Bhavadharani")) {
			System.out.println("New caller created!");		
		} else {
			System.out.println("New caller not created");
		}
		return this;
	}
	
}
