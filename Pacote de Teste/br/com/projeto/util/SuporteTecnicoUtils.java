/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import org.openqa.selenium.By;
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
        webDriver.get("http://184.107.94.164:21595/Senac/administrador/suporteTecnico.faces");
    }

    private void findResponsavel() {

    }

    public void clickNew() {
        elemento = webDriver.findElement(By.id("form_pesquisa:j_idt84"));
        elemento.click();
    }

    public void selectSetor(String setor) {
        elemento = webDriver.findElement(By.id("form_pesquisa:setor_input"));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(setor);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
