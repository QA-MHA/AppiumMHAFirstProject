import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class FirstAndroidTest {

    public  AndroidDriver driver;
    public  AndroidTouchAction actions;


    @BeforeTest
    public void setUP() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"\\apps\\ApiDemos-debug.apk");
        //caps.setCapability("newCommandTimeout", "120000");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), caps);
        //String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
    }

    @Test
    public void click_App_Button(){
        //code
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click(); 
        driver.findElementByAccessibilityId("App").click(); 
    }

    private void scollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd)).release().perform();
    }

    @Test
    public void scrollTest(){
        //code   
        AndroidElement views =  (AndroidElement) driver.findElementByAccessibilityId("Views");
                
        views.click();
        actions = new AndroidTouchAction(driver)
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)));
        
        scollDown();

        AndroidElement Lists = (AndroidElement) driver.findElementByAccessibilityId("Lists");

        Lists.click();

        // actions = new AndroidTouchAction(driver);
        // actions.tap(ElementOption.element(views)).perform();
        //actions.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }

}
