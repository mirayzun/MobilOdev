import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BookPage extends BaseMethod{
    @Step("<xphat> li one-way butonuna tikla")
    public void oneWayButonClick(String xpaht) {
        clickByxpath(xpaht);
    }
    @Step("<id> li binis yeri secimi icin tikla")
    public void fromClick(String id){
        clickByid(id);
    }

    @Step("<id> li from alanina <text> degerini yaz")
    public void fromTextSend(String id, String text){
        sendKeyByid(id,text);
    }
    @Step("<xphat> li airporta tikla")
    public void fromAirportClik(String xphat){
        clickByxpath(xphat);
    }
    @Step("<id> li inis yeri secimi icin tikla")
    public void toClick(String id){
        clickByid(id);
    }
    @Step("<id> li date alanina tikla")
    public void dateClick(String id){
        clickByid(id);
    }
    @Step("<xphat> li yedi gun sonraki date tarihine tikla")
    public void dateElevenNext(String xphat){
        clickByxpath(xphat);
    }
    @Step("<id> li date confirm butonuna tikla")
    public void confirmButonClick(String id){
        clickByid(id);
    }
    @Step("<id> li search flights butonuna tikla")
    public void searchButonClick(String id){
        clickByid(id);
    }
    int result=0;
    @Step("<id> li search result degerini bul")
    public void resultText(String id){
        String value =returnIdText(id);
        result= Integer.valueOf(value.substring(0));
    }
    @Step("ucus ekrani kontrol et")
    public void checkFlight() {
        WebDriverWait wait= new WebDriverWait(appDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/booking_activity_conversational_message")));
        MobileElement element= appDriver.findElement(By.id("com.m.qr:id/booking_activity_conversational_message"));
        if (element.isDisplayed()) {
            logger.info("Ucus Secim Ekrani Basariyla Cagirildi");
            System.out.println("Ucus Secim Ekrani Basariyla Cagirildi");
        }else {
            logger.info("Ucus Secim Ekrani Çagirilamadi");
            System.out.println("Ucus Secim Ekrani Çagirilamadi");
        }
    }
    String kalkisSaati=null;
    String inisSaati=null;

    Random random = new Random();
    int number= 0;
    @Step("<xphat> li ucusa tikla")
    public void ucusClick(String xphat){
        number= random.nextInt(result/2);
        String xphatValue=xphat+"[%s]"+number;
        clickByxpath(xphatValue);
    }
    @Step("<xphat> li ucus degerlerini al")
    public void saatGet(String xphat){
        String xphatValue=xphat+"[%s]"+number+"/android.widget.TextView[1]";
        kalkisSaati= returnXpatText(xphatValue);
        String xphatValue2=xphat+"[%s]"+number+"/android.widget.TextView[2]";
        inisSaati=returnXpatText(xphatValue2);
    }
    @Step("<xphat>li economy class secimi yapilir")
    public void economyClick(String xphat){
       clickByxpath(xphat);
    }
    @Step("<id> li this fare butonu click")
    public void thisFareClick(String id){
        clickByid(id);
    }
    String gKalkisSaati=null;
    String gİnisSaati=null;
    @Step("<xphat> li kalkis time degerini alir")
    public void fromTime(String xphat) {
        gKalkisSaati=returnXpatText(xphat);
        logger.info("degerler ayni");
    }
    @Step("<xphat> li inis time degerini alir")
    public void toTime(String xphat){
        gİnisSaati=returnXpatText(xphat);
        logger.info("degerler ayni");
    }
    @Step("ucus kalkis kontrolu")
    public void compareFlyHours() {
        Assert.assertEquals("Uçuş saatlerinin önceki ve sonraki halleri eşit değil!",inisSaati,gİnisSaati);
        Assert.assertEquals("Varış saatlerinin önceki ve sonraki halleri eşit değil!",kalkisSaati,gİnisSaati);
    }

}
