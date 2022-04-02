package salesforceCaseMgmt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SalesforceBasePage.BasePage;
import SalesforceBasePage.Login;

public class AccepCriteriaThree_TC1 extends BasePage {

	@BeforeClass
	
	public void setUp() {
		Login.initialize();
	}
@Test
@Parameters ({"caseNumAC3"})
public void caseScreen(String caseNum) throws InterruptedException {

	clickCaseTab();
	Thread.sleep(10000);
	clickSearch(caseNum);
	clickFirstRecord();
	clickDelete();	
	String actualMessage = storeDeleteAlertmessage();
	String expectedMessage = "Case Cannot Be Deleted!";
	Assert.assertEquals(expectedMessage, actualMessage);
}

@AfterClass
public void quit() {

//	Login.closeBrowser();
}
}
