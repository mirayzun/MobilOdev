import com.thoughtworks.gauge.Step;

public class SkipPage extends BaseMethod{
    @Step("<id> li <text> deger geldi mi kontrol et")
    public void uygulamaUp(String id, String text){
        setupChech();
        assertByid(id,text);
    }
    @Step("<id> li skip butonuna tikla")
    public void skipButonClick(String id){

        clickByid(id);
    }

    @Step("<id> li onboarding butonuna tikla")
    public void skipOnboardingButonClick(String id){
        clickByid(id);
    }

    @Step("<id> li bildirim kapatma butonuna tikla")
    public void declineButonClick(String id){
        clickByid(id);
    }
}
