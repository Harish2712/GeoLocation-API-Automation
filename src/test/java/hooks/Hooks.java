package hooks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.JsonUtils;

public class Hooks {

    //public static List<Map<String, Object>> testData;
	public static List<Map<String, Object>> positiveTestData;
    public static List<Map<String, Object>> negativeTestData;
   

    @Before
    public void setUp() {
        //testData = loadTestData("/geolocation-api-automation/src/test/resources/testdataAPI/positive");

        positiveTestData = loadTestData("src/test/resources/testdataAPI/positive");
        negativeTestData = loadTestData("src/test/resources/testdataAPI/negative");
        
    }

    public List<Map<String, Object>> loadTestData(String testDir) {
        File folder = new File(testDir);
        File[] listOfFiles = folder.listFiles();
        List<Map<String, Object>> testData = new ArrayList<Map<String, Object>>();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    testData.add(JsonUtils.readJsonFromFile(file.getPath()));
                }
            }
        }
        return testData;
    }
    private static  ExtentReports extent;
    private static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            test.fail(scenario.getName() + " is failed");
        } else {
            test.pass(scenario.getName() + " is passed");
        }
        extent.flush();
        //Desktop.getDesktop().browse(new File("extent-report.html").toURI());
    }
    @AfterClass
    public void openReport() throws IOException {
    	Desktop.getDesktop().browse(new File("extent-report.html").toURI());
    }
}
