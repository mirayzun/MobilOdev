import com.thoughtworks.gauge.Step;

public class HomePage extends BaseMethod{
    @Step("<id> li book butonuna tikla")
    public void  bookButonClick(String id){
        clickByid(id);
    }
}
