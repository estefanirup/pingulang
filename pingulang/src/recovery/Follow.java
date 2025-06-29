package recovery;

import source.*;

public class Follow { //implementa os conjuntos first p/ alguns n.terminais

    static public final RecoverySet Programa = new RecoverySet();
    static public final RecoverySet Declaracao = new RecoverySet();
    static public final RecoverySet ListaVariaveis = new RecoverySet();
    static public final RecoverySet Variavel = new RecoverySet();
    static public final RecoverySet Comando = new RecoverySet();
    static public final RecoverySet Atribuicao = new RecoverySet();
    static public final RecoverySet Condicional = new RecoverySet();
    static public final RecoverySet Repeticao = new RecoverySet();
    static public final RecoverySet While = new RecoverySet();
    static public final RecoverySet For = new RecoverySet(); 
    static public final RecoverySet DoWhile = new RecoverySet();
    static public final RecoverySet EntradaSaida = new RecoverySet();
    static public final RecoverySet Bloco = new RecoverySet();	
    static public final RecoverySet Expressao = new RecoverySet();
    static public final RecoverySet ExpressaoLogica = new RecoverySet();
    static public final RecoverySet ExpressaoRelacional = new RecoverySet();
    static public final RecoverySet ExpressaoAritmetica = new RecoverySet();
    static public final RecoverySet Termo = new RecoverySet();
    static public final RecoverySet Fator = new RecoverySet();

    static {
    	
    	// Programa -> termina com FIM_PROGRAMA
        Programa.add(pingulangCompilerConstants.FIM_PROGRAMA);

        // Declaracao -> pode ser seguida por outra declaracao ou por um comando
        Declaracao.add(pingulangCompilerConstants.INT_TYPE);
        Declaracao.add(pingulangCompilerConstants.FLOAT_TYPE);
        Declaracao.add(pingulangCompilerConstants.BOOL_TYPE);
        Declaracao.add(pingulangCompilerConstants.CHAR_TYPE);
        Declaracao.add(pingulangCompilerConstants.IF);
        Declaracao.add(pingulangCompilerConstants.WHILE);
        Declaracao.add(pingulangCompilerConstants.FOR);
        Declaracao.add(pingulangCompilerConstants.DO);
        Declaracao.add(pingulangCompilerConstants.ID);
        Declaracao.add(pingulangCompilerConstants.PRINT);
        Declaracao.add(pingulangCompilerConstants.INPUT);
        Declaracao.add(pingulangCompilerConstants.INICIO_BLOCO);
        Declaracao.add(pingulangCompilerConstants.FIM_PROGRAMA);

        // ListaVariaveis -> finalizada por PINGU
        ListaVariaveis.add(pingulangCompilerConstants.PINGU);

        // Variavel -> usada em declaracao ou atribuicao, seguida por PINGU
        Variavel.add(pingulangCompilerConstants.PINGU);

        // Comando -> pode ser seguido por outro comando ou fim de bloco
        Comando.add(pingulangCompilerConstants.FIM_BLOCO);
        Comando.add(pingulangCompilerConstants.IF);
        Comando.add(pingulangCompilerConstants.WHILE);
        Comando.add(pingulangCompilerConstants.FOR);
        Comando.add(pingulangCompilerConstants.DO);
        Comando.add(pingulangCompilerConstants.ID);
        Comando.add(pingulangCompilerConstants.PRINT);
        Comando.add(pingulangCompilerConstants.INPUT);
        Comando.add(pingulangCompilerConstants.INICIO_BLOCO);
        Comando.add(pingulangCompilerConstants.FIM_PROGRAMA);

        // Atribuicao -> finalizada por PINGU
        Atribuicao.add(pingulangCompilerConstants.PINGU);

        // Condicional -> seguida por outro comando
        Condicional.add(pingulangCompilerConstants.FIM_BLOCO);
        Condicional.add(pingulangCompilerConstants.IF);
        Condicional.add(pingulangCompilerConstants.WHILE);
        Condicional.add(pingulangCompilerConstants.FOR);
        Condicional.add(pingulangCompilerConstants.DO);
        Condicional.add(pingulangCompilerConstants.ID);
        Condicional.add(pingulangCompilerConstants.PRINT);
        Condicional.add(pingulangCompilerConstants.INPUT);
        Condicional.add(pingulangCompilerConstants.INICIO_BLOCO);
        Condicional.add(pingulangCompilerConstants.FIM_PROGRAMA);

        // Repeticao → mesma lógica de condicional
        Repeticao.addAll(Condicional);

        // While, For, DoWhile → comandos subsequentes
        While.addAll(Condicional);
        For.addAll(Condicional);
        DoWhile.addAll(Condicional);

        // EntradaSaida → seguida de PINGU
        EntradaSaida.add(pingulangCompilerConstants.PINGU);

        // Bloco → pode ser seguido por outro comando ou fim de bloco
        Bloco.addAll(Comando);

        // Expressões (ocorrem em vários contextos, difícil prever tudo)
        Expressao.add(pingulangCompilerConstants.PINGU);
        //Expressao.add(pingulangCompilerConstants.FECHA_PARENTESES); // se usada em "( Expressao )"
        ExpressaoLogica.addAll(Expressao);
        ExpressaoRelacional.addAll(ExpressaoLogica);
        ExpressaoAritmetica.addAll(ExpressaoRelacional);
        Termo.addAll(ExpressaoAritmetica);
        Fator.addAll(Termo);
    }
}
