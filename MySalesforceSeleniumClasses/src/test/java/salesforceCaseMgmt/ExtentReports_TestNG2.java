package salesforceCaseMgmt;

import java.io.File;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReports_TestNG2 implements IReporter {

	Date date = new Date();
	String timeStamp = new SimpleDateFormat("ddMMyyyy_hhmmssa").format(Calendar.getInstance().getTime());
	private ExtentReports extent;
	public static String msg = "";
	public static String screenShotPath;
	WebDriver driver;
	public static ArrayList<String> arr = new ArrayList<String>();
	int i = 0;

	public void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			List<ITestResult> resultList = new LinkedList<ITestResult>(tests.getAllResults());
			class ResultComparator implements Comparator<ITestResult> {
				public int compare(ITestResult r1, ITestResult r2) {
					return getTime(r1.getStartMillis()).compareTo(getTime(r2.getStartMillis()));
				}
			}

			Collections.sort(resultList, new ResultComparator());

			for (ITestResult result : resultList) {
//     			test = extent.startTest(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
				test = extent.startTest(result.getMethod().getDescription(), result.getMethod().getMethodName());
				test.getTest().setDescription(result.getMethod().getDescription());
				test.getTest().setStartedTime(getTime(result.getStartMillis()));
				test.getTest().setEndedTime(getTime(result.getEndMillis()));
				for (String message : Reporter.getOutput(result)) { // This code picks the log from Reporter object.**
					test.log(LogStatus.INFO, message);
				}

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				String message = "Testcase " + status.toString().toLowerCase() + "ed";
				if (result.getThrowable() != null)
					message = result.getThrowable().getClass() + ": " + result.getThrowable().getMessage();
				test.log(status, message);
				extent.endTest(test);
			}
		}
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		// extent = new ExtentReports(outputDirectory + File.separator+"Extent"+timeStamp+".html", true);

		extent = new ExtentReports(outputDirectory + File.separator + "Extent" + ".html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		System.out.println(outputDirectory + File.separator);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();

	}

	private Date getTime(long millis) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();

	}

}