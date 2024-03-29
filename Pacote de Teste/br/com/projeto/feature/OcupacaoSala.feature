# language: pt
@ocupacao_sala
Funcionalidade: Ocupação de salas
  Cadastro
  Alteração
  Exclusão
  Verificar exibição da sala ocupada em Salas em Uso

  Contexto: 
    Dado que o usuário esta no menu Ocupação de Salas

  @cadastrar_ocupacao_sala
  Esquema do Cenário: Ocupar Sala
    Dado que o usuário clicou no botão Novo
    Quando preencher <informação>, <inicio> e <fim>
    E selecionar <período> e <sala disponível>
    E clicar no botão Salvar
    Então ao pesquisar <sala disponível>, se mostrara ocupada

    Exemplos: 
      | informação    | inicio       | fim          | período    | sala disponível |
      | "POO"         | "26/12/2019" | "26/12/2019" | "Noturno"  | "1994"          |
      | "Algorítimos" | "27/12/2019" | "27/12/2019" | "Noturno"  | "2030"          |
      | "POO"         | "27/12/2019" | "27/12/2019" | "Matutino" | "1994"          |

  @alterar_ocupacao_sala
  Esquema do Cenário: Alterar ocupação de sala
    Dado que o usuário pesquisou a <sala> que deseja alterar
    E clicou em no agendamento
    E depois clicou em alterar
    E alterou a <informação>
    E confirmou a alteração
    Quando o usuário pesquisar a <sala> alterada
    Então a nova  <informação> estara no popup

    Exemplos: 
      | sala   | informação            |
      | "1994" | "informação alterada" |

  @excluir_ocupacao_sala
  Esquema do Cenário: Exclusão de sala
    Dado que o usuário pesquisou a <sala> que deseja excluir a ocupação
    Quando ele clicar no botão Deletar
    E confirmar a ação
    Então ao listar, a ocupação da <sala> não será mostrada

    Exemplos: 
      | sala   |
      | "2030" |
