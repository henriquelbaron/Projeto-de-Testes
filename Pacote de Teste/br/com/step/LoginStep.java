/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.step;

import br.com.util.LoginUtils;
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
        login.inicializa();
    }

    @Dado("que o usuário digitou um login valido")
    public void que_o_usuário_digitou_um_login_valido() {
        login.setLogin("angelica");
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
      login.validateAccess();
    }

    @Dado("que o usuário digitou um login invalido")
    public void que_o_usuário_digitou_um_login_invalido() {
       login.setLogin("");
    }

    @Dado("o usuário digitou uma senha válida")
    public void o_usuário_digitou_uma_senha_válida() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Então("será apresentado ao usuário uma mensagem Dados Incorretos")
    public void será_apresentado_ao_usuário_uma_mensagem_Dados_Incorretos() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("o usuário digitou uma senha invalida")
    public void o_usuário_digitou_uma_senha_invalida() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Então("será apresentado ao usuário uma mensagem Dados incorretos")
    public void será_apresentado_ao_usuário_uma_mensagem_Dados_incorretos() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Dado("que o usuário esta logado no sistema")
    public void que_o_usuário_esta_logado_no_sistema() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Quando("ele clica no botão Sair")
    public void ele_clica_no_botão_Sair() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Então("ele sera redirecionado para a pagina de login")
    public void ele_sera_redirecionado_para_a_pagina_de_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
