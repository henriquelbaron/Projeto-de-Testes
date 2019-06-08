# language: pt

Funcionalidade: CRUD de usuários


Contexto:
Dado que o usuário está no menu Usuário

@validar_cadastro_de_usuario
  Cenário: Cadastrar Novo usuário
    Dado que o usuário clicou no botão Novo
    E digitou um nome no campo Nome
    E um email no campo de Email
    E selecinou um perfil na combobox
    Quando o usuário clicar no botão salvar
    Então o resultado na calculadora deve ser 120
