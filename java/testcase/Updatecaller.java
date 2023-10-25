package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.CommonClass;
import pages.Loginpage;

public class Updatecaller extends CommonClass{
	@BeforeTest
	public void setup() {
	    excelfile="update";
		testName="Update existing caller";
        testDescription="Update existing caller with ServiceNow";
        testCategory="smoke";
        testAuthor="Bhavadharani";     
}
	@Test(dataProvider="fetchData")
	public void runUpdate(String uname,String pwd,String srch,String bpnum) throws IOException, InterruptedException {
		Loginpage lp= new Loginpage(driver,node,dom);
		lp.enterUsername(uname)
		.enterPassword(pwd)
		.clickLogin()
		.clickAll()
		.enterCallers()
		.clickCallers()
		.clickSearch(srch)
		.clicki().clickOpenrecord()
		.updateBusphnum(bpnum).clickUpdatebutton();
}
}