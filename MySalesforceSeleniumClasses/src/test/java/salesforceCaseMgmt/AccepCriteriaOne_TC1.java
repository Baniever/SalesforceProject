package salesforceCaseMgmt;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SalesforceBasePage.BasePage;
import SalesforceBasePage.Login;

public class AccepCriteriaOne_TC1 extends BasePage {

	@BeforeClass
	
	public void setUp() {
		Login.initialize();
	}
@Test
@Parameters ({"ori","subj"})
public void caseScreen(String ori,String subj) throws InterruptedException {

	clickCaseTab();
	Thread.sleep(10000);
	clickNewCase();
	String exporigin= selectCaseOrigin(ori);
	inputSubject(subj);
	clickSave() ;
	String actualorigin= storeSubject();
	Assert.assertEquals(exporigin, actualorigin);
}

@AfterClass
public void quit() {

//	Login.closeBrowser();
}
}
