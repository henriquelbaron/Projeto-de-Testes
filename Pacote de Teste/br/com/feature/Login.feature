# language: pt
Funcionalidade: Login

  Contexto: 
    Dado que o usuário acessou o a pagina de login

@login_sucesso
  Cenário: Login no sistema com um usuário valido
    Dado que o usuário digitou um login valido
    E o usuário digitou uma senha
    Quando o usuário clicar no botão Entrar
    Então ele sera redirecionado para a pagina inicial

@login_usuario_invalido
  Cenário: Validar Tentativa de login com usuário invalido
    Dado que o usuário digitou um login invalido
    E o usuário digitou uma senha válida
    Quando o usuário clicar no botão Entrar
    Então será apresentado ao usuário uma mensagem Dados Incorretos

@login_senha_invalida
   Cenário: Validar Tentativa de login com senha invalida
    Dado que o usuário digitou um login valido
    E o usuário digitou uma senha invalida
    Quando o usuário clicar no botão Entrar
    Então será apresentado ao usuário uma mensagem Dados incorretos

@login_logout
    Cenário: Validar logout do Sistema
    Dado que o usuário esta logado no sistema
    Quando ele clica no botão Sair
    Então ele sera redirecionado para a pagina de login