package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.CommonClass;
import pages.Loginpage;

public class DeleteCaller extends CommonClass{
	@BeforeTest
	public void setup() {
	    excelfile="delete";
		testName="Delete existing caller";
        testDescription="Delete caller in ServiceNow";
        testCategory="smoke";
        testAuthor="Bhavadharani";      
}
	@Test(dataProvider="fetchData")
	public void runDelete(String uname,String pwd,String srch) throws IOException, InterruptedException {
		Thread.sleep(2000);
		Loginpage lp= new Loginpage(driver,node,dom);
		lp.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.enterCallers()
		.clickCallers() 
		.clickSearch(srch)
		.clicki()
		.clickOpenrecordfrDelete()
		.getPhnnum()
		.clickDeletebutton()
		.clickOkdeletebutton()
		.deleteCallerverification();
}
}