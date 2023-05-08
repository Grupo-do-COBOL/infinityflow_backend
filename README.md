<h2><a href= "https://www.mackenzie.br">Universidade Presbiteriana Mackenzie</a></h2>
<h3><a href= "https://www.mackenzie.br/graduacao/sao-paulo-higienopolis/sistemas-de-informacao">Sistemas de Informação</a></h3>

# Template para Prática Profissional em ADS

Este repositório define um modelo (*template*) que deve ser seguido por cada grupo para o projeto.

A seguir estão os passos sugeridos para a preparação do seu grupo no início do projeto:

1. Um dos membros do grupo deverá realizar um *fork* deste repositório.
2. O dono do repositório deverá convidar os demais membros do grupo para serem colaboradores.
3. O dono do repositório deverá convidar o professor para ser colaborador do repositório.
4. O dono do repositório deverá habilitar o GitHub Pages. Basta seguir o [procedimento para habilitar o GitHub Pages](https://docs.github.com/pt/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site), lembrando de escolher em *Source* a opção `/docs` em lugar da opção `/root`.
5. Cada membro do grupo deverá instalar o [Git](https://git-scm.com/downloads).
6. Para a edição do conteúdo deste projeto, sugere-se que cada membro do grupo faça a instalação do [Visual Studio Code](https://code.visualstudio.com/) com as extensões [Markdown All in One](https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one) e [GitHub Pull Requests and Issues](https://marketplace.visualstudio.com/items?itemName=GitHub.vscode-pull-request-github). No entanto, cada membro poderá utilizar a IDE de sua preferência.
7. Cada membro do grupo deverá [clonar o repositório do grupo no seu computador](https://learn.microsoft.com/en-us/azure/developer/javascript/how-to/with-visual-studio-code/clone-github-repository?tabs=create-repo-command-palette%2Cinitialize-repo-activity-bar%2Ccreate-branch-command-palette%2Ccommit-changes-command-palette%2Cpush-command-palette).
8. Cada membro do grupo deverá editar o seu próprio nome no arquivo em [/docs/index.md](./docs/index.md), de preferência [criando um novo *branch* e um *pull request*](https://www.youtube.com/watch?v=LdSwWxVzUpo).
9. O dono do repositório deverá editar este arquivo, removendo estas instruções iniciais e preenchendo o restante da página com os dados do projeto do seu grupo.


# Projeto: *Infinityflow*

# Grupo: *GRUPO DO COBOL*

# Descrição

*O Infinityflow é um sistemas de presença focado em auxiliar instituições de ensino a gerenciar a lista de presença dos alunos de um jeito fácil e rápido, abdicando da papeladas, pensado para o cenário epidemico e pós epidêmico onde muitos possuiam dificuldade em digitalizar seus cadernos de presença.*

# Documentação

Os arquivos da documentação deste projeto estão na pasta [/docs](/docs), e o seu conteúdo é publicado em **https://grupo-do-cobol.github.io/infinityflow_backend/**.


# Releases

Deverá ser publicado um release ao término de cada entrega do projeto.

# Para rodar localmente

1. git clone https://github.com/Grupo-do-COBOL/infinityflow_backend.git
2. no arquivo properties altere para as configurações local do seu banco de dados mysql:
- spring.datasource.url=jdbc:mysql://${HOST_DATABASE}:3306/infinityflow_db
- spring.datasource.username=${USERNAME_DATABASE}
- spring.datasource.password=${PASSWORD_DATABASE}
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
3. após a configuração do properties execute no terminal mvn clean install
4. teste alguns endpoints:

todos os endpoins com o verbo  [GET] devem ser passado no header um Bearer token, gerado pela rota /api/v1/login/autenticação ou /api/v1/login/registrar
* [GET] http://localhost:8080/api/v1/usuarios/buscar_por_email?email=DIGITE O EMAIL
* [GET] http://localhost:8080/api/v1/usuarios/buscar_por_nome?nome=DIGITE O NOME DO USUARIO
* [GET] http://localhost:8080/api/v1/usuarios
* [GET] http://localhost:8080/api/v1/usuarios/buscar_usuario?id=ID DO USUARIO
* [POST] http://localhost:8080/api/v1/login/registrar
  body:
  {
  "nome": "NOME DO USUARIO ",
  "email": "EMAIL@EMAIL.COM",
  "funcao": "PROFESSOR",
  "senha": "SENHA DO USUARIO"
  }
* [POST] http://localhost:8080/api/v1/login/autenticacao
  body:
  {
  "email": "EMAIL@EMAIL.COM",
  "senha": "SENHA DO USUARIO"
  }
* [POST] http://localhost:8080/sistema/v1/registrar_presencas
  body:
  {
  "id_aula": "1",
  "lista_presencas": \[
  {
  "id_aluno": "1",
  "situacao": "P"
  },
  {
  "id_aluno": "2",
  "situacao": "A"
  }
  \]
  }
* [GET] http://localhost:8080/sistema/v1/lista_aulas?idProfessor=?
* [GET] http://localhost:8080/sistema/v1/lista_alunos?idDadosLetivos=?