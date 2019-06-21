# language: pt
@sala
Funcionalidade: Persistência de Sala
  Cadastro de Sala - O sistema deverá cadastrar uma nova sala com os dados fornecidos pelo usuário
  Alteração de Sala - O sistema deverá alterar corretamente a sala selecionada
  Exclusão de Sala - O sistema deverá excluir a Sala selecionada

  Contexto: 
    Dado que o usuário se encontra na tela listagem de salas

  @cadastrar_sala
  Esquema do Cenário: Cadastrar sala
    Dado que o usuário clicou no botão novo
    E o usuário preencheu <nome> e <descrição>
    Quando o usuário clicar no botão salvar
    Então a sala aparecera na listagem com os campos <nome> e <descrição>

    Exemplos: 
      | nome          | descrição               |
      | "Natação"     | "Onde as pessoas Nadam" |
      | "Redes"       | "Vários cabos"          |
      | "Estudos"     | "Silêncio!"             |
      | "Informática" | "Tem computadores!"     |

  @alterar_sala
  Esquema do Cenário: Alterar sala
    Dado que o usuário pesquisou a <sala> a ser alterada
    E clicou no botão alterar
    E alterou o <nome>
    Quando o usuário clicar no botão salvar
    Então a sala aparecera na listagem com o <nome>

    Exemplos: 
      | sala      | nome        |
      | "Natação" | "Patinação" |

  @excluir_sala
  Esquema do Cenário: Excluir sala
    Dado que o usuário pesquisou a <sala> a ser excluída
    E clicou no botão excluir
    Quando o usuário confirmar a ação
    Então a <sala> não aparecera na listagem

    Exemplos: 
      | sala      |
      | "Estudos" |

  @listagem_sala
  Esquema do Cenário: Listagem de salas
    Dado que o usuário digitou o nome da  <sala> 
    Quando o usuário clicar no botão pesquisar
    Então as <sala> que contém o nome digitado serão mostrados

    Exemplos: 
      | sala          |
      | "Informática" |