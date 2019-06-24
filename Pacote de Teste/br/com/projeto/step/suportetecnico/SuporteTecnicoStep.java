/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.step.suportetecnico;

import br.com.projeto.util.SuporteTecnicoUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author Henrique Baron
 */
public class SuporteTecnicoStep {

    SuporteTecnicoUtils componente = new SuporteTecnicoUtils();

    @Dado("que o usuário encontra-se na tela de listagem de suporte técnico")
    public void que_o_usuário_encontra_se_na_tela_de_listagem_de_suporte_técnico() {
        componente.getAccess();
    }

    @Dado("que o usuário clicou no botão novo")
    public void que_o_usuário_clicou_no_botão_novo() {
        componente.clickNew();
    }

    @Dado("selecionou um {string}")
    public void selecionou_um(String string) {
        componente.selectSetor(string);
    }

    @Dado("preencheu {string}")
    public void preencheu(String string) {
        componente.setUsuario(string);
    }

    @Quando("o usuário clicar no botão salvar")
    public void o_usuário_clicar_no_botão_salvar() {
        componente.clickSave();
    }

    @Então("o suporte sera mostrado ao pesquisar pelo {string}")
    public void o_suporte_sera_mostrado_ao_pesquisar_pelo(String string) {
        componente.validNewSuporte(string);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou o {string} a ser alterado")
    public void que_o_usuário_pesquisou_o_a_ser_alterado(String string) {
        componente.findResponsavel(string);
    }

    @Dado("clicou no botão alterar")
    public void clicou_no_botão_alterar() {
        componente.clickAlterar();
    }

    @Dado("trocou o {string} e {string}")
    public void trocou_o_e(String string, String string2) {
        componente.changeSetorUser(string, string2);
    }

    @Então("o {string} sera mostrado ao pesquisar pelo {string}")
    public void o_sera_mostrado_ao_pesquisar_pelo(String string, String string2) {
        componente.validAlterSuporte(string, string2);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou o {string} a ser excluído")
    public void que_o_usuário_pesquisou_o_a_ser_excluído(String string) {
        componente.findResponsavel(string);
    }

    @Quando("o usuário clicar no botão excluir suporte técnico")
    public void o_usuário_clicar_no_botão_excluir_suporte_técnico() {
        componente.clickDelete();
    }

    @Quando("o usuário confirmar a exclusão")
    public void o_usuário_confirmar_a_exclusão() {
        componente.confirmDelete();
    }

    @Então("não tera resultados ao pesquisar pelo {string}")
    public void não_tera_resultados_ao_pesquisar_pelo(String string) {
        componente.validDelete(string);
    }

    @Quando("o usuário clicar no botão pesquisar")
    public void o_usuário_clicar_no_botão_pesquisar() {
        componente.findResponsavel("");
    }

    @Então("o sistema deverá listar todos os suportes técnicos")
    public void o_sistema_deverá_listar_todos_os_suportes_técnicos() {
        componente.validListagem();
    }
}
