package general.tests;

import general.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 25-Nov-16.
 */
public class MainPageTests extends TestBase {


    //test for checking whether link "Вход" present
    @Test
    public void isEnterLinkPresent(){
        Assert.assertTrue(app.isElementPresent(".//a[@href='/login']"));
        Assert.assertEquals(app.getTextOfElement(".//a[@href='/login']"),"Вход","There is no element with name 'Вход'");
        }

    //test for checking is "Вход" clickable
    @Test
    public void isEnterClickable(){
        Assert.assertTrue(app.isElementClickable(".//a[@href='/login']"));
    }

    //test for checking whether link "Регистрация" present
    @Test
    public void isRegisterLinkPresent(){
        Assert.assertTrue(app.isElementPresent("//a[@href='/signup']"));
    }

    //test for checking is "Регистрация" clickable
    @Test
    public void isRegisterClickable(){
        Assert.assertTrue(app.isElementClickable("//a[@href='/signup']"));
    }

    //test for checking whether action passes to Register form
    @Test
    public void goToRegisterForm(){
        app.isElementPresent("//a[@href='/signup']");
        app.isElementClickable("//a[@href='/signup']");
        //Assert.assertTrue(app.isElementClickable("//a[@href='/signup']"));
    }

}



