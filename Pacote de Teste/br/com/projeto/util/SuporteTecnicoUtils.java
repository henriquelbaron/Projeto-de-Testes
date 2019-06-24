/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Henrique Baron
 */
public class SuporteTecnicoUtils extends AccessDriver {

    private WebElement elemento;

    public void getAccess() {
        initDriver();
        login();
        getMenu();
    }

    private void getMenu() {
        webDriver.get("http://184.107.94.164:21595/Senac/administrador/suporteTecnico.faces");
    }

    private List<WebElement> checkUsuario(String email) {
        sleep(1000);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosTabela_data")).findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(2).getText().equals(email)) {
                return rowMatches = columns;
            }
        }
        return rowMatches;
    }

    private void findResponsavel(String responsavel) {
        getMenu();
        elemento = webDriver.findElement(By.id("form_pesquisa:usuario"));
        elemento.sendKeys(responsavel);
        elemento.sendKeys(Keys.ENTER);
    }

    public void clickNew() {
        elemento = webDriver.findElement(By.id("form_pesquisa:j_idt84"));
        elemento.click();
    }

    public void selectSetor(String setor) {
        webDriver.findElement(By.id("form_pesquisa:setor_input")).submit();
        sleep(400);
        elemento = webDriver.findElement(By.id("form_pesquisa:setor_input"));
        Select combo = new Select(elemento);
        combo.getOptions();
        combo.selectByVisibleText(setor);
        sleep(400);
    }

    public void setUsuario(String string) {
        elemento = webDriver.findElement(By.id("form_pesquisa:user_input"));
        elemento.sendKeys(string);
    }

    public void clickSave() {
        elemento = webDriver.findElement(By.id("form_pesquisa:j_idt102"));
        elemento.click();
    }

    public void validNewSuporte(String responsavel) {
        findResponsavel(responsavel);
        List<WebElement> columns = checkUsuario(responsavel);
        Assert.assertEquals(responsavel, columns.get(3).getText());
    }

}
