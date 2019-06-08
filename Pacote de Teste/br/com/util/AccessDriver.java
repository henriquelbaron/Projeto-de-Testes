/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author henrique
 */
public class AccessDriver {

    WebDriver webDriver;
    Select combo;
    List<WebElement> options;

    public void inicializa() {
        String driverDir = System.getProperty("user.dir") + "/driver/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverDir);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
    }
}
