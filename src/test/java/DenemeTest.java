import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DenemeTest {

    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri
    // AppiumDriver<MobileElement> appiumDriver; // hem android hem ios calisir

    final String cihazAdi="PIXEL";
    final String platformIsmi="Android";
    final String version="10.0";
    final String automation="UiAutomator2";

    @Test
    public void deneme1() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Admin\\Downloads\\QA\\APPIUM_T108\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void test01(){
        driver.activateApp("com.google.android.calculator");
    driver.findElementByAccessibilityId("8").click();
    driver.findElementByAccessibilityId("0").click();
    driver.findElementByAccessibilityId("multiply").click();
    driver.findElementByAccessibilityId("2").click();
    driver.findElementByAccessibilityId("0").click();
    String result=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println("result = " + result);

        Assert.assertEquals(Integer.parseInt(result),1600);
    }

    @Test
    public void toplama(){

        driver.activateApp("com.google.android.calculator");

    }

}
