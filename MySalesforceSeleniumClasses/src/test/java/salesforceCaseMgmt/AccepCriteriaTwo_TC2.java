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

public class AccepCriteriaTwo_TC2 extends BasePage {

	@BeforeClass
	
	public void setUp() {
		Login.initialize();
	}
@Test
@Parameters ({"caseNum"})
public void caseScreen(String caseNum) throws InterruptedException {

	clickCaseTab();
	Thread.sleep(10000);
	clickSearch(caseNum);
	clickFirstRecord();
	clickEdit();	
	clearSubject();
	clickSave_ExistingRec();
	String defSubject= storeDefaultSubject_existingRec();
	assertTrue(!defSubject.isEmpty());
}

@AfterClass
public void quit() {

//	Login.closeBrowser();
}
}
