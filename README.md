# 🐧 Pingulang - Exemplos Usados na Apresentação

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
IO var = 10 PINGU

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

### 6. Tratamento de erros

## Exemplo de erro léxico (token inválido)
```
E LA VAMOS NOS
IO x = 123abc PINGU  
ISSO EH TUDO P-PESSOAL
```

## Exemplo de erro sintático (Falta PINGU)
```
E LA VAMOS NOS
IO x = 123  
ISSO EH TUDO P-PESSOAL
```

## Exemplo de erro sintático (condicional mal informado)
```
E LA VAMOS NOS
SERIA (x == 123  
    MOSTLA(x) PINGU
ISSO EH TUDO P-PESSOAL
```
## Exemplo de erro léxico (símbolo inválido)
```
E LA VAMOS NOS
IO x @ 123 PINGU 
ISSO EH TUDO P-PESSOAL
```
