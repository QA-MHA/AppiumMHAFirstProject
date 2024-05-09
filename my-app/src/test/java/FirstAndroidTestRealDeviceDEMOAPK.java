import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;


public class FirstAndroidTestRealDeviceDEMOAPK {

    public  AndroidDriver driver;
    public  AndroidTouchAction actions;


    @BeforeTest
    public void setUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("deviceName", "Android 7.1.1");
        caps.setCapability("app", System.getProperty("user.dir")+"\\apps\\ApiDemos-debug.apk");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), caps);
        //String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
    }

    @Test
    public void click_App_Button(){
        //code
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();   
    }

    @Test
    public void scrollTest(){
        //code   
        AndroidElement views =  
                (AndroidElement) driver.findElementByAccessibilityId("Text");

        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }

}
