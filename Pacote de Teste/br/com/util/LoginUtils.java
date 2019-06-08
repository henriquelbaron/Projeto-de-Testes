/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import org.junit.Assert;
import org.openqa.selenium.By;

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
    public void clickEntrar(){
        webDriver.findElement(By.tagName("button")).click();
    }

    public void validateAccess() {
    String page = webDriver.getCurrentUrl();
    Assert.assertEquals("sl108prf:8084/Senac/", page);
    }
}
