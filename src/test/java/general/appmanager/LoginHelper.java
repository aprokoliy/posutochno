package general.appmanager;

import general.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static general.TestBase.app;

/**
 * Created by user on 09-Dec-16.
 */
public class LoginHelper {


    protected WebDriver wd;

    public LoginHelper(WebDriver wd) {
        this.wd= wd;
    }


    public void goToLoginPage(){
        app.waitElement("//a[@data-ui-sref='login']");
        wd.findElement(By.xpath("//a[@data-ui-sref='login']")).click();
    }

    public void fillLoginForm(User user){
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
}
