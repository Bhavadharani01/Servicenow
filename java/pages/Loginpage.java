package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class Loginpage extends CommonClass{
	public Loginpage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.dom=dom;
		this.node=node;
	}

	public Loginpage enterUsername(String uname) throws IOException {
	try {
		driver.findElement(By.id("user_name")).sendKeys(uname);
		reportStep(uname+"Username entered successfully","pass");
	} catch (Exception e) {
		reportStep("Username is not entered"+e,"fail");		
	}//Y3Lfm$$oRE8l
	return this;
	}
	public Loginpage enterPassword(String pwd) throws IOException {
	try {
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		reportStep(pwd+"Password entered successfully","pass");
	} catch (Exception e) {
		reportStep("Password is not entered"+e,"fail");
	}
	return this;
	}
	public HomePage clickLogin() throws InterruptedException, IOException {
	try {
		driver.findElement(By.id("sysverb_login")).click();
		reportStep("Login button is clicked","pass");
	} catch (Exception e) {
		reportStep("Login button is not clicked"+e,"fail");
	}
	Thread.sleep(5000);
	return new HomePage(driver,node,dom);
	}
}
