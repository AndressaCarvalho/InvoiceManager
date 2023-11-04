<h1 align="center">
    Invoice Manager
</h1>

## Descrição do projeto
O projeto consiste em um serviço CLI (Command-Line Interface, ou Interface de Linha de Comando) para administrar faturas de clientes fictícios, desenvolvido em Spring Shell, com a linguagem de programação Java. Tal aplicação objetiva prover um meio de gerar arquivos de saída, em formato CSV, a partir em um arquivo de entrada, em formato TXT, que simula dados de faturas.<br/>

### 🚀 **Sobre as tecnologias utilizadas**

Para a implementação do sistema, uma linguagem de programação foi selecionada. Abaixo estão os critérios utilizados para isto: 
1. A linguagem deve ser uma das mais usadas no mercado;
2. A linguagem deve ser comumente utilizada para desenvolver aplicações em linha de comando;
3. A linguagem deve ser de amplo conhecimento pelo desenvolvedor, a fim de agilizar o tempo de desenvolvimento da aplicação.

Assim, dentre as linguagens de programação que atendem os dois primeiros requisitos, sendo estas Java, Python, C e C++, a escolhida foi Java, a qual o desenvolvedor possui mais familiaridade.

Após a escolha da linguagem, a próxima etapa foi a seleção de um framework, para que o projeto fosse devidamente estruturado. Isto foi feito através dos critérios: 
1. O framework deve ser um dos mais utilizados para Java no mercado;
2. O framework deve ter suporte ao Shell (frequentemente usado em conjunto com o CLI), para que o usuário possa interajir com o sistema operacional, por meio de comandos de texto interpretados por este.
3. O framework deve ser conhecido pelo desenvolvedor, para agilizar o tempo de desenvolvimento da aplicação.

Por fim, o framework selecionado foi o Spring, que possui suporte ao Shell, por meio do Spring Shell.

<br/>
<h3 align="center">
    <a href="https://spring.io/projects/spring-shell">🔗 Spring Shell</a>
</h3>
<p align="center">
  fornece um Shell interativo para o processamento de comandos e construção de uma CLI completa, usando o framework Spring.
</p>
<br/>
<h4>
    <img src="https://img.shields.io/badge/build-aprovado-brightgreen" />
    <img src="https://img.shields.io/badge/versão-v1.0.0-blue" />
    <img src="https://img.shields.io/badge/última%20atualização-novembro%202023-lightblue" />
    <img src="https://img.shields.io/badge/linguagem-java-orange" />
    <img src="https://img.shields.io/badge/plataforma-spring-orange" />
    <img src="https://img.shields.io/badge/inglês%20(US)-100%25-ff69b4" />
</h4>

---

## Status do projeto
#### ✅ Released
---

## Índice
<ul>
  <li><a href="#descrição-do-projeto">Descrição do projeto</a></li>
  <li><a href="#status-do-projeto">Status do projeto</a></li>
  <li><a href="#índice">Índice</a></li>
  <li><a href="#recursos">Recursos</a></li>
  <li><a href="#pré-requisitos">Pré-requisitos</a></li>
  <li><a href="#tecnologias">Tecnologias</a></li>
  <li><a href="#autora">Autora</a></li>
</ul> 

---

## Recursos
- [x] Leitura de arquivos de entrada em formato TXT;
- [x] Validação de CEP's relacionados às faturas (devem ser numéricos, não podem estar zerados, e devem ter o tamanho maior ou igual a sete, e menor ou igual a oito);
- [x] Conversão do número de páginas das faturas em par;
- [x] Divisão do arquivo TXT de origem em arquivos CSV, baseada no valor da fatura (arquivo separado para valor igual à R$ 0,00) e número de páginas das faturas (separação por número menor ou igual à seis, menor ou igual à doze, e maior que doze).

---

## Pré-requisitos
Você deve ter as seguintes ferramentas instaladas em sua máquina: 
- O [Git](https://git-scm.com/downloads), para obter o projeto;
- Uma IDE, como a [IntelliJ IDEA](https://www.jetbrains.com/idea/), para executar o sistema.

### ▶️ Executando a aplicação
- Em sua máquina, abra o Git Bash, entre na pasta a qual o projeto deve ficar, e digite o comando abaixo:

```bash
$ git clone https://github.com/AndressaCarvalho/InvoiceManager.git
```

- Abra o projeto baixado em a sua IDE de escolha.
- Por meio da IDE, execute a aplicação.
- No terminal Shell interativo, digite o comando ***generate***, seguido do caminho absoluto do arquivo TXT de origem, como no exemplo abaixo:

```bash
shell:> generate C:/Users/Computer/Desktop/file_base.txt
```

- Aguarde até que o arquivo seja processado.
- Ao fim do processo, se forem encontrados dados a serem separados, o sistema informará o caminho para o(s) arquivo(s) CSV gerado(s).

---

## Tecnologias
As seguintes ferramentas foram utilizadas na construção do projeto:
- [Spring](https://spring.io/)
- [Spring Shell](https://spring.io/projects/spring-shell)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Git](https://git-scm.com/)

---

## Autora
<a href="https://github.com/AndressaCarvalho">
  <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/51313172?s=96&v=4" width="100px;" alt=""/>
  <br/>
  <sub><b>Andressa Carvalho</b></sub>
 </a> <a href="https://github.com/AndressaCarvalho" title="Rocketseat">🚀</a>
<br/><br/>
Feito com ❤️ por Andressa Carvalho 👋🏽 Entre em contato!
<br/><br/>

[![Linkedin Badge](https://img.shields.io/badge/-Andressa-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/andressa-carvalho-araujo-289931199/)](https://www.linkedin.com/in/andressa-carvalho-araujo-289931199/) 
[![Gmail Badge](https://img.shields.io/badge/-andressa.carvalho13454@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:andressa.carvalho13454@gmail.com)](mailto:andressa.carvalho13454@gmail.com)
