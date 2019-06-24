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
    }
}
