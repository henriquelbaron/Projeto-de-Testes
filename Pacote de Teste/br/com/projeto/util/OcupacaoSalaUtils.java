/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author henrique
 */
public class OcupacaoSalaUtils extends AccessDriver {

    public void getAccess() {
        initDriver();
        login();
        webDriver.get("http://184.107.94.164:21595/Senac/administrador/ocupacao.faces");
    }

    public void novoClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt87")).click();
    }

    public void setFields(String info) {
        try {
            webDriver.switchTo();
            Thread.sleep(450);
            webDriver.findElement(By.id("form_salvar:j_idt116")).sendKeys(info);
            WebElement dataInicio = webDriver.findElement(By.id("form_salvar:inicio_input"));
            dataInicio.click();
            Thread.sleep(450);
            dataInicio.findElement(By.tagName("tbody")).findElements(By.tagName("td")).get(26).click();
            WebElement dataFim = webDriver.findElement(By.id("form_salvar:fim_input"));
            dataFim.click();
            Thread.sleep(450);
            dataFim.findElement(By.tagName("tbody")).findElements(By.tagName("td")).get(27).click();
        } catch (Exception e) {
        }
    }

    public void setSelect(String string, String string2) {
        webDriver.findElement(By.id("form_salvar:periodo")).findElements(By.tagName("td")).get(2).click();

    }

    public void salvarClick() {
        webDriver.findElement(By.id("form_salvar:btSalvarReserva")).click();
    }

    public void validarOcupacao(String string) {
        WebElement elemento = webDriver.findElement(By.className("ui-selectcheckboxmenu-trigger"));
        elemento.click();
        elemento.findElement(By.tagName("input")).sendKeys("1994");
        elemento.findElement(By.tagName("li")).click();
    }

    public void findOcupacao(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agendamentoClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterarClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void changeInfo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void confirmChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void validarInfo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void confirmDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void validarOcupacaoFalse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
