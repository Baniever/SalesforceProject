

// Verify whether error message is displayed when case origin is not provided

package salesforceCaseMgmt;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SalesforceBasePage.BasePage;
import SalesforceBasePage.Login;

public class AccepCriteriaOne_TC3 extends BasePage {

	@BeforeClass

	public void setUp() {
		Login.initialize();
	}

	@Test

	public void caseScreen() throws InterruptedException {

		clickCaseTab();
		clickNewCase();
		clickSave();
		String actualError = storeError_BlankOrigin();
		String expectedError = "These required fields must be completed: Case Origin";
		Assert.assertEquals(expectedError, actualError);
	}

	@AfterClass
	public void quit() {

//	Login.closeBrowser();
	}
}
