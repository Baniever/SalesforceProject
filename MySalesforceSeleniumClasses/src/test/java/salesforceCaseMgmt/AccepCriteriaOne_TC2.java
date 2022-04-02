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
@Test
@Parameters ({"ori","subjTC3","reason","comments"})
public void caseScreen(String ori,String subj,String reason,String comments) throws InterruptedException {

	clickCaseTab();
	Thread.sleep(10000);
	clickNewCase();
//	clickCaseOrigin();
	selectCaseOrigin(ori);
	selectCaseReason(reason);
	inputSubject(subj);
	inputComments(comments);
	clickSave() ;
}

@AfterClass
public void quit() {

//	Login.closeBrowser();
}
}
