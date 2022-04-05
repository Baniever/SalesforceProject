
// Verify whether a case is successfully created when all the fields are provided with inputs

package salesforceCaseMgmt;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SalesforceBasePage.BasePage;
import SalesforceBasePage.Login;

public class AccepCriteriaOne_TC2 extends BasePage {

	@BeforeClass

	public void setUp() {
		Login.initialize();
	}

	@Test(suiteName = "Salesforce", testName = "AcceptanceCriteria1_TC2", description = "AcceptanceCriteria1_TC2", enabled = true)
	@Parameters({ "ori", "subjTC2", "reason", "comments" })
	public void caseScreen(String ori, String subj, String reason, String comments) throws InterruptedException {

		clickCaseTab();
		clickNewCase();
//	clickCaseOrigin();
		selectCaseOrigin(ori);
		selectCaseReason(reason);
		inputSubject(subj);
		inputComments(comments);
		clickSave();
	}

	@AfterClass
	public void quit() {

//	Login.closeBrowser();
	}
}
