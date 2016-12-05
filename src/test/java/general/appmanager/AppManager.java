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
        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.remote.BrowserType.CHROME;
        import static org.openqa.selenium.remote.BrowserType.FIREFOX;
        import static org.openqa.selenium.remote.BrowserType.IE;

/**
 * Created by user on 10-Nov-16.
 */
public class AppManager {

    private WebDriver wd;
    private String browser;
    WebDriverWait wait;
    private final User user = new User();


    public AppManager(String browser) {
        this.browser = browser;
        //User user = new User();

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
        wait = new WebDriverWait(wd, 5);
    }

    public void stop() {
        wd.quit();
    }

    public void waitElement(String locator){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void goToLoginPage(){
        waitElement("//a[@data-ui-sref='login']");
        wd.findElement(By.xpath("//a[@data-ui-sref='login']")).click();
    }

    public void fillLoginForm(User user){
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(user.getEmail());
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(user.getPassword());
    }

    public void approveLogIn(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void successfulLogIn(){
        wd.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        wd.findElement(By.xpath("//a[@data-ui-sref='create-venue']"));
    }

    public void invalidLoginOrPassword(){
        wd.findElement(By.xpath("//*[@id='messages']"));
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
}

