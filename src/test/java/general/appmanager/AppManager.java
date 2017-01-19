package general.appmanager;

        import general.model.User;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.NoSuchElementException;

        import static org.openqa.selenium.remote.BrowserType.CHROME;
        import static org.openqa.selenium.remote.BrowserType.FIREFOX;
        import static org.openqa.selenium.remote.BrowserType.IE;

/**
 * Created by user on 10-Nov-16.
 */
public class AppManager {

    private  LoginHelper loginHelper;
    private String browser;
    private final User user = new User();
    protected WebDriver wd;
    WebDriverWait wait;


    public AppManager(String browser) {
        this.browser = browser;


    }

    public void init(){

        switch(browser){
            case FIREFOX:
                wd = new FirefoxDriver();
                break;
            case CHROME:
                wd = new ChromeDriver();
                break;
            case IE:
                wd = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Browser is not chosen or another inner error occurs!");

        }
        // wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.posutochno.com/");
        loginHelper = new LoginHelper(wd);
        wait = new WebDriverWait(wd, 5);
    }

    public void stop() {
        wd.quit();
    }

    public void waitElement(String locator){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public String getErrorMessage(){
        waitElement("//*[@id='messages']");
        return wd.findElement(By.xpath("//*[@id='messages']")).getText();
    }

    public boolean isElementPresent(String locator){
       try{
           waitElement(locator);
           wd.findElement(By.xpath(locator));
           return true;

       }catch (NoSuchElementException e) {
            return false;
       }
    }

    public boolean isElementClickable(String locator){
        try{
            waitElement(locator);
            WebElement element =  wd.findElement(By.xpath(locator));
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            }return true;

        }catch (NoSuchElementException e) {
            return false;

        }
    }

    public void clickOnElement(String locator){
        waitElement(locator);
        wd.findElement(By.xpath(locator)).click();
    }

    public String getTextOfElement(String locator){
        waitElement(locator);
        return wd.findElement(By.xpath(locator)).getText();
    }

    public void goToSpecificLocal(String language, String locator){
        waitElement(locator);
        wd.findElement(By.xpath(locator)).click();
    }

    public boolean findElement(String locator){
        return true;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }
}

