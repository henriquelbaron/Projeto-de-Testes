/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    public void setFields(String info, String inicio, String fim) {
        webDriver.switchTo();
        sleep(450);
        webDriver.findElement(By.id("form_salvar:j_idt116")).sendKeys(info);
        WebElement dataInicio = webDriver.findElement(By.id("form_salvar:inicio_input"));
        dataInicio.sendKeys(inicio);
        dataInicio.sendKeys(Keys.ENTER);
        dataInicio.sendKeys(Keys.TAB);
        sleep(450);
        WebElement dataFim = webDriver.findElement(By.id("form_salvar:fim_input"));
        dataFim.sendKeys(fim);
        dataFim.sendKeys(Keys.ENTER);
        dataFim.sendKeys(Keys.TAB);
        sleep(450);
    }

    public void setSelect(String periodo, String disponivel) {
        List<WebElement> periodos = webDriver.findElements(By.xpath("//*[@id=\"form_salvar:periodo\"]//label"));
        for (WebElement periodo1 : periodos) {
            if (periodo1.getText().equals(periodo)) {
                periodo1.click();
            }
        }
//        webDriver.findElement(By.id("form_salvar:listaDeClassesDisponiveis")).click();
//        WebElement elemento = null;
//        WebElement comboImput = webDriver.findElement(By.id("form_salvar:listaDeClassesDisponiveis_input"));
//        List<WebElement> elementos = webDriver.findElements(By.xpath("//*[@id=\"form_salvar:listaDeClassesDisponiveis_panel\"]//li"));
//        for (WebElement webElement : elementos) {
//            if (webElement.getText().equals(disponivel)) {
//                elemento = webElement;
//            }
//        }
//        Actions actions = new Actions(webDriver);
//        actions.moveToElement(elemento);
//
//        webDriver.switchTo().activeElement();
//        Select combo = new Select(comboImput);
//        sleep(500);
//        combo.selectByVisibleText(disponivel);
    }

    public void salvarClick() {
        webDriver.findElement(By.id("form_salvar:btSalvarReserva")).click();
        webDriver.findElement(By.cssSelector("#form_salvar\\:dialogoSalvar > div.ui-dialog-titlebar.ui-widget-header.ui-helper-clearfix.ui-corner-top.ui-draggable-handle > a > span")).click();
    }

    public void validarOcupacao(String string) {
        WebElement elemento = webDriver.findElement(By.className("ui-selectcheckboxmenu-trigger"));
        elemento.click();
        elemento.findElement(By.tagName("input")).sendKeys("1994");
        elemento.findElement(By.tagName("li")).click();
    }

////*[@id="form_timeline:timelineTodasSalas"]//div[@class="timeline-event-content"]
}
