package stepDefinition;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.DriverFactory;
import utility.GenericMethods;
import java.io.IOException;

public class Hooks extends DriverFactory {


    //static  String date = new SimpleDateFormat("dd_MM_yyyy_hh:mm:ss").format(new Date());

    /**
     * This Method will Launch the Browser, it will load the Application URL
     *
     * @throws IOException
     */

    @Before
    public void launchUrL() throws IOException {
        GenericMethods gm = new GenericMethods();
        initiatingBrowser();
        getDriver().get(gm.getUrl());
    }

//    /**
//     * For TestNg use
//     * @throws IOException
//     */
//    @BeforeTest
//    public void launchURL() throws IOException {
//        GenericMethods gm = new GenericMethods();
//        initiatingBrowser();
//        getDriver().get(gm.getUrl());
//    }
//
//    /**
//     * For TestNg
//     * @param scenario
//     */
//    @AfterTest
//    public void tearDOWN(Scenario scenario) {
//        GenericMethods gm = new GenericMethods();
//        try {
//            if (scenario.isFailed()) {
//                final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", scenario.getName());
//                gm.writeLoginfo("Successfully Captured screenShot for Failed scenario" + scenario.getName());
//            }
//        } catch (Exception pasha) {
//
//            gm.writeLoginfo("Facing issue Capturing ScreenShot : " + pasha);
//            System.err.println("Facing issue while capturing ScreenShot : " + pasha);
//        }
//        getDriver().quit();
//    }

    /**
     * This Method will close The All Opened Browser instances
     * When any Scenario get Failed it will capture screenshot and attached into the Extent Reports
     *
     * @param scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        GenericMethods gm = new GenericMethods();
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "failed"+scenario.getName()+".png", scenario.getName());
                gm.writeLoginfo("Successfully Captured screenShot for Failed scenario" + scenario.getName());
            }
        } catch (Exception chandu_pasha) {
            gm.writeLoginfo("Facing issue Capturing ScreenShot : " + chandu_pasha);
            System.err.println("Facing issue while capturing ScreenShot : " + chandu_pasha);
        }
        getDriver().quit();
    }
}
