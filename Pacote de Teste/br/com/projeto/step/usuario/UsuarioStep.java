/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.step.usuario;

import br.com.projeto.util.UsuarioUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author henrique
 */
public class UsuarioStep {

    private final UsuarioUtils componente = new UsuarioUtils();

    @Dado("que o usuário se encontra na tela listagem de usuários")
    public void que_o_usuário_se_encontra_na_tela_listagem_de_usuários() {
        componente.getAccess();
    }

    @Dado("que o usuário clicou no botão novo")
    public void que_o_usuário_clicou_no_botão_novo() {
        componente.novoClick();
    }

    @Dado("o usuário preencheu {string} e {string} corretamente")
    public void o_usuário_preencheu_e_corretamente(String string, String string2) {
        componente.setTextFields(string, string2);
    }

    @Dado("selecionou um perfil")
    public void selecionou_um_perfil() {
        componente.selectPerfil();
    }

    @Quando("o usuário clicar no botão salvar")
    public void o_usuário_clicar_no_botão_salvar() {
        componente.salvarClick();
    }

    @Então("{string} e {string} sera mostrado ao pesquisar pelo usuário cadastrado")
    public void e_sera_mostrado_ao_pesquisar_pelo_usuário_cadastrado(String string, String string2) {
        componente.validNewUser(string, string2);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou pelo {string}")
    public void que_o_usuário_pesquisou_pelo(String string) {
        componente.findUser(string);
    }

    @Dado("clicou no botão alterar")
    public void clicou_no_botão_alterar() {
        componente.alterarClick();
    }

    @Dado("alterou o {string}")
    public void alterou_o(String string) {
        componente.setAlterTextFields(string);
    }

    @Então("o novo {string} sera mostrado ao pesquisar pelo {string} alterado")
    public void o_novo_sera_mostrado_ao_pesquisar_pelo_alterado(String string, String string2) {
        componente.validChangeUser(string, string2);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou pelo {string} a ser Excluido")
    public void que_o_usuário_pesquisou_pelo_a_ser_Excluido(String string) {
        componente.findUser(string);
    }

    @Dado("clicou no botão excluir")
    public void clicou_no_botão_excluir() {
        componente.clickDelete();
    }

    @Quando("o usuário confirmar a ação")
    public void o_usuário_confirmar_a_ação() {
        componente.confirmDelete();
    }

    @Então("o {string} não estará mais na listagem")
    public void o_não_estará_mais_na_listagem(String string) {
        componente.validExclusion(string);
        componente.quitWebDriver();
    }

    @Quando("o usuário clicar no botão ativar\\/desativar")
    public void o_usuário_clicar_no_botão_ativar_desativar() {
        componente.clickSituacao();
    }

    @Quando("confirmar a ação")
    public void confirmar_a_ação() {
        componente.confirmChange();
    }

    @Então("a situação do {string} sera mudada")
    public void a_situação_do_sera_mudada(String string) {
        componente.validSituation(string);
        componente.quitWebDriver();
    }
}
