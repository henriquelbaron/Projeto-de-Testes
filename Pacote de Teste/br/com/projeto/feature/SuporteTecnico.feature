# language: pt
@suporte_tecnico
Funcionalidade: Validar cadastro, edição e exclusão de suporte técnico

  Contexto: 
    Dado que o usuário encontra-se na tela de listagem de suporte técnico

  @cadastrar_suporte_tecnico
  Cenário: Validar cadastro de suporte técnico
    Dado que o usuário clicou no botão novo
    E selecionou um <setor>
    E preencheu <responsável>
    Quando o usuário clicar no botão salvar
E pelo <responsável>
    Então ao pesquisar <responsável>
    

  @alterar_suporte_tecnico
  Cenário: Validar edição de suporte técnico
    Dado que o usuário clicou no botão alterar
    E editou os dados do suporte técnico
    Quando o usuário clicar no botão salvar
    Então o sistema deverá alterar os dados que foram cadastrados

  @excluir_suporte_tecnico
  Cenário: Validar exclusão de suporte técnico
    Quando o usuário clicar no botão excluir suporte técnico
    E o usuário confirmar a exclusão do suporte técnico
    Então o suporte técnico selecionado deverá ser excluído da grid de suporte técnico

  @listar_suporte_tecnico
  Cenário: Validar listagem de suporte técnico
    Quando o usuário clicar no botão pesquisar
    E o campo de pesquisa de suporte técnico estiver vazio
    Então o sistema deverá listar todos os suportes técnicos
