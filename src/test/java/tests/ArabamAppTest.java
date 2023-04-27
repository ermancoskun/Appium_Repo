package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {

    // Arabam kac para bolumune tiklayalim
// Aracimin fiyatini merak ediyorum bolumunetiklayalim
// Wolkswagen markasini secelim
// yil secimi yapalim
// model secimi yapalim
// govde tipini secelim
// yakit tipini secelim
// vites tipini secelim
// Versiyon secimi yapalim
// aracin km bilgilerini girelim
// aracin rengini secelim
// opsiyel donanim (varsa) seecelim
// degisen bilgisi ekleyerek tramer kaydi belirtelim
// aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
// uygulamayi kapatalim

    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri

    final String cihazAdi="PIXEL2";
    final String platformIsmi="Android";
    final String version="10.0";
    final String automation="UiAutomator2";

@BeforeTest
    public void setUp() throws MalformedURLException {

    DesiredCapabilities capabilities= new DesiredCapabilities();

    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
    capabilities.setCapability("appPackage","com.dogan.arabam"); // hangi uygulama uzerinde calismak istedigimizi apk infodan
    capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity"); // uygulamada hangi sayfayi gormek veya baslatmak istedgimiz
    //genelde Main.Activity ya da Homepage.activity olarak apk info icersinde activities kisminda gorulur
    capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
    // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bittikten sonra SIFIRLAR
    // eger true olursa uygulama calistiktan sonra yapilacak adimlari gercceklestirir uygulamayi islem bittikten sonra SIFIRLAMAZ
    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}

    @Test
    public void arabamTest() throws InterruptedException {
        // driver.findElement(By.xpath("//*[@text='İlan ver']")).click();
        // Arabam kac para bolumune tiklayalim
        driver.findElement(By.xpath("(//*[@text='Arabam kaç para?'])[1]")).click();
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        AndroidElement fiyatMerak =driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        fiyatMerak.click();
        // Wolkswagen markasini secelim
        TouchAction action= new TouchAction<>(driver);
        action.press(PointOption.point(546,2112))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(546,501)).release().perform();

        Thread.sleep(1000);

//        action.press(PointOption.point(546,501))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(546,2112))
//                .release().perform();


        driver.findElement(By.xpath("//*[@text='Volkswagen']")).click();
        // yil secimi yapalim
        driver.findElement(By.xpath("//*[@text='2011']")).click();
        // model secimi yapalim
        driver.findElement(By.xpath("//*[@text='Passat']")).click();
        // govde tipini secelim
        driver.findElement(By.xpath("//*[@text='Sedan']")).click();
        // yakit tipini secelim
        driver.findElement(By.xpath("//*[@text='Benzin']")).click();
        // vites tipini secelim
        driver.findElement(By.xpath("//*[@text='Yarı Otomatik']")).click();
        // Versiyon secimi yapalim
        Thread.sleep(1000);
        action.press(PointOption.point(918,1913)).release().perform();
        // aracin km bilgilerini girelim
        if (driver.isKeyboardShown()){
            driver.getKeyboard().sendKeys("190000");
        }else {
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("150000");
        }
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();
        // aracin rengini secelim
        driver.findElement(By.xpath("//*[@text='Gri (metalik)']")).click();
        // opsiyel donanim (varsa) seecelim
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        driver.findElementById("com.dogan.arabam:id/iv_B01001").click();
        driver.findElement(By.xpath("(//*[@text='Boyalı'])[2]")).click();
        driver.findElementById("com.dogan.arabam:id/btn_next").click();

        driver.findElementById("com.dogan.arabam:id/rbHasNoTramerEntry").click();
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        String avaragePrice= driver.findElementById("com.dogan.arabam:id/tvAveragePrice").getText();
        String lastPrice=avaragePrice.replaceAll("\\D","");
        Assert.assertTrue(Integer.parseInt(lastPrice)>500000);
        // uygulamayi kapatalim
        driver.closeApp();

}




}
