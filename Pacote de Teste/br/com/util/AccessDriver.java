/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.List;
import java.util.prefs.Preferences;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author henrique
 */
public class AccessDriver {

    WebDriver webDriver;
    Select combo;
    List<WebElement> options;

    public void initDriver() {
        ChromeOptions optionChrome = new ChromeOptions();
        optionChrome.addArguments("start-maximized", "disable-infobars");
        String driverDir = System.getProperty("user.dir") + "/driver/chromedriver/chromedriverLinux";
        System.setProperty("webdriver.chrome.driver", driverDir);
        webDriver = new ChromeDriver(optionChrome);
        webDriver.get("http://184.107.94.164:21595/Senac/login.faces");
    }

    public void quitWebDriver() {
        webDriver.quit();
    }

    public void login() {
        webDriver.findElement(By.name("j_username")).sendKeys("admin");
        webDriver.findElement(By.name("j_password")).sendKeys("12345");
        webDriver.findElement(By.tagName("button")).click();
    }

    

    public void wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
        }
    }
}
