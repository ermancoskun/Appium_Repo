package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement guestButton;

    static TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
    public static void ucButtonTiklama(int baslangic, int bitis, int xCoordinat, int yCoordinat,int wait){
        for (int i = baslangic; i < bitis; i++) {
            action.press(PointOption.point(xCoordinat,yCoordinat))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release()
                    .perform();
        }
    }

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement kalkis;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSilme;

    @FindBy(xpath = "//*[@text='İzmir, Turkey']")
    public WebElement izmir;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "(//*[@text='Berlin, Germany'])[1]")
    public WebElement berlin;

    @FindBy(xpath =  "(//*[@text='Anywhere'])[1]"  )
    public WebElement anyWhere;

    @FindBy(xpath = "(//*[@text='Anywhere'])[1]")
    private WebElement anyTimeButton;

    public void anyTimeButtonClick(){
        anyTimeButton.click();
    }

}
