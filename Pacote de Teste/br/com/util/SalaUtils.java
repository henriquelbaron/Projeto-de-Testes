/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.ArrayList;
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

    private List<WebElement> findSalaTemplate(String nome, String descricao) {
        sleep(1000);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosSala_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (descricao == null) {
                if (columns.get(0).getText().equals(nome)) {
                    return rowMatches = columns;
                }
            } else if (columns.get(0).getText().equals(nome) && columns.get(1).getText().equals(descricao)) {
                return rowMatches = columns;
            }
        }
        sleep(1000);
        return rowMatches;
    }

    private void clickMenuSala() {
        webDriver.findElement(By.cssSelector(".jr-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
    }

    public void getAccess() {
        initDriver();
        login();
        clickMenuSala();
    }

    public void validNewSala(String nome, String descricao) {
        webDriver.findElement(By.id("form_pesquisa:sala_pesquisa")).sendKeys(nome, Keys.ENTER);
        sleep(1000);
        List<WebElement> columns = findSalaTemplate(nome, descricao);
        Assert.assertEquals(nome, columns.get(0).getText());
        Assert.assertEquals(descricao, columns.get(1).getText());
    }

    public void newClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt84")).click();
    }

    public void setTextFields(String nome, String descricao) {
        sleep(1000);
        webDriver.findElement(By.id("form_pesquisa:sala")).sendKeys(nome);
        webDriver.findElement(By.id("form_pesquisa:descricao")).sendKeys(descricao);
    }

    public void saveClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt100")).click();
        sleep(500);
        clickMenuSala();
    }

    public void changeClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosSala:0:j_idt92")).click();
    }

    public void findSala(String nome) {
        webDriver.findElement(By.id("form_pesquisa:sala_pesquisa")).sendKeys(nome, Keys.ENTER);
        sleep(1000);
        findSalaTemplate(nome, null);
    }

    public void modifyTextFields(String nome) {
        sleep(450);
        WebElement textFieldNome = webDriver.findElement(By.id("form_pesquisa:sala"));
        textFieldNome.clear();
        textFieldNome.sendKeys(nome);
    }

    public void validModifySala(String nome) {
        webDriver.findElement(By.id("form_pesquisa:sala_pesquisa")).sendKeys(nome, Keys.ENTER);
        sleep(1000);
        List<WebElement> columns = findSalaTemplate(nome, null);
        Assert.assertEquals(nome, columns.get(0).getText());
    }

    public void deleteClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosSala:0:j_idt93")).click();
    }

    public void comfirmDelete() {
        sleep(1000);
        webDriver.switchTo();
        webDriver.findElement(By.id("form_pesquisa:j_idt95")).click();
    }

    public void validDelete(String nome) {
        webDriver.findElement(By.id("form_pesquisa:sala_pesquisa")).sendKeys(nome, Keys.ENTER);
        sleep(1000);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosSala_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(0).getText().equals(nome)) {
                rowMatches = columns;
            }
        }
        Assert.assertTrue(rowMatches == null);
    }

    public void findClick() {
        sleep(500);
    }

    public void validSala(String nome) {
        List<WebElement> columns = findSalaTemplate(nome, null);
        Assert.assertEquals(nome, columns.get(0).getText());
    }

}
