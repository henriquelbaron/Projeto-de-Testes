/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import cucumber.runtime.Utils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author henrique
 */
public class ProfessorUtils extends AccessDriver {

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
                    return rowMatches = columns;
                }
            } else if (columns.get(0).getText().equals(nome)) {
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
        webDriver.findElement(By.id("form_pesquisa:dadosProf:0:j_idt100")).click();
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

    public void validModifyProfessor(String string) {
        findProfessor(string);
        List<WebElement> columns = findProfessorTemplate(string, null, null);
        Assert.assertEquals(string, columns.get(0).getText());
    }

    public void deleteClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosProf:0:j_idt101")).click();
        sleep(500);
    }

    public void confirmAction() {
        webDriver.switchTo();
        webDriver.findElement(By.id("form_pesquisa:j_idt103")).click();
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
        List<WebElement> tfDisciplinas = webDriver.findElements(By.xpath("//*[@id=\"form_pesquisa:painelDisciplinas_content\"]//input"));
        for (WebElement tfDisciplina : tfDisciplinas) {
            if (tfDisciplina.getAttribute("value").equals("")) {
                tfDisciplina.sendKeys(disciplina);
            }
        }
    }

    public void validNewDisciplina(String disciplina, String professor) {
        menuClick();
        findProfessor(professor);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosProf_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(0).getText().equals(professor)
                    && columns.get(3).getText().contains(disciplina)) {
                rowMatches = columns;
            }
        }
        Assert.assertTrue(rowMatches.get(3).getText().contains(disciplina));
    }
}
