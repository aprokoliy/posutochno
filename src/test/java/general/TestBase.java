package general;

import general.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by user on 10-Nov-16.
 */
public class TestBase {
    public static final AppManager app = new AppManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception{
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }
}
