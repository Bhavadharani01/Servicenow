package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class Updateuser extends CommonClass{
	public Updateuser(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}

	public Updateuser updateBusphnum(String bpnum) {
		WebElement bphnum = driver.findElement(By.xpath("(//input[@class='form-control phone-number'])[1]"));
		bphnum.clear();
		bphnum.sendKeys(bpnum);
		return this;
	}
	public Updateuser clickUpdatebutton() {
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		System.out.println("User information updated successfully!");
		return this;
	} 
	
}
