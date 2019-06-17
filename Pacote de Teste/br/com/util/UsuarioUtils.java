/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author henrique
 */
public class UsuarioUtils extends AccessDriver {

    private String situacao;
    private String usuario = "Juvenal";
    private final String url = "http://184.107.94.164:21595/Senac/administrador/usuario.faces";

    private void findUser(String user) {
        webDriver.get(url);
        webDriver.findElement(By.id("form_pesquisa:nome_pesquisa")).sendKeys(user, Keys.ENTER);
        sleep(1000);
        String nome = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data")).findElement(By.tagName("tr")).findElement(By.tagName("td")).getText();
        Assert.assertEquals(user, nome);
    }

    public void getAccess() {
        initDriver();
        login();
        webDriver.get(url);
    }

    public void novoClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt83")).click();
    }

    public void setTextFields() {
        sleep(1000);
        webDriver.findElement(By.name("form_pesquisa:nome")).sendKeys(usuario);
        webDriver.findElement(By.id("form_pesquisa:login")).sendKeys("oi@gmail.com", Keys.TAB);

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("document.getElementById('form_pesquisa:perfill').click();");
        sleep(3000);
//        webDriver.findElement(By.id("form_pesquisa:perfil_items")).sendKeys(Keys.DOWN,Keys.ENTER);
        jse.executeScript("document.getElementById('form_pesquisa:perfil_1').click();");
//        Select combo = new Select(webDriver.findElement(By.id("form_pesquisa:perfil_input")));
//        combo.selectByValue("1");
        sleep(500);

    }

    public void salvarClick() {
        webDriver.findElement(By.id("form_pesquisa:j_idt86")).click();
    }

    public void validNewUser() {
        findUser(usuario);
    }

    public void alterarClick() {
        webDriver.findElement(By.id("form_pesquisa:dadosUsuario:0:j_idt102")).click();
    }

    public void setAlterTextFields() {
        sleep(1000);
        WebElement nome = webDriver.findElement(By.name("form_pesquisa:nome"));
        nome.clear();
        usuario = "HenriqueAlterado";
        nome.sendKeys(usuario);
        WebElement email = webDriver.findElement(By.id("form_pesquisa:login"));
        email.clear();
        email.sendKeys("alterado@gmail.com");
    }

    public void validChangeUser() {
        findUser(usuario);
    }

    public void findUser() {
        findUser(usuario);
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

    public void validSituation() {
        findUser(usuario);
        String situacaoAtual = webDriver.findElement(By.id("form_pesquisa:dadosUsuario_data"))
                .findElement(By.tagName("tr")).findElements(By.tagName("td")).get(3).getText();
        Assert.assertNotEquals(situacaoAtual, situacao);
    }

    public void validExclusion() {
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
}
