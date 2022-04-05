
// Verify if the subject field is populated with default value when an existing case is updated with Subject as blank 

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

	@Test(suiteName = "Salesforce", testName = "AcceptanceCriteria2_TC2", description = "AcceptanceCriteria2_TC2", enabled = true)
	@Parameters({ "caseNum" })
	public void caseScreen(String caseNum) throws InterruptedException {

		clickCaseTab();
		clickSearch(caseNum);
		clickFirstRecord();
		clickEdit();
		clearSubject();
		clickSave_ExistingRec();
		String defSubject = storeDefaultSubject_existingRec();
		assertTrue(!defSubject.isEmpty());
	}

	@AfterClass
	public void quit() {

//	Login.closeBrowser();
	}
}
