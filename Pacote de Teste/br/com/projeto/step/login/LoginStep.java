/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.step.login;

import br.com.projeto.util.LoginUtils;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 *
 * @author henrique
 */
public class LoginStep {

    private LoginUtils login = new LoginUtils();

    @Dado("que o usuário acessou o a pagina de login")
    public void que_o_usuário_acessou_o_a_pagina_de_login() {
        login.initDriver();
    }

    @Dado("que o usuário digitou um login valido")
    public void que_o_usuário_digitou_um_login_valido() {
        login.setLogin("admin");
    }

    @Dado("o usuário digitou uma senha")
    public void o_usuário_digitou_uma_senha() {
        login.setSenha("12345");
    }

    @Quando("o usuário clicar no botão Entrar")
    public void o_usuário_clicar_no_botão_Entrar() {
        login.clickEntrar();
    }

    @Então("ele sera redirecionado para a pagina inicial")
    public void ele_sera_redirecionado_para_a_pagina_inicial() {
        login.accessSucess();
        login.quitWebDriver();
    }

    @Dado("que o usuário digitou um login invalido")
    public void que_o_usuário_digitou_um_login_invalido() {
        login.setLogin("errado");
    }

    @Dado("o usuário digitou uma senha válida")
    public void o_usuário_digitou_uma_senha_válida() {
        login.setSenha("12345");
    }

    @Dado("o usuário digitou uma senha invalida")
    public void o_usuário_digitou_uma_senha_invalida() {
        login.setSenha("senha");
    }

    @Então("será apresentado ao usuário uma mensagem Dados Incorretos")
    public void será_apresentado_ao_usuário_uma_mensagem_Dados_incorretos() {
        login.accessFailed();
        login.quitWebDriver();
    }

    @Dado("que o usuário esta logado no sistema")
    public void que_o_usuário_esta_logado_no_sistema() {
        login.login();
    }

    @Quando("ele clica no botão Sair")
    public void ele_clica_no_botão_Sair() {
        login.logout();
    }

    @Então("ele sera redirecionado para a pagina de login")
    public void ele_sera_redirecionado_para_a_pagina_de_login() {
       login.logoutSuccess();
       login.quitWebDriver();
    }
}
