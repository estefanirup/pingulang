# 🐧 Pingulang

PinguLang é um compilador em desenvolvimento baseado no JavaCC, com análise léxica/sintática e mensagens de erro em português. Suporta estruturas de controle (while, for, do-while, if-else), declaração de variáveis (com ou sem atribuição) e cinco tipos de dados: inteiro, flutuante, booleano, char e string. 

Dentre as limitações deste compilador, inclui-se a falta de suporte a funções definidas pelo usuário, falta de estruturas de dados complexas(arrays e registros), dentre outros.

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

Última coisa, Nossa BFN está aqui, caso dê para dar uma olhada
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
