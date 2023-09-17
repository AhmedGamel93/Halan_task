package Login;

import Base.BaseTests;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {


@Test
    public void UnsuccessfulLogin()
{
     LoginPage lPage = new LoginPage(driver);
     lPage.setEmail("invalid Email");
     lPage.setPassword("invalid Password");
     lPage.ClickLoginBtn();
     var alertMessage = lPage.getAlertMessage();
    Assert.assertEquals(alertMessage , "Userid or Password did Not Match !!" , "Incorrect message ");
}
}
