# language: pt
@suporte_tecnico
Funcionalidade: Validar cadastro, edição e exclusão de suporte técnico, Listagem

  Contexto: 
    Dado que o usuário encontra-se na tela de listagem de suporte técnico

  @cadastrar_suporte_tecnico
  Esquema do Cenário: Validar cadastro de suporte técnico
    Dado que o usuário clicou no botão novo
    E selecionou um <setor>
    E preencheu <responsável>
    Quando o usuário clicar no botão salvar
    Então o suporte sera mostrado ao pesquisar pelo <responsável>

    Exemplos: 
      | setor         | responsável       |
      | "Atendimento" | "sala@gmail.com	" |

  @alterar_suporte_tecnico
  Esquema do Cenário: Validar edição de suporte técnico
    Dado que o usuário pesquisou o <suporte> a ser alterado
    E clicou no botão alterar
    E trocou o <setor>
    Quando o usuário clicar no botão salvar
    Então o <setor> sera mostrado ao pesquisar pelo <suporte>

    Exemplos: 
      | suporte          | setor        |
      | "sala@gmail.com" | "Financeiro" |

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
