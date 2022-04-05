package SalesforceBasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesforceBasePage.Login;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BasePage {

	@SuppressWarnings("deprecation")
	public void commonWait() {
		Login.getdriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void clickCaseTab() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement caseTab = Login.getdriver().findElement(By.xpath("(//a[@title='Cases'])"));
		js.executeScript("arguments[0].click();", caseTab);
		Thread.sleep(10000);
		commonWait();
	}

	public void clickNewCase() {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement newcase = Login.getdriver().findElement(By.xpath("(//a[@title='New'])"));
		js.executeScript("arguments[0].click();", newcase);
		commonWait();
		WebDriverWait wait1 = new WebDriverWait(Login.getdriver(), Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[starts-with(@id,'85') and @class= 'uiPopupTrigger']")));
		commonWait();
	}

	public void clickSearch(String caseNum) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement searchCase = Login.getdriver().findElement(By.xpath("(//input[@name='Case-search-input'])"));
		js.executeScript("arguments[0].click();", searchCase);
		searchCase.sendKeys(caseNum);
		searchCase.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		commonWait();
	}

	public void clickFirstRecord() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement firstRec = Login.getdriver().findElement(By.xpath("((//a[@data-refid='recordId']))[1]"));
		js.executeScript("arguments[0].click();", firstRec);
		Thread.sleep(10000);
		commonWait();
	}

	public void clickSub_FirstRecord() {
		Actions act = new Actions(Login.getdriver());
		WebElement subFirstRec = Login.getdriver().findElement(By.xpath("((//a[@data-refid='recordId']))[2]"));
		act.click(subFirstRec);
		act.doubleClick(subFirstRec).perform();
		commonWait();
	}

	public void show3moreAction() {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement expand = Login.getdriver().findElement(By.xpath("(//a[@title='Show 3 more actions'])"));
		js.executeScript("arguments[0].click();", expand);
		commonWait();
	}

	public void clickEdit() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement edit = Login.getdriver().findElement(By.xpath("(//button[@name='Edit'])"));
		js.executeScript("arguments[0].click();", edit);
		Thread.sleep(10000);
		commonWait();
	}

	public void clickDelete() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Login.getdriver();
		WebElement delete = Login.getdriver().findElement(By.xpath("(//button[@name='Delete'])"));
		js.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement confirmDel = Login.getdriver().findElement(By.xpath("//span[contains(text(),'Delete')]"));
		confirmDel.click();
		Thread.sleep(5000);
	}

	public String storeDeleteAlertmessage() {
		String delAlert = Login.getdriver().findElement(By.xpath("  //div[@class = 'detail slds-text-align--center']"))
				.getText();
		commonWait();
		System.out.println(delAlert);
		return delAlert;
	}

	public String storeAlertmessage() {
		String act = Login.getdriver().findElement(By.xpath("//lightning-formatted-text[contains(text(),'Phone')]"))
				.getText();
		commonWait();
		System.out.println(act);
		return act;
	}

	public void clickCaseOrigin() {
		WebElement origin = Login.getdriver().findElement(By.xpath("(//div[@class = 'uiMenu'])[3]"));
		origin.click();
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public String selectCaseOrigin(String ori) {
		WebElement origin = Login.getdriver()
				.findElement(By.xpath("//div[starts-with(@id,'85') and @class= 'uiPopupTrigger']"));
		origin.click();
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement originSelct = Login.getdriver().findElement(By.xpath("(//a[@title='" + ori + "'])"));
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		originSelct.click();

		String expected = Login.getdriver()
				.findElement(By.xpath("//div[starts-with(@id,'85') and @class= 'uiPopupTrigger']")).getText();
		System.out.println(expected);

		commonWait();
		return expected;
	}

	public String selectCaseReason(String reason) {
		WebElement origin = Login.getdriver()
				.findElement(By.xpath("//div[starts-with(@id,'135') and @class= 'uiPopupTrigger']"));
		origin.click();
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement originSelct = Login.getdriver().findElement(By.xpath("(//a[@title='" + reason + "'])"));
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		originSelct.click();

		String expected = Login.getdriver()
				.findElement(By.xpath("//div[starts-with(@id,'85') and @class= 'uiPopupTrigger']")).getText();
		System.out.println(expected);

		commonWait();
		return expected;
	}

	public void inputSubject(String subj) {
		WebElement sub = Login.getdriver()
				.findElement(By.xpath("//input[starts-with(@id,'203') and @class= ' input']"));
		sub.click();
		sub.sendKeys(subj);
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void inputComments(String comments) {
		WebElement sub = Login.getdriver()
				.findElement(By.xpath("//textarea[starts-with(@id,'246') and @class= ' textarea']"));
		sub.click();
		sub.sendKeys(comments);
		Login.getdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void clickSave() {
		WebElement save = Login.getdriver()
				.findElement(By.xpath("(//span[@class=' label bBody' and contains(text(), 'Save')])[3]"));
		save.click();
		commonWait();
	}

	public void clickSave_ExistingRec() {
		WebElement save = Login.getdriver()
				.findElement(By.xpath("(//span[@class=' label bBody' and contains(text(), 'Save')])[3]"));
		save.click();
		commonWait();
	}

	public String storeSubject() {
		String act = Login.getdriver().findElement(By.xpath("//lightning-formatted-text[contains(text(),'Phone')]"))
				.getText();
		commonWait();
		System.out.println(act);
		return act;
	}

	public void clearSubject() {
		WebElement clear = Login.getdriver()
				.findElement(By.xpath("//input[starts-with(@maxlength,'255') and @class= ' input']"));
		commonWait();
		clear.clear();
		commonWait();
	}

	public String storeDefaultSubject() {
		String def = Login.getdriver()
				.findElement(By
						.xpath("//lightning-formatted-text[@slot='outputField' and contains(text(), 'Ordinary Case')]"))
				.getText();
		commonWait();
		System.out.println(def);
		return def;
	}

	public String storeDefaultSubject_existingRec() {
		String def = Login.getdriver()
				.findElement(By
						.xpath("//lightning-formatted-text[@slot='outputField' and contains(text(), 'Ordinary Case')]"))
				.getText();
		commonWait();
		System.out.println(def);
		return def;
	}

	public String storeError_BlankOrigin() {
		String act = Login.getdriver()
				.findElement(By.xpath("//li[contains(text(),'These required fields must be completed: Case Origin')]"))
				.getText();
		commonWait();
		System.out.println(act);
		return act;

	}

}
