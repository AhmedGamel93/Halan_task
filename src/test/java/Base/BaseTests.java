package Base;

import Pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class BaseTests {

    public static WebDriver driver ;



    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver" , "D:\\Halan_Task\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.testyou.in/Login.aspx");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot.toPath(), new File("src/test/resources/screenshots" + result.getName() + ".png").toPath());

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}


