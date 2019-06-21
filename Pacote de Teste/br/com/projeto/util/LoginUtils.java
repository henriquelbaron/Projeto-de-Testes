/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author henrique
 */
public class LoginUtils extends AccessDriver {

    public void setLogin(String login) {
        webDriver.findElement(By.name("j_username")).sendKeys(login);
    }

    public void setSenha(String senha) {
        webDriver.findElement(By.name("j_password")).sendKeys(senha);
    }

    public void clickEntrar() {
        webDriver.findElement(By.tagName("button")).click();
    }

    public void accessSucess() {
        WebElement feedback = webDriver.findElement(By.name("viewport"));
        Assert.assertFalse(feedback.isDisplayed());
    }

    public void accessFailed() {
        WebElement feedback = webDriver.findElement(By.id("j_idt14"));
        Assert.assertTrue(feedback.isDisplayed());
    }

    public void logoutSuccess() {
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals("http://184.107.94.164:21595/Senac/login.faces", url);
    }

    public void logout() {
        webDriver.findElement(By.cssSelector(".jr-menu > ul:nth-child(1) > li:nth-child(17)")).click();
    }
}
