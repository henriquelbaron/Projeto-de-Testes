# language: pt
Funcionalidade: Persistência de Sala
  Cadastro de Sala - O sistema deverá cadastrar uma nova sala com os dados fornecidos pelo usuário
  Alteração de Sala - O sistema deverá alterar corretamente a sala selecionada
  Exclusão de Sala - O sistema deverá excluir a Sala selecionada
  Ativação / Inativação - O sistema deverá ativar/inativar a Sala selecionada

  Contexto: 
    Dado que o usuário se encontra na tela listagem de salas

  @cadastrar_sala
  Cenário: Cadastrar sala
    Dado que o usuário clicou no botão novo
    E o usuário preencheu os campos corretamente
    Quando o usuário clicar no botão salvar
    Então o sistema deverá cadastrar a nova sala no banco de dados
    E na próxima listagem a sala recém cadastrada deverá aparecer

  @alterar_sala
  Cenário: Alterar sala
    Dado que o usuário clicou no botão alterar
    E o usuário alterou algum dos campos corretamente
    Quando o usuário clicar no botão salvar
    Então o sistema deverá alterar a nova sala no banco de dados
    E na próxima listagem a sala deverá apresentar os dados alterados

  @excluir_sala
  Cenário: Excluir sala
    Dado que o usuário clicou no botão excluir
    Quando o clicar clicar no botão sim na caixa de diálogo de confirmação
    Então o sistema deverá excluir a sala do banco de dados
    E a sala não deverá aparecer na próxima listagem

  @listagem_sala
  Cenário: Listagem de salas
    Quando o usuário digitar no campo de pesquisa
    E clicar no botão pesquisar
    Então as salas com os caracteres digitados devem aparecer na grid de salas
