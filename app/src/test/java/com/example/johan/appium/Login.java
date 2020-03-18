package com.example.johan.appium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login {
    AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

            // Created object of DesiredCapabilities class.
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("automationName","UiAutomator2");

            capabilities.setCapability("no",true);

            capabilities.setCapability("newCommandTimeout", 100000);

            capabilities.setCapability("app-wait-activity", "activity-to-wait-for");

            capabilities.setCapability("deviceName", "Moto G Play Build/NPIS26.48-43-2");

            // Set BROWSER_NAME desired capability. It's Android in our case here.
            //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

            // Set android VERSION desired capability. Set your mobile device's OS version.
            capabilities.setCapability(CapabilityType.VERSION, "7.1.1");

            // Set android platformName desired capability. It's Android in our case here.
            capabilities.setCapability("platformName", "Android");

            // Set android appPackage desired capability. It is
            // com.android.calculator2 for calculator application.
            // Set your application's appPackage if you are using any other app.
            capabilities.setCapability("appPackage", "com.grability.rappi.dev");

            // Set android appActivity desired capability. It is
            // com.android.calculator2.Calculator for calculator application.
            // Set your application's appPackage if you are using any other app.
            capabilities.setCapability("appActivity", "com.grability.app.splash.SplashActivity");

            // Created object of RemoteWebDriver will all set capabilities.
            // Set appium server address and port number in URL string.
            // It will launch app in android device.

            driver = new AndroidDriver(new URL("http://0.0.0.0:58045/wd/hub/"),capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testFirstLogin() {

        // Click on number 2 button.
        driver.findElement(By.id("com.grability.rappi.dev:id/textView_method")).click();
        //driver.findElement(By.linkText("Con tu número celular")).click();
        driver.findElement(By.id("com.grability.rappi.dev:id/editText_phone")).click();


        // Enter data in EditText
        final WebElement inputField = driver.findElement(By.id("com.grability.rappi.dev:id/editText_phone"));
                inputField.sendKeys("3133647701");
                //close keyboard
                driver.hideKeyboard();


        driver.findElement(By.id("com.grability.rappi.dev:id/id/textView")).click();

        driver.findElement(By.id("com.grability.rappi.dev:id/NO_ID")).click();

        final WebElement inputField2 = driver.findElement(By.id("com.grability.rappi.dev:id/NO_ID"));
        inputField2.sendKeys("123456");

        WebDriverWait wait = new WebDriverWait(driver, 5000000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[contains(@resource-id, 'com.grability.rappi.dev:id/textView')]")));

        driver.manage().timeouts().implicitlyWait(1200,TimeUnit.SECONDS);

    }

    @After
    public void End() {
        driver.quit();
    }
}
