# language: pt
Funcionalidade: Persistência de Usuário
  Cadastro de Usuários - O sistema deverá cadastrar um novo usuário com os dados fornecidos pelo usuário
  Alteração de Usuários - O sistema deverá alterar corretamente o usuário selecionado
  Exclusão de Usuários - O sistema deverá excluir o usuário selecionado
  Ativação / Inativação - O sistema deverá ativar/inativar o usuário selecionado

  Contexto: 
    Dado que o usuário se encontra na tela listagem de usuários

  @cadastrar_usuario
  Cenário: Cadastrar usuário
    Dado que o usuário clicou no botão novo
    E o usuário preencheu os campos corretamente
    Quando o usuário clicar no botão salvar
    Então o novo  cadastro estará na listagem

  @alterar_usuario
  Cenário: Alterar usuário
    Dado que o  usuário pesquisou o cadastro a ser alterado
    E clicou no botão alterar
    E alterou algum dos campos
    Quando o usuário clicar no botão salvar
    Então as alterações do cadastro será mostrado na listagem

  @excluir_usuario
  Cenário: Excluir usuário
    Dado que o usuário pesquisou o cadastro a ser Excluído
    E clicou no botão excluir
    Quando o usuário confirmar a ação
    Então o cadastro excluído não aparecera na listagem

  @ativar_desativar_usuario
  Cenário: Ativação ou Inativação de usuário
    Dado que o  usuário pesquisou o cadastro a ser alterado
    Quando o usuário clicar no botão ativar/desativar
    E confirmar a ação
    Então a situação do cadastro sera mudada
