import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethod {
    AppiumDriver<MobileElement> appDriver;
    Logger logger= LogManager.getLogger(BaseMethod.class);
    public BaseMethod(){
        appDriver=BaseTest.appDriver;
    }

    public void assertByid(String id, String text){
        MobileElement element= appDriver.findElement(By.id(id));
        Assert.assertTrue(element.getText()+"text degeri ile verilen deger uyusmuyor",element.getText().equals(text));
    }

    public String returnIdText(String id){
        return appDriver.findElement(By.id(id)).getText();
    }
    public String returnXpatText(String xphat){
        return appDriver.findElement(By.xpath(xphat)).getText();
    }
    public void clickByid(String id){
        MobileElement element= appDriver.findElement(By.id(id));
        if(element.isDisplayed()){
            element.click();
        }
    }
    public void clickByxpath(String xphat){
        appDriver.findElement(By.xpath(xphat)).click();
    }
    public void sendKeyByxphat(String xphat, String value){
        MobileElement element= appDriver.findElement(By.xpath(xphat));
        element.clear();
        element.sendKeys(value);
    }
    public void sendKeyByid(String id, String value){
        MobileElement element= appDriver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }

    public void setupChech(){
        WebDriverWait wait= new WebDriverWait(appDriver,10);
    }
    public void SwipeUp(){
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 300; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
        new TouchAction(appDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }



}
