/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author henrique
 */
public class ProfessorUtils extends AccessDriver {

    private List<WebElement> rowOfColumns;

    private void menuClick() {
        webDriver.findElement(By.cssSelector(".jr-menu > ul:nth-child(1) > li:nth-child(12) > a:nth-child(1)")).click();
        sleep(1000);
    }

    private List<WebElement> findProfessorTemplate(String nome, String celular, String email) {
        sleep(1000);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosProf_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (celular != null) {
                if (columns.get(0).getText().equals(nome) && columns.get(1).getText().equals(email)
                        && columns.get(2).getText().replaceAll("[^0-9]", "").equals(celular)) {
                    rowOfColumns = columns;
                    return rowMatches = columns;
                }
            } else if (columns.get(0).getText().equals(nome)) {
                rowOfColumns = columns;
                return rowMatches = columns;
            }
        }
        return rowMatches;
    }

    public void getAccess() {
        initDriver();
        login();
        menuClick();
    }

    public void newClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt81")).click();
        sleep(1000);
    }

    public void setTextFields(String nome, String celular, String email) {
        webDriver.findElement(By.id("form_pesquisa:nome")).sendKeys(nome);
        WebElement tfFone = webDriver.findElement(By.id("form_pesquisa:foneMovel"));
        tfFone.click();
        tfFone.sendKeys(celular);
        webDriver.findElement(By.id("form_pesquisa:email")).sendKeys(email);
    }

    public void saveClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt83")).click();
        sleep(500);
        menuClick();
    }

    public void findProfessor(String nome) {
        WebElement textFieldPesquisa = webDriver.findElement(By.id("form_pesquisa:pesqNome"));
        textFieldPesquisa.sendKeys(nome);
        textFieldPesquisa.sendKeys(Keys.ENTER);
        sleep(1000);
    }

    public void validNewProfessor(String nome, String celular, String email) {
        List<WebElement> columns = findProfessorTemplate(nome, celular, email);
        Assert.assertEquals(nome, columns.get(0).getText());
        Assert.assertEquals(email, columns.get(1).getText());
        Assert.assertEquals(celular, columns.get(2).getText().replaceAll("[^0-9]", ""));
    }

    public void changeClick() {
        WebElement alterarButton = webDriver.findElement(By.id("form_pesquisa:dadosProf:0:j_idt100"));
        alterarButton.click();
        sleep(450);
        if (webDriver.findElements(By.id("form_pesquisa:btAddDisc")).isEmpty()) {
            alterarButton.click();
        }
        sleep(1000);
    }

    public void modifyTextFields(String string, String string2) {
        WebElement textFieldNome = webDriver.findElement(By.id("form_pesquisa:nome"));
        textFieldNome.clear();
        textFieldNome.sendKeys(string);
        WebElement textFieldEmail = webDriver.findElement(By.id("form_pesquisa:email"));
        textFieldEmail.clear();
        textFieldEmail.sendKeys(string2);
    }

    public void validModifyProfessor(String nome, String email) {
        findProfessor(nome);
        List<WebElement> columns = findProfessorTemplate(nome, null, email);
        Assert.assertEquals(nome, columns.get(0).getText());
        Assert.assertEquals(email, columns.get(1).getText());
    }

    public void deleteClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosProf:0:j_idt101")).click();
        sleep(500);
    }

    public void confirmAction() {
        webDriver.switchTo();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.document.getElementById('form_pesquisa:j_idt103').click()");
        sleep(1000);
    }

    public void validDeleteProfessor(String string) {
        findProfessor(string);
        List<WebElement> columns = findProfessorTemplate(string, null, null);
        Assert.assertEquals(null, columns);
    }

    public void addDisciplina() {
        webDriver.findElement(By.id("form_pesquisa:btAddDisc")).click();
    }

    public void setDisciplinaTf(String disciplina) {
        sleep(500);
        WebElement elemento = webDriver.findElement(By.id("form_pesquisa:j_idt112:0:j_idt115"));
        sleep(500);
        elemento.sendKeys(disciplina);
    }

    public void validNewDisciplina(String disciplina, String professor) {
        menuClick();
        findProfessor(professor);
        String tableDisciplina = searchDisciplina(disciplina, professor);
        Assert.assertTrue(tableDisciplina.contains(disciplina));
    }

    public void removeDisciplina(String disciplina) {
        sleep(500);
        webDriver.findElement(By.id("form_pesquisa:j_idt112:0:btRemDisc")).click();
        sleep(500);
    }

    public void validDeleteDisciplina(String disciplina, String professor) {
        menuClick();
        findProfessor(professor);
        String tableDisciplina = searchDisciplina(disciplina, professor);
        Assert.assertTrue(tableDisciplina == null);
    }

    private String searchDisciplina(String disciplina, String professor) {
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosProf_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(0).getText().equals(professor)
                    && columns.get(3).getText().contains(disciplina)) {
                return columns.get(3).getText();
            }
        }
        return null;
    }
}
