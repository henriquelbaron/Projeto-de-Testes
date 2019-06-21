# language: pt
@usuario
Funcionalidade: Persistência de Usuário
  Cadastro de Usuários - O sistema deverá cadastrar um novo usuário com os dados fornecidos pelo usuário
  Alteração de Usuários - O sistema deverá alterar corretamente o usuário selecionado
  Exclusão de Usuários - O sistema deverá excluir o usuário selecionado
  Ativação / Inativação - O sistema deverá ativar/inativar o usuário selecionado

  Contexto: 
    Dado que o usuário se encontra na tela listagem de usuários

  @cadastrar_usuario
  Esquema do Cenário: Cadastrar usuário
    Dado que o usuário clicou no botão novo
    E o usuário preencheu <nome> e <email> corretamente
    E selecionou um perfil
    Quando o usuário clicar no botão salvar
    Então <nome> e <email> sera mostrado ao pesquisar pelo usuário cadastrado

    Exemplos: 
      | nome       | email            |
      | "Henrique" | "oi@gmail.com"   |
      | "William"  | "thau@gmail.com" |
      | "Adriene"  | "aaa@gmail.com"  |

  @alterar_usuario
  Esquema do Cenário: Alterar usuário
    Dado que o  usuário pesquisou pelo <usuário>
    E clicou no botão alterar
    E alterou o <email>
    Quando o usuário clicar no botão salvar
    Então o novo <email> sera mostrado ao pesquisar pelo usuário alterado

    Exemplos: 
      | usuário    | email                |
      | "Henrique" | "henrique@gmail.com" |

  @excluir_usuario
  Esquema do Cenário: Excluir usuário
    Dado que o usuário pesquisou pelo <usuário>
    E clicou no botão excluir
    Quando o usuário confirmar a ação
    Então o <usuário> não estará mais na listagem

    Exemplos: 
      | usuário   |
      | "Adriene" |

  @ativar_desativar_usuario
  Esquema do Cenário: Ativação ou Inativação de usuário
    Dado que o usuário pesquisou pelo <usuário>
    Quando o usuário clicar no botão ativar/desativar
    E confirmar a ação
    Então a situação do cadastro sera mudada

    Exemplos: 
      | usuário   |
      | "William" |