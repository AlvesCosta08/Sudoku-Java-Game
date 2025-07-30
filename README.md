# Sudoku Java Game

## Descrição

Projeto desenvolvido em Java que implementa um jogo de Sudoku para terminal.  
Permite carregar o tabuleiro inicial via argumentos de linha de comando no formato específico, representando as posições, valores e células fixas.  
Este projeto é um ótimo exemplo prático para demonstrar habilidades em manipulação de arrays, parsing de strings, controle de fluxo, orientação a objetos e execução de programas Java via terminal.

---

## Tecnologias e Skills aplicadas

- Linguagem Java (Java SE 8+)
- Estruturas de dados: arrays multidimensionais
- Manipulação e parsing de strings (split, regex)
- Orientação a objetos: encapsulamento, classes e métodos
- Tratamento de exceções
- Execução via linha de comando com argumentos complexos
- Compilação e execução manual via terminal
- Versionamento com Git e boas práticas de commit
- Planejamento e organização do código para extensibilidade

---

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seuusuario/sudoku-java-game.git
cd sudoku-java-game

javac src/*.java -d bin


java -cp bin Main "0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true ..."


sudoku-java-game/
│
├── src/               # Código-fonte Java
│   ├── Main.java
│   ├── SudokuGame.java
│   └── SudokuBoard.java
│
├── bin/               # Classes compiladas (gerado após compilação)
│
├── run.sh             # Script para executar o projeto facilmente (opcional)
│
└── README.md          # Documentação do projeto


