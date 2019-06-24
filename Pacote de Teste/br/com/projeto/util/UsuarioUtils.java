/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author henrique
 */
public class UsuarioUtils extends AccessDriver {

    private String situacao;
    private final String url = "http://184.107.94.164:21595/Senac/administrador/usuario.faces";

    private List<WebElement> findUsuarioTemplate(String nome, String email) {
        sleep(1000);
        List<WebElement> rows = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data"))
                .findElements(By.tagName("tr"));
        List<WebElement> rowMatches = null;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            if (nome == null) {
                if (columns.get(1).getText().equals(email)) {
                    rowMatches = columns;
                }
            } else if (email == null) {
                if (columns.get(0).getText().equals(nome)) {
                    rowMatches = columns;
                }
            } else {
                if (columns.get(0).getText().equals(nome) && columns.get(1).getText().equals(email)) {
                    rowMatches = columns;
                }
            }
        }
        return rowMatches;
    }

    public void getAccess() {
        initDriver();
        login();
        webDriver.get(url);
    }

    public void novoClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt83")).click();
    }

    public void setTextFields(String nome, String email) {
        sleep(1000);
        webDriver.findElement(By.name("form_pesquisa:nome")).sendKeys(nome);
        webDriver.findElement(By.id("form_pesquisa:login")).sendKeys(email, Keys.TAB);
        sleep(500);

    }

    public void salvarClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt86")).click();
    }

    public void validNewUser(String nome, String email) {
        webDriver.get(url);
        webDriver.findElement(By.id("form_pesquisa:nome_pesquisa")).sendKeys(nome, Keys.ENTER);
        sleep(1000);
        List<WebElement> columns = findUsuarioTemplate(nome, email);
        Assert.assertEquals(nome, columns.get(0).getText());
        Assert.assertEquals(email, columns.get(1).getText());
    }

    public void alterarClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosUsuario:0:j_idt102")).click();
    }

    public void setAlterTextFields(String email) {
        sleep(1000);
        WebElement tfNome = webDriver.findElement(By.name("form_pesquisa:login"));
        tfNome.clear();
        tfNome.sendKeys(email);
    }

    public void validChangeUser(String email, String usario) {
        findUser(usario);
        List<WebElement> columns = findUsuarioTemplate(usario, email);
        Assert.assertEquals(email, columns.get(1).getText());
    }

    public void findUser(String usuario) {
        webDriver.get(url);
        webDriver.findElement(By.id("form_pesquisa:nome_pesquisa")).sendKeys(usuario, Keys.ENTER);
        sleep(1000);
        situacao = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data"))
                .findElement(By.tagName("tr")).findElements(By.tagName("td")).get(3).getText();
    }

    public void situacaoClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosUsuario:0:j_idt104")).click();
    }

    public void confirmChange() {
        webDriver.switchTo();
        webDriver.findElement(By.id("form_pesquisa:j_idt106")).click();
    }

    public void validSituation(String usuario) {
        webDriver.get(url);
        webDriver.findElement(By.id("form_pesquisa:nome_pesquisa")).sendKeys(usuario, Keys.ENTER);
        sleep(1000);
        String situacaoAtual = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data"))
                .findElement(By.tagName("tr")).findElements(By.tagName("td")).get(3).getText();
        Assert.assertNotEquals(situacaoAtual, situacao);
    }

    public void validExclusion(String usuario) {
        webDriver.get(url);
        webDriver.findElement(By.id("form_pesquisa:nome_pesquisa")).sendKeys(usuario, Keys.ENTER);
        sleep(1000);
        String nome = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data")).findElement(By.tagName("tr")).findElement(By.tagName("td")).getText();
        Assert.assertNotEquals(usuario, nome);
    }

    public void confirmDelete() {
        webDriver.findElement(By.id("form_pesquisa:j_idt106")).click();
    }

    public void clickDelete() {
        webDriver.findElement(By.id("form_pesquisa:dadosUsuario:0:j_idt103")).click();
    }

    public void clickSituacao() {
        webDriver.findElement(By.id("form_pesquisa:dadosUsuario:0:j_idt104")).click();
    }

    public void selectPerfil() {
        sleep(400);
        webDriver.findElement(By.id("form_pesquisa:perfil_input")).submit();
        WebElement elemento = webDriver.findElement(By.id("form_pesquisa:perfil_input"));
        Select combo = new Select(elemento);
        combo.getOptions();
        combo.selectByVisibleText("Admin");
        sleep(400);
    }

}
