package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.CommonClass;
import io.github.sukgu.Shadow;

public class HomePage extends CommonClass{
	public HomePage(ChromeDriver driver,ExtentTest node,Shadow dom) {
		this.driver=driver;
		this.node=node;
		this.dom=dom;
	}
	
	public HomePage clickAll() throws InterruptedException {
	dom.setImplicitWait(40);
	dom.findElementByXPath("//div[text()='All']").click();
	Thread.sleep(2000);
	return this;
	}
	public HomePage enterCallers() throws InterruptedException {
	dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers", Keys.ENTER);
	Thread.sleep(2000);
	return this;
	}
	public Usersviewpage clickCallers() throws InterruptedException {
	dom.findElementByXPath("//a[@class='nested-item item-label keyboard-navigatable highlighted-item']").click();
	Thread.sleep(2000);
	return new Usersviewpage(driver,node,dom);
	}
}
