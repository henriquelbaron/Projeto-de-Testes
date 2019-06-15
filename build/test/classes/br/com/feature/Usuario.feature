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
    Então o sistema deverá cadastrar o novo usuário no banco de dados
    E na próxima listagem o usuário recém cadastrado deverá aparecer
@alterar_usuario
  Cenário: Alterar usuário
    Dado que o usuário clicou no botão alterar
    E o usuário alterou algum dos campos corretamente
    Quando o usuário clicar no botão salvar
    Então o sistema deverá alterar o novo usuário no banco de dados
    E na próxima listagem o usuário deverá apresentar os dados alterados
@excluir_usuario
  Cenário: Excluir usuário
    Dado que o usuário clicou no botão excluir
    Quando o usuário clicar no botão sim na caixa de diálogo de confirmação
    Então o sistema deverá excluir o usuário do banco de dados
    E o usuário não deverá aparecer na próxima listagem
@
  Cenário: Ativação / Inativação de usuário
    Quando que o usuário clicou no botão de alterar status de ativação
    Então o status do usuário é alterado
