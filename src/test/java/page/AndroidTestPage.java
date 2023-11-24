package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AndroidTestPage {

    public AndroidTestPage(){
        PageFactory.initElements(Driver.getAndroidDriver(),this);
    }
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
    private WebElement dropDownList;


    /***************************METHOD********************************/

    public void dropDownListClick(){
        dropDownList.click();
    }

}
