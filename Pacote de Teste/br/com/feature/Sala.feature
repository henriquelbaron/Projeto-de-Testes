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
    E o usuário preencheu nome e descrição
    Quando o usuário clicar no botão salvar
    Então a sala aparecera na listagem

  @alterar_sala
  Cenário: Alterar sala
    Dado que o usuário clicou no botão alterar
    E o usuário alterou os campos
    Quando o usuário clicar no botão salvar
    Então a sala aparecera na listagem

  @excluir_sala
  Cenário: Excluir sala
    Dado que o usuário clicou no botão excluir
    Quando o usuário confirmar a ação
    Então a sala não aparecera na listagem

  @listagem_sala
  Cenário: Listagem de salas
    Quando o usuário digitar o nome da sala no campo de pesquisa
    E clicar no botão pesquisar
    Então as salas que contém o nome digitado serão mostrados
