package com.webshop.tests;

import com.webshop.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void StartDriver(@Optional("edge") String browser) {
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://automationteststore.com");
    }

//    @AfterClass
//    public void stopDriver() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @AfterMethod()
    public void takeScreenShotWhenFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            System.out.println("Capturing screenshot for failed test: " + testName);

            Helper.attachScreenshotToAllure(driver, testName);

            Helper.saveScreenshotLocally(driver, testName);
        }

        if (driver != null) {
            driver.quit();
        }
    }

}