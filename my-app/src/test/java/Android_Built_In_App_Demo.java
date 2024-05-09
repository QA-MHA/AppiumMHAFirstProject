import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Android_Built_In_App_Demo {

    AndroidDriver driver;


    @BeforeTest
    public void setUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "apps.r.calculator");
        caps.setCapability("appActivity", ".CalculatorActivity");
        //caps.setCapability("autoGrantPermissions", false);



        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), caps);
        //String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
    }


    @Test
    public void click_test(){
        //code
        driver.findElement(By.id("digit_1")).click(); 
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_7")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "130");
        driver.findElement(By.id("eq")).click();

        //Assert.assertEquals(driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\'apps.r.calculator:id/formula\']")).getText(), "130");

    }

     @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }

}
