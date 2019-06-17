/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.step.sala;

import br.com.util.SalaUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author henrique
 */
public class SalaStep {

    private final SalaUtils componente = new SalaUtils();

    @Dado("que o usuário se encontra na tela listagem de salas")
    public void que_o_usuário_se_encontra_na_tela_listagem_de_salas() {
        componente.getAccess();
    }

    @Dado("que o usuário clicou no botão novo")
    public void que_o_usuário_clicou_no_botão_novo() {
        componente.newClick();
    }

    @Dado("o usuário preencheu {string} e {string}")
    public void o_usuário_preencheu_e(String nome, String descricao) {
        componente.setTextFields(nome, descricao);
    }

    @Quando("o usuário clicar no botão salvar")
    public void o_usuário_clicar_no_botão_salvar() {
        componente.saveClick();
    }

    @Então("a sala aparecera na listagem com os campos {string} e {string}")
    public void a_sala_aparecera_na_listagem_com_os_campos_e(String nome, String descricao) {
        componente.validNewSala(nome, descricao);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou a {string} a ser alterada")
    public void que_o_usuário_pesquisou_a_a_ser_alterada(String nome) {
        componente.findSala(nome);
    }

    @Dado("clicou no botão alterar")
    public void clicou_no_botão_alterar() {
        componente.changeClick();
    }

    @Dado("alterou o {string}")
    public void alterou_o(String nome) {
        componente.modifyTextFields(nome);
    }

    @Então("a sala aparecera na listagem com o {string}")
    public void a_sala_aparecera_na_listagem_com_o(String nome) {
        componente.validModifySala(nome);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou a {string} a ser excluída")
    public void que_o_usuário_pesquisou_a_a_ser_excluída(String nome) {
        componente.findSala(nome);
    }

    @Dado("clicou no botão excluir")
    public void clicou_no_botão_excluir() {
        componente.deleteClick();
    }

    @Quando("o usuário confirmar a ação")
    public void o_usuário_confirmar_a_ação() {
        componente.comfirmDelete();
    }

    @Então("a {string} não aparecera na listagem")
    public void a_não_aparecera_na_listagem(String nome) {
        componente.validDelete(nome);
        componente.quitWebDriver();
    }

    @Dado("que o usuário digitou o nome da  {string}")
    public void que_o_usuário_digitou_o_nome_da(String nome) {
        componente.findSala(nome);
    }
    @Quando("o usuário clicar no botão pesquisar")
    public void o_usuário_clicar_no_botão_pesquisar() {
        componente.findClick();
    }

    @Então("as {string} que contém o nome digitado serão mostrados")
    public void as_que_contém_o_nome_digitado_serão_mostrados(String nome) {
        componente.validSala(nome);
        componente.quitWebDriver();
    }
}
