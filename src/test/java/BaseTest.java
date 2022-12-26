import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appDriver ;
    protected boolean localAndroid= true;
    Logger logger= LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        logger.info("!!!!!!!!!!!!!!!!Local test basliyor!!!!!!!");
        if (localAndroid){
        logger.info("'!!!!!!!!!!!!Local android test basliyor!!!!!!!!!!");
            System.out.println("!!!!!!!!!!! Localde Android  testi başlıyor !!!!!!!!!!");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.m.qr");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.m.qr.home.onboarding.ui.OnBoardingActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appDriver = new AndroidDriver(url,desiredCapabilities);
        }
        else{
            logger.info("!!!!!!!!!!!!!!!!Local ios test basliyor!!!!!!!");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities
                    .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            desiredCapabilities
                    .setCapability(MobileCapabilityType.UDID, "lokalinizde bağlı olan telefonun udid bilgisini gir");
            desiredCapabilities
                    .setCapability(IOSMobileCapabilityType.BUNDLE_ID, "bundle id bilgisini gir");
            desiredCapabilities
                    .setCapability(MobileCapabilityType.DEVICE_NAME, "lokaldeki telefonun ismini gir");

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "lokaldeki telefon version bilgisini gir");

            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appDriver = new IOSDriver(url, desiredCapabilities);
        }
    }
    @AfterScenario
    public void afterScenario(){
        appDriver.quit();
    }

}
