/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.step.professor;

import br.com.util.ProfessorUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author henrique
 */
public class ProfessorStep {

    private ProfessorUtils componente = new ProfessorUtils();

    @Dado("que o usuário se encontra em listagem de professores")
    public void que_o_usuário_se_encontra_em_listagem_de_professores() {
        componente.getAccess();
    }

    @Dado("que o usuário clicou no botão Novo")
    public void que_o_usuário_clicou_no_botão_Novo() {
        componente.newClick();
    }

    @Dado("preencheu os campos {string},{string} e {string}")
    public void preencheu_os_campos_e(String nome, String celular, String email) {
        componente.setTextFields(nome, celular, email);
    }

    @Quando("o usuário clicar no botão Salvar")
    public void o_usuário_clicar_no_botão_Salvar() {
        componente.saveClick();
    }

    @Quando("pesquisar pelo {string}")
    public void pesquisar_pelo(String nome) {
        componente.findProfessor(nome);
    }

    @Então("o {string},{string} e {string} estará na listagem de professores")
    public void o_e_estará_na_listagem_de_professores(String string, String string2, String string3) {
        componente.validNewProfessor(string, string2, string3);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou pelo {string} a ser alterado")
    public void que_o_usuário_pesquisou_pelo_a_ser_alterado(String string) {
        componente.findProfessor(string);
    }

    @Dado("clicou no botão Alterar")
    public void clicou_no_botão_Alterar() {
        componente.changeClick();
    }

    @Dado("alterou os campos {string} e {string}")
    public void alterou_os_campos_e(String string, String string2) {
        componente.modifyTextFields(string, string2);
    }

    @Então("as novas informações do {string} serão mostradas na listagem")
    public void as_novas_informações_do_serão_mostradas_na_listagem(String string) {
        componente.validModifyProfessor(string);
        componente.quitWebDriver();
    }

    @Dado("que o usuário pesquisou pelo {string} a ser excluído")
    public void que_o_usuário_pesquisou_pelo_a_ser_excluído(String string) {
        componente.findProfessor(string);
    }

    @Dado("clicou no botão Excluir")
    public void clicou_no_botão_Excluir() {
        componente.deleteClick();
    }

    @Quando("o usuário confirmar a exclusão")
    public void o_usuário_confirmar_a_exclusão() {
        componente.confirmAction();
    }

    @Então("o {string} não estará mais na listagem")
    public void o_não_estará_mais_na_listagem(String string) {
        componente.validDeleteProfessor(string);
    }
}
