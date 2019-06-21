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

//    @Dado("que o usuário se encontra na tela listagem de usuários")
//    public void que_o_usuário_se_encontra_na_tela_listagem_de_usuários() {
//        componente.getAccess();
//    }
//
//    @Dado("que o usuário clicou no botão novo")
//    public void que_o_usuário_clicou_no_botão_novo() {
//        componente.novoClick();
//    }
//
//    @Dado("o usuário preencheu os campos corretamente")
//    public void o_usuário_preencheu_os_campos_corretamente() {
//        componente.setTextFields();
//    }
//
//    @Quando("o usuário clicar no botão salvar")
//    public void o_usuário_clicar_no_botão_salvar() {
//        componente.salvarClick();
//    }
//
//    @Então("o novo  cadastro estará na listagem")
//    public void o_novo_cadastro_estará_na_listagem() {
//        componente.validNewUser();
//        componente.quitWebDriver();
//    }
//
//    @Dado("que o  usuário pesquisou o cadastro a ser alterado")
//    public void que_o_usuário_pesquisou_o_cadastro_a_ser_alterado() {
//        componente.findUser();
//    }
//
//    @Dado("clicou no botão alterar")
//    public void clicou_no_botão_alterar() {
//        componente.alterarClick();
//    }
//
//    @Dado("alterou algum dos campos")
//    public void alterou_algum_dos_campos() {
//        componente.setAlterTextFields();
//    }
//
//    @Então("as alterações do cadastro será mostrado na listagem")
//    public void as_alterações_do_cadastro_será_mostrado_na_listagem() {
//        componente.validChangeUser();
//        componente.quitWebDriver();
//    }
//
//    @Quando("o usuário clicar no botão ativar\\/desativar")
//    public void o_usuário_clicar_no_botão_ativar_desativar() {
//        componente.situacaoClick();
//    }
//
//    @Quando("confirmar a ação")
//    public void confirmar_a_ação() {
//        componente.confirmChange();
//    }
//
//    @Então("a situação do cadastro sera mudada")
//    public void a_situação_do_cadastro_sera_mudada() {
//        componente.validSituation();
//        componente.quitWebDriver();
//    }
//
//    @Dado("que o usuário pesquisou o cadastro a ser Excluído")
//    public void que_o_usuário_pesquisou_o_cadastro_a_ser_Excluído() {
//        componente.findUser();
//    }
//
//    @Dado("clicou no botão excluir")
//    public void clicou_no_botão_excluir() {
//        componente.clickDelete();
//    }
//
//    @Quando("o usuário confirmar a ação")
//    public void o_usuário_confirmar_a_ação() {
//        componente.confirmDelete();
//    }
//
//    @Então("o cadastro excluído não aparecera na listagem")
//    public void o_cadastro_excluído_não_aparecera_na_listagem() {
//        componente.validExclusion();
//        componente.quitWebDriver();
//    }
}
