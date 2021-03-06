package com.example.johan.appium;

import org.jboss.netty.util.Timeout;
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

public class Setup {

    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

            // Created object of DesiredCapabilities class.
            DesiredCapabilities caps = new DesiredCapabilities();

            //caps.setCapability("automationName","UiAutomator2");

            caps.setCapability("no",true);

            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

            caps.setCapability("app-wait-activity", "activity-to-wait-for");

            caps.setCapability("deviceName", "SM-G930F");

            caps.setCapability(CapabilityType.VERSION, "8.0.0");

            caps.setCapability("platformName", "Android");

            caps.setCapability("appPackage", "com.grability.rappi.dev");

            caps.setCapability("appActivity", "com.grability.app.splash.SplashActivity");


            // Driver connection
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url,caps);
        //driver = new IOSDriver<MobileElement>(url,caps)
    }

    @Test(timeOut = 100000)
    public void Login() {

        driver.findElement(By.id("com.grability.rappi.dev:id/textView_method")).click();
        //driver.findElement(By.linkText("Con tu número celular")).click();
        driver.findElement(By.id("com.grability.rappi.dev:id/editText_phone")).click();


        // Enter data in EditText
        final WebElement inputField = driver.findElement(By.id("com.grability.rappi.dev:id/editText_phone"));
                inputField.sendKeys("3133647701");
                //close keyboard
                driver.hideKeyboard();


        driver.findElement(By.id("com.grability.rappi.dev:id/textView")).click();

        driver.findElement(By.className("android.widget.EditText")).click();

        final WebElement inputField2 = driver.findElement(By.className("android.widget.EditText"));
        inputField2.sendKeys("123456");

        driver.findElement(By.id("com.grability.rappi.dev:id/textView")).click();

        //implement mock web service to get the authorization token to continue interacting

        WebDriverWait wait = new WebDriverWait(driver, 5000000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[contains(@resource-id, 'com.grability.rappi.dev:id/textView')]")));

        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

    }

    @Test
    public void End() {
        driver.quit();
    }
}
