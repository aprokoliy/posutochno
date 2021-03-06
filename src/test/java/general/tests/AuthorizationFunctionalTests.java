package general.tests;

import general.TestBase;
import general.model.User;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by user on 29-Nov-16.
 */
public class AuthorizationFunctionalTests extends TestBase {



    // test checks whether language is changeable
    @Test
    public void isLanguageChangeable() {
        app.getLoginHelper().goToLoginPage();
        if (app.isElementPresent("//img[@src='images/lang-en.png']")) {
                app.goToSpecificLocal("EN", "//img[@src='images/lang-en.png']");
                assertThat("Enter your account", is(app.getTextOfElement("//h1")));
        }
        if(app.isElementPresent("//img[@src='images/lang-ru.png']")){
            app.goToSpecificLocal("RU","//img[@src='images/lang-ru.png']");
            assertThat("Вход в личный кабинет", is(app.getTextOfElement("//h1")));
        }

    }

    //test for checking log in with valid, correct data
    @Test
    public void correctLogin(){
        User user = new User("katerynas@ua.fm", "123456");
        app.getLoginHelper().goToLoginPage();
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().approveLogIn();
        app.getLoginHelper().successfulLogIn();
    }

    //test for checking error text, when log in as unregistered user
    @Test(priority = 4)
    public void invalidLogin(){
        app.getLoginHelper().goToLoginPage();
        app.getLoginHelper().fillLoginForm(new User("katery@ua.fm","0987654"));
        app.getLoginHelper().approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

    //test for checking error text, when try to log in without filling in any fields
    @Test(enabled = false)
    public void emptyFields(){
        app.getLoginHelper().goToLoginPage();
        app.getLoginHelper().approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

    //test for checking error text, when enter invalid format of email while log in
    @Test(priority = 5)
    public void incorrectEmailFormat(){
        app.getLoginHelper().goToLoginPage();
        app.getLoginHelper().fillLoginForm(new User("katerua.fm","123456"));
        app.getLoginHelper().approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

    @Test(priority = 6)
    public void incorrectPasswordFormat(){
        app.getLoginHelper().goToLoginPage();
        app.getLoginHelper().fillLoginForm(new User("katerynas@ua.fm","1"));
        app.getLoginHelper().approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }
}

