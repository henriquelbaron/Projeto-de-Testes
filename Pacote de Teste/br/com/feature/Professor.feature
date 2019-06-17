# language: pt
@professor
Funcionalidade: Cadastro de professores
  Cadastro
  Alteração
  Exclusão
  Adicionar e Remover Disciplinas

  Contexto: 
    Dado que o usuário se encontra em listagem de professores

  @cadastrar_professor
  Esquema do Cenário: Cadastrar Professor
    Dado que o usuário clicou no botão Novo
    E preencheu os campos <nome>,<celular> e <email>
    Quando o usuário clicar no botão Salvar
    E pesquisar pelo <nome>
    Então o <nome>,<celular> e <email> estará na listagem de professores

    Exemplos: 
      | nome       | celular       | email             |
      | "Henrique" | "48996850322" | "email@gmail.com" |
      | "João"     | "48996850322" | "email@gmail.com" |
      | "William"  | "48212341234"  | "email@gmail.com" |
      | "Adriene"  | "48212341234"  | "email@gmail.com" |

  @alterar_professor
  Esquema do Cenário: Alterar Professor
    Dado que o usuário pesquisou pelo <professor> a ser alterado
    E clicou no botão Alterar
    E alterou os campos <nome> e <email>
    Quando o usuário clicar no botão Salvar
    Então as novas informações do <professor> serão mostradas na listagem

    Exemplos: 
      | professor  | nome             | email            |
      | "Henrique" | "Henrique Baron" | "novo@gmail.com" |

  @excluir_professor
  Esquema do Cenário: Excluir Professor
    Dado que o usuário pesquisou pelo <professor> a ser excluído
    E clicou no botão Excluir
    Quando o usuário confirmar a exclusão
    Então o <professor> não estará mais na listagem

    Exemplos: 
      | professor |
      | "Adriene" |

  @adicionar_disciplina_professor
  Esquema do Cenário: Adicionar Disciplina ao Professor
    Dado que o usuário pesquisou pelo <professor> desejado
    E clicou no botão Alterar
    E clicou em Adicionar Disciplina
    E preencheu o campo de texto com a <disciplina>
    Quando o usuário clicar em Salvar
    Então a <disciplina> sera mostrada ao pesquisa pelo <professor>

    Exemplos: 
      | professor | disciplina |
      | "William" | "POO"      |
      | "João"    | "QTS"      |

  @excluir_disciplina_professor
  Esquema do Cenário: Excluir Disciplina do Professor
    Dado que o usuário pesquisou pelo <professor> desejado
    E clicou no botão Alterar
    E clicou no botão Remover da disciplina desejada
    Quando o usuário clicar em Salvar
    Então a <disciplina> não sera mostrada ao pesquisa pelo <professor>

    Exemplos: 
      | professor |
      | "William" |
      | "João"    |
