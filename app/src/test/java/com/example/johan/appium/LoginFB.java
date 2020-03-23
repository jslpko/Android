package com.example.johan.appium;

import org.jboss.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Timestamp;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFB {

    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        // Created object of DesiredCapabilities class.
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("appium-version", "1.15.1");

        caps.setCapability("no", true);

        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);

        caps.setCapability("app-wait-activity", "activity-to-wait-for");

        caps.setCapability("deviceName", "SM-G930F");

        caps.setCapability(CapabilityType.VERSION, "8.0.0");

        caps.setCapability("platformName", "Android");

        caps.setCapability("appPackage", "com.grability.rappi.dev");

        caps.setCapability("appActivity", "com.grability.app.splash.SplashActivity");

        // Driver connection
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, caps);
        //driver = new IOSDriver<MobileElement>(url,caps)
    }

    @Test
    public void sessionFB() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView").click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView").click();

        driver.findElementById("com.grability.rappi.dev:id/button_accept").click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement email = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText");
        email.click();
        email.sendKeys("pruebasgrabqa@gmail.com");
        driver.hideKeyboard();

        WebElement pass = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.widget.EditText");
        pass.click();
        pass.sendKeys("test grability");
        driver.hideKeyboard();

        driver.findElementByClassName("android.widget.Button").click();

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button\n").click();
    }

    @Test
    public void End() {
        driver.quit();
    }
}