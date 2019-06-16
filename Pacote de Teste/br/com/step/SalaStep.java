/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.step;

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

    @Dado("o usuário preencheu nome e descrição")
    public void o_usuário_preencheu_nome_e_descrição() {
        componente.setTextFields();
    }

    @Quando("o usuário clicar no botão salvar")
    public void o_usuário_clicar_no_botão_salvar() {
        componente.saveClick();
    }

    @Então("a sala aparecera na listagem")
    public void a_sala_aparecera_na_listagem() {
        componente.validNewSala();
    }
}
