/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.step.ocupacaosala;

import br.com.projeto.util.OcupacaoSalaUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author henrique
 */
public class OcupacaoSalaStep {

    private final OcupacaoSalaUtils componente = new OcupacaoSalaUtils();

    @Dado("que o usuário esta no menu Ocupação de Salas")
    public void que_o_usuário_esta_no_menu_Ocupação_de_Salas() {
        componente.getAccess();
    }

    @Dado("que o usuário clicou no botão Novo")
    public void que_o_usuário_clicou_no_botão_Novo() {
        componente.novoClick();
    }

    @Quando("preencher {string}, {string} e {string}")
    public void preencher_e(String string, String string2, String string3) {
        componente.setFields(string, string2, string3);
    }

    @Quando("selecionar {string} e {string}")
    public void selecionar_e(String string, String string2) {
        componente.setSelect(string, string2);
    }

    @Quando("clicar no botão Salvar")
    public void clicar_no_botão_Salvar() {
        componente.salvarClick();
    }

    @Então("ao pesquisar {string}, se mostrara ocupada")
    public void ao_pesquisar_se_mostrara_ocupada(String string) {
        componente.validarOcupacao(string);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou a {string} que deseja alterar")
    public void que_o_usuário_pesquisou_a_que_deseja_alterar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("clicou em no agendamento")
    public void clicou_em_no_agendamento() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("depois clicou em alterar")
    public void depois_clicou_em_alterar() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("alterou a {string}")
    public void alterou_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("confirmou a alteração")
    public void confirmou_a_alteração() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Quando("o usuário pesquisar a {string} alterada")
    public void o_usuário_pesquisar_a_alterada(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Então("a nova  {string} estara no popup")
    public void a_nova_estara_no_popup(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("que o usuário pesquisou a {string} que deseja excluir a ocupação")
    public void que_o_usuário_pesquisou_a_que_deseja_excluir_a_ocupação(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Quando("ele clicar no botão Deletar")
    public void ele_clicar_no_botão_Deletar() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Quando("confirmar a ação")
    public void confirmar_a_ação() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Então("ao listar, a ocupação da {string} não será mostrada")
    public void ao_listar_a_ocupação_da_não_será_mostrada(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
