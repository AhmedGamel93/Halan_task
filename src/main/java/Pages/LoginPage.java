package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver ;
    private By emailField   = By.id("ctl00_CPHContainer_txtUserLogin");
    private  By passwordField = By.id("ctl00_CPHContainer_txtPassword");
    private By LoginBtn = By.id("ctl00_CPHContainer_btnLoginn");
    private By Message = By.id("ctl00_CPHContainer_lblOutput");

    public  LoginPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void setPassword(String Password)
    {
        driver.findElement(passwordField).sendKeys(Password);
    }
    public void setEmail(String Email)
    {
        driver.findElement(emailField).sendKeys(Email);
    }

    public void ClickLoginBtn()
    {
        driver.findElement(LoginBtn).click();
    }

    public String getAlertMessage()
    {
        return driver.findElement(Message).getText();
    }
}
