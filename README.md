# 🐧 PinguLang

Um compilador educacional desenvolvido com **JavaCC**, featuring análise léxica/sintática e mensagens de erro em português.

![Java](https://img.shields.io/badge/Java-JavaCC-red)
![Compiler](https://img.shields.io/badge/Type-Compiler-blue)

## 📋 Sobre

PinguLang é uma linguagem de programação criada para fins educacionais, com sintaxe divertida inspirada em personagens de desenhos animados. O compilador realiza análise léxica e sintática, com tratamento de erros amigável em português.

## ✨ Características

- 🔤 **4 tipos de dados:** inteiro, flutuante, booleano e char
- 🔁 **Estruturas de controle:** while, for, do-while, if-else
- 📝 **Declaração de variáveis** com ou sem atribuição
- ⚠️ **Mensagens de erro** em português
- 🔄 **Recuperação de erros** com método de sincronização do pânico

## 📖 Sintaxe da Linguagem

### Estrutura Básica

```
E LA VAMOS NOS
    // código aqui
ISSO EH TUDO P-PESSOAL
```

### Tipos de Dados

| Tipo | Palavra-chave | Exemplo |
|------|---------------|---------|
| Inteiro | `IO` | `IO idade = 25 PINGU` |
| Float | `FLORZINHA` | `FLORZINHA preco = 9.99 PINGU` |
| Booleano | `SID` | `SID ativo = A GENTE VAI VIVER PINGU` |
| Char | `PENELOPE CHARMOSA` | `PENELOPE CHARMOSA letra = 'A' PINGU` |

### Estruturas de Controle

**Condicional (if-else):**
```
SERIA (condicao) {
    // código
} OU SERA QUE NAO {
    // else
}
```

**While:**
```
A EH REPETE (condicao) {
    // código
}
```

**For:**
```
FORCA G (i = 0, i < 10, i += 1) {
    // código
}
```

**Do-While:**
```
YABBA DABBA DOO {
    // código
} A EH REPETE (condicao) PINGU
```

### Entrada e Saída

```
MOSTLA("Texto aqui") PINGU    // Output
ESCLEVE(variavel) PINGU       // Input
```

## 📐 Gramática (BNF)

```bnf
<Programa> ::= "E LA VAMOS NOS" <Declaracoes> <Comandos> "ISSO EH TUDO P-PESSOAL"

<Declaracao> ::= <Tipo> <ListaVariaveis> "PINGU"

<Tipo> ::= "IO" | "FLORZINHA" | "SID" | "PENELOPE CHARMOSA"

<Condicional> ::= "SERIA" "(" <Expressao> ")" <Comando> 
                  [ "OU SERA QUE NAO" <Comando> ]

<While> ::= "A EH REPETE" "(" <Expressao> ")" <Comando>

<For> ::= "FORCA G" "(" <Atribuicao> "," <Expressao> "," <Atribuicao> ")" <Comando>

<DoWhile> ::= "YABBA DABBA DOO" <Comando> "A EH REPETE" "(" <Expressao> ")" "PINGU"
```

## 💻 Exemplo Completo

```
E LA VAMOS NOS

IO contador = 0 PINGU
FLORZINHA soma = 0.0 PINGU

A EH REPETE (contador < 5) {
    MOSTLA("Contador: ") PINGU
    MOSTLA(contador) PINGU
    soma += 1.5 PINGU
    contador += 1 PINGU
}

SERIA (soma > 5.0) {
    MOSTLA("Soma passou de 5!") PINGU
} OU SERA QUE NAO {
    MOSTLA("Soma menor que 5") PINGU
}

ISSO EH TUDO P-PESSOAL
```

## ⚠️ Tratamento de Erros

O compilador detecta e reporta erros com mensagens em português:

| Tipo de Erro | Exemplo | Mensagem |
|--------------|---------|----------|
| Léxico | `123abc` | Token inválido |
| Sintático | Falta `PINGU` | Esperado "PINGU" ao final da declaração |
| Símbolo inválido | `@` | Símbolo não reconhecido |

## 🔧 Limitações Conhecidas

- ❌ Não suporta funções definidas pelo usuário
- ❌ Não possui arrays ou estruturas de dados complexas
- ❌ Sem suporte a strings (apenas char)
- ❌ Sem geração de código executável (apenas análise)

## 🛠️ Tecnologias

- **Java** - Linguagem principal
- **JavaCC** - Gerador de parser
- **JJTree** - Geração de árvore sintática

# Inicialização
1. Compilar o arquivo pinguLangCompiler.jjt usando a extensão JavaCC
2. Iniciar o arquivo Interface.java no pacote frame

# Nossa Backus-Naur 
```Backus-Naur Form
<Programa> ::= "E LA VAMOS NOS" <Declaracoes> <Comandos> "ISSO EH TUDO P-PESSOAL"

<Declaracoes> ::= { <Declaracao> }

<Declaracao> ::= <Tipo> <ListaVariaveis> "PINGU"

<DeclaracaoSemPingu> ::= <Tipo> <ListaVariaveis>

<Tipo> ::= "IO" | "FLORZINHA" | "SID" | "PENELOPE CHARMOSA"

<ListaVariaveis> ::= <VariavelDeclarada> { "," <VariavelDeclarada> }

<VariavelDeclarada> ::= <ID> [ <OpAtrib> <Expressao> ]

<OpAtrib> ::= "=" | "+=" | "-=" | "*=" | "/="

<Comandos> ::= { <Comando> }

<Comando> ::= <Condicional>
            | <Repeticao>
            | <Atribuicao> "PINGU"
            | <EntradaSaida> "PINGU"
            | <Bloco>

<Atribuicao> ::= <ID> <OpAtrib> <Expressao>

<Condicional> ::= "SERIA" "(" <Expressao> ")" <Comando> [ "OU SERA QUE NAO" <Comando> ]

<Repeticao> ::= <While> | <For> | <DoWhile>

<While> ::= "A EH REPETE" "(" <Expressao> ")" <Comando>

<For> ::= "FORCA G" "(" ( <DeclaracaoSemPingu> | <Atribuicao> ) "," <Expressao> "," <Atribuicao> ")" <Comando>

<DoWhile> ::= "YABBA DABBA DOO" <Comando> "A EH REPETE" "(" <Expressao> ")" "PINGU"

<EntradaSaida> ::= "MOSTLA" "(" <Expressao> ")"
                 | "ESCLEVE" "(" <ID> ")"

<Bloco> ::= "{" <Comandos> "}"

<Expressao> ::= <ExpressaoLogica>

<ExpressaoLogica> ::= <ExpressaoRelacional> { <OP_LOGICO> <ExpressaoRelacional> }

<ExpressaoRelacional> ::= <ExpressaoAritmetica> { <OP_RELACIONAL> <ExpressaoAritmetica> }

<ExpressaoAritmetica> ::= <Termo> { ("+" | "-") <Termo> }

<Termo> ::= <Fator> { ("*" | "/" | "%") <Fator> }

<Fator> ::= <ID>
          | <INTEIRO>
          | <FLOAT>
          | "A GENTE VAI VIVER"
          | "A GENTE VAI MORRER"
          | <CHAR>
          | <STRING>
          | "(" <Expressao> ")"
          | "!" <Fator>

```


# Exemplos de código em Pingulang
## 1. Marcadores de início e fim do programa

```pingu
E LA VAMOS NOS
ISSO EH TUDO P-PESSOAL
```

```
E LA VAMOS NOS
IO x = 10 PINGU
ISSO EH TUDO P-PESSOAL
```
## 2. Tipos de dados
```
E LA VAMOS NOS
IO idade = 25 PINGU                     
FLORZINHA preco = 9.99 PINGU           
SID eh_valido = A GENTE VAI VIVER PINGU  
PENELOPE CHARMOSA letra = 'A' PINGU      
ISSO EH TUDO P-PESSOAL
```

## 3. Comandos e Atribuições

### Atribuição válida
```
E LA VAMOS NOS
IO a = 10 PINGU                     
FLORZINHA b = a + 5.5 PINGU         
SID c = A GENTE VAI VIVER PINGU     
a += 3 PINGU                        
ISSO EH TUDO P-PESSOAL
```

```XXX
E LA VAMOS NOS
IO a, b = 10 PINGU
a = b PINGU             
ISSO EH TUDO P-PESSOAL
```

```
E LA VAMOS NOS
IO x = (10 + (5 * 2)) / (3 % 2) PINGU 
ISSO EH TUDO P-PESSOAL
```

### If-else válido
```
E LA VAMOS NOS
SID cond = A GENTE VAI VIVER PINGU
SERIA (cond) {
    MOSTLA("Passei na matéria do Jorge")PINGU
} OU SERA QUE NAO {
    MOSTLA("Seloco, deu ruim")PINGU
}
ISSO EH TUDO P-PESSOAL
```

### While
```
E LA VAMOS NOS
IO i = 0 PINGU
A EH REPETE (i < 10) {
    i += 1 PINGU
}
ISSO EH TUDO P-PESSOAL
```
### For
```
E LA VAMOS NOS
IO i PINGU            
IO j PINGU            
FLORZINHA x PINGU     
FORCA G (i = 0, i < 5, i += 1) {
    MOSTLA("Contagem: ") PINGU
    MOSTLA(i) PINGU
}
FORCA G (j = 10, j > 0, j -= 2) {
    MOSTLA("Decrescendo: ") PINGU
    MOSTLA(j) PINGU
}
x = 0.5 PINGU
FORCA G (x = 0.5, x < 3.0, x += 0.5) {
    MOSTLA("Float: ") PINGU
    MOSTLA(x) PINGU
}
FORCA G (i = 0, i < 10 && i != 5, i += 1) {
    MOSTLA("Condição composta: ") PINGU
    MOSTLA(i) PINGU
}
ISSO EH TUDO P-PESSOAL
```


### Blocos alinhados
```
E LA VAMOS NOS
IO x = 1 PINGU
{
    MOSTLA("Acho que X = 1")PINGU
    {
        MOSTLA("Blocos alinhados! Que INSANO")PINGU       
    }
}
ISSO EH TUDO P-PESSOAL
```

### DO
```
E LA VAMOS NOS

IO contador = 0 PINGU

YABBA DABBA DOO {
    MOSTLA(contador) PINGU
    contador += 1 PINGU
} A EH REPETE (contador < 5) PINGU

ISSO EH TUDO P-PESSOAL
```

## 4. Funções de entrada e saída
```
E LA VAMOS NOS

IO idade PINGU
FLORZINHA altura PINGU
PENELOPE CHARMOSA inicial PINGU

MOSTLA("Digite sua idade: ") PINGU
ESCLEVE(idade) PINGU

MOSTLA("Digite sua altura: ") PINGU
ESCLEVE(altura) PINGU

MOSTLA("Digite sua inicial: ") PINGU
ESCLEVE(inicial) PINGU

MOSTLA("Voce tem ") PINGU
MOSTLA(idade) PINGU
MOSTLA(" anos e ") PINGU
MOSTLA(altura) PINGU
MOSTLA("m de altura") PINGU
MOSTLA("Inicial: ") PINGU
MOSTLA(inicial) PINGU

ISSO EH TUDO P-PESSOAL
```

## 5. Operações e expressões

### Operação aritmética
```
E LA VAMOS NOS
IO a = 10 PINGU
IO b = 5 PINGU
FLORZINHA c = 2.5 PINGU
MOSTLA(a + b) PINGU       
MOSTLA(a - c) PINGU       
MOSTLA(b * 3) PINGU      
MOSTLA(a / 2) PINGU      
MOSTLA((a + b) * c - 1) PINGU  
a += b PINGU
MOSTLA(a) PINGU           
c *= 2 PINGU
MOSTLA(c) PINGU           
ISSO EH TUDO P-PESSOAL
```

### Operação relacional e lógica

```
E LA VAMOS NOS

SID x = A GENTE VAI VIVER PINGU  
SID y = A GENTE VAI MORRER PINGU  
IO n1 = 10 PINGU
IO n2 = 20 PINGU

// Operações relacionais
MOSTLA(n1 < n2) PINGU     
MOSTLA(n1 == 10) PINGU    
MOSTLA(n2 != 20) PINGU    

// Operações lógicas
MOSTLA(x && y) PINGU      
MOSTLA(x || y) PINGU      
MOSTLA(!y) PINGU          

// Combinação
MOSTLA((n1 < n2) && x) PINGU 

ISSO EH TUDO P-PESSOAL
```

## 6. Tratamento de erros

### Exemplo de erro léxico (token inválido)
```
E LA VAMOS NOS
IO x = 123abc PINGU  
ISSO EH TUDO P-PESSOAL
```

### Exemplo de erro sintático (Falta PINGU)
```
E LA VAMOS NOS
IO x = 123  
ISSO EH TUDO P-PESSOAL
```

### Exemplo de erro sintático (condicional mal informado)
```
E LA VAMOS NOS
SERIA (x == 123  
    MOSTLA(x) PINGU
ISSO EH TUDO P-PESSOAL
```
### Exemplo de erro léxico (símbolo inválido)
```
E LA VAMOS NOS
IO x @ 123 PINGU 
ISSO EH TUDO P-PESSOAL
```

### ERRO LEGAL
```
daspdkas.[
```

# Método de sincronização do pânico

### Primeiro mostla errado, segundo válido
```
E LA VAMOS NOS
MOSTLA "Sem parenteses" PINGU
MOSTLA("Depois do erro") PINGU
ISSO EH TUDO P-PESSOAL

```

### Falta pingu
```
E LA VAMOS NOS
IO x = 5 PINGU
FLORZINHA y = 3.14   // <- falta PINGU aqui!
SID z = A GENTE VAI MORRER PINGU
MOSTLA("fim") PINGU
ISSO EH TUDO P-PESSOAL

```

### Expressão vazia
```
E LA VAMOS NOS
YABBA DABBA DOO {
  ESCLEVE(x) PINGU
} A EH REPETE ( ) PINGU
ISSO EH TUDO P-PESSOAL

```

### Operador errado com declaração
```
E LA VAMOS NOS
IO x = 5 PINGU
SID y == TRUE PINGU
FORCA G ( z = 0, z < 10 z = z + 1 ) MOSTLA("loop") PINGU
ESCLEVE(x) PINGU
ISSO EH TUDO P-PESSOAL

```

### Operador não conhecido
```
E LA VAMOS NOS
FORCA G ( x = 1, x < 10, x ++ ) MOSTLA("oi") PINGU
MOSTLA("fim") PINGU
ISSO EH TUDO P-PESSOAL

```

### Operador errado
```
E LA VAMOS NOS
IO x = 5 PINGU
FLORZINHA y == 3.2 PINGU
MOSTLA("oi") PINGU
ISSO EH TUDO P-PESSOAL

```

### Código com IF e expressão booleana inválida
```
E LA VAMOS NOS
SID cond = A GENTE VAI VIVER PINGU
SERIA cond {
  MOSTLA("Condicional ok") PINGU
}
ISSO EH TUDO P-PESSOAL

```

### Código com FOR e erro de sintaxe na expressão final
```
E LA VAMOS NOS
IO i = 0 PINGU
FORCA G (i = 0, i < 10, ) {
  MOSTLA("Iteração") PINGU
}
ISSO EH TUDO P-PESSOAL

```

