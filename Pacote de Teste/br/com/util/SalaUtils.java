/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author henrique
 */
public class SalaUtils extends AccessDriver {

    private final String nomeSala = "Natação";
    private final String descricao = "blabla";

    public void getAccess() {
        initDriver();
        login();
        webDriver.findElement(By.cssSelector(".jr-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
    }

    public void validNewSala() {
        webDriver.findElement(By.id("form_pesquisa:sala_pesquisa")).sendKeys(nomeSala, Keys.ENTER);
        wait(500);
        List<WebElement> row = webDriver.findElement(By.id("form_pesquisa:dadosSala_data"))
                .findElement(By.tagName("tr")).findElements(By.tagName("td"));
        Assert.assertEquals(nomeSala, row.get(0).getText());
        Assert.assertEquals(descricao, row.get(1).getText());
    }

    public void newClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt84")).click();
    }

    public void setTextFields() {
        wait(450);
        webDriver.findElement(By.id("form_pesquisa:sala")).sendKeys(nomeSala);
        webDriver.findElement(By.id("form_pesquisa:descricao")).sendKeys("blabla");
    }

    public void saveClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt100")).click();
    }

}
