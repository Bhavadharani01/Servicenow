package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.CommonClass;
import pages.Loginpage;

public class CreateNewCaller extends CommonClass{
	@BeforeTest
	public void setup() {
	    excelfile="Login";
		testName="Create new caller";
        testDescription="Create caller with ServiceNow";
        testCategory="smoke";
        testAuthor="Bhavadharani";     
}
	@Test(dataProvider="fetchData")
	public void runLogin(String uname,String pwd,String fname,String lname,String title) throws IOException, InterruptedException {
		Loginpage lp= new Loginpage(driver,node,dom);
		lp.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.enterCallers()
		.clickCallers()
		.clickNew()
		.clickX().enterFirstname(fname).enterLastname(lname).enterTitle(title).clickSubmit()
		.callerVerification();
		

}
}