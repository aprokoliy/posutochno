package general.tests;

import general.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

/**
 * Created by Ann Prokoliy on 10-Nov-16.
 */
public class AuthorizationUITests extends TestBase{




    //test for checking is present on Log in page
    @Test(priority = 1)
    public void isLogoPresent(){
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//img[@title='Посуточно']"));
    }

    //test for checking is Logo clickable
    @Test(priority = 2)
    public void isLogoClickable(){
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@title='Посуточно']"));
    }

     //test for checking whether link Enter is active
    @Test
    public void isEnterActive() {
        app.getLoginHelper().goToLoginPage();
        assertThat("Вход", is(app.getTextOfElement(".//a[@href='/login']")));
        Assert.assertTrue(app.isElementPresent("//li[@class='active']"));

    }

    //test for checking whether action passes to Main page after clicking on Logo
    @Test(priority = 3)
    public void isActionPassToMainPage(){
        app.getLoginHelper().goToLoginPage();
        app.clickOnElement("//img[@title='Посуточно']");
        app.waitElement("//h1[@class='ng-binding ng-scope']");
        Assert.assertEquals(app.getTextOfElement("//h1[@class='ng-binding ng-scope']"),"Снять квартиру посуточно в Москве");
    }

    //test check is RU and image present
    @Test
    public void ruIsPresent() {
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//img[@src='images/lang-ru.png']"));
        Assert.assertEquals("RU", app.getTextOfElement("//span[@class='lang-text']"),"Text of image is not RU");
    }

    //test for checking is RU clickable
    @Test(priority = 2)
    public void isRuClickable(){
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@src='images/lang-ru.png']"));
    }

    //test check is EN and image present
    @Test
    public void isEnPresent() {
        app.getLoginHelper().goToLoginPage();
        app.clickOnElement("//img[@src='images/lang-en.png']");
        Assert.assertTrue(app.isElementPresent("//img[@src='images/lang-en.png']"));
        Assert.assertEquals("EN", app.getTextOfElement("//span[@class='lang-link active']"),"Text of image is not EN");
    }

    //test for checking is EN clickable
    @Test
    public void isEnClickable(){
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@src='images/lang-en.png']"));
    }

   //test for checking is Registration link and text present
    @Test
    public void isRegistrationLinkPresent() {
        app.getLoginHelper().goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//a[ @data-ui-sref='signup']"));
        Assert.assertEquals("Регистрация", app.getTextOfElement("//a[ @data-ui-sref='signup']"),"Text of link is not Регистрация");

    }

}
