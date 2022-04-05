

// Verify if the subject field is populated with default value when a new case is created with Subject as blank 

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

public class AccepCriteriaTwo_TC1 extends BasePage {

	@BeforeClass
	
	public void setUp() {
		Login.initialize();
	}
@Test
@Parameters ({"ori"})
public void caseScreen(String ori) throws InterruptedException {

	clickCaseTab();
	clickNewCase();
	selectCaseOrigin(ori);
	clickSave() ;
	String defSubject= storeDefaultSubject();
	assertTrue(!defSubject.isEmpty());
}

@AfterClass
public void quit() {

//	Login.closeBrowser();
}
}
