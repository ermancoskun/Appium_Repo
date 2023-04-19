package tests;

import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class KiwiTest {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    KiwiPage page= new KiwiPage();

    @Test
    public void kiwiTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"),"uygulama yuklenemedi");
        // uygulamanin basariyla acildigi dogrulanir
        String scriptActual = page.guestButton.getText();
        String scriptExpected = "Continue as a guest";
        Assert.assertEquals(scriptActual,scriptExpected, "uygulama baslatilamadi");
        // misafir olarak devam et e tiklanir
        page.guestButton.click();
        Thread.sleep(500);
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        page.ucButtonTiklama(0,3,523,2035,500);
        // Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.kalkis.click();
        page.defaultUlkeSilme.click();
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("izmir");
        page.izmir.click();
        page.choose.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }

}
