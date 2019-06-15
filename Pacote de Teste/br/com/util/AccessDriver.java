/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        String driverDir = System.getProperty("user.dir") + "/driver/chromedriver/chromedriverLinux";
        System.setProperty("webdriver.chrome.driver", driverDir);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
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

    public void logout() {
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("var evt = document.createEvent('MouseEvents');"
//                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
//                + "arguments[0].dispatchEvent(evt);", webDriver.findElement(By.xpath("/html/body/aside/nav/ul/li[15]/a")));
        WebElement element = webDriver.findElement(By.xpath("/html/body/aside/nav/ul/li[15]/a"));

        Actions actions = new Actions(webDriver);

        actions.moveToElement(element).click();
//        webDriver.findElement(By.xpath("/html/body/aside/nav/ul/li[15]")).submit();
//        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
//        executor.executeScript("document.body.style.zoom = '0.8'");
//            webDriver.findElement(By.className("jr-menu")).findElements(By.tagName("li")).get(15).click();
    }
}
