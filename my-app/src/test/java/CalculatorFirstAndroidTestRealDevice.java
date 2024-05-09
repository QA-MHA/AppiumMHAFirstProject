import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;


public class CalculatorFirstAndroidTestRealDevice {

    AndroidDriver driver;


    @BeforeTest
    public void setUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("deviceName", "Android 7.1.1");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("newCommandTimeout", "10000");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), caps);
        //String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
    }

    @Test
    public void click_App_Button(){
        //code
       // driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
        driver.findElement(By.id("digit_1")).click(); 
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_7")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "130");
        driver.findElement(By.id("eq")).click();

        
    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }

}
