package recovery;

import java.util.*;

public class Follow {
    
    public static final RecoverySet Programa = new RecoverySet();
    public static final RecoverySet Declaracao = new RecoverySet();
    public static final RecoverySet ListaVariaveis = new RecoverySet();
    public static final RecoverySet Comando = new RecoverySet();
    public static final RecoverySet ComandoID = new RecoverySet();
    public static final RecoverySet Atribuicao = new RecoverySet();
    public static final RecoverySet Condicional = new RecoverySet();
    public static final RecoverySet Repeticao = new RecoverySet();
    public static final RecoverySet While = new RecoverySet();
    public static final RecoverySet For = new RecoverySet();
    public static final RecoverySet DoWhile = new RecoverySet();
    public static final RecoverySet EntradaSaida = new RecoverySet();
    public static final RecoverySet Bloco = new RecoverySet();
    public static final RecoverySet Expressao = new RecoverySet();
    public static final RecoverySet ExpressaoLogica = new RecoverySet();
    public static final RecoverySet ExpressaoRelacional = new RecoverySet();
    public static final RecoverySet ExpressaoAritmetica = new RecoverySet();
    public static final RecoverySet Termo = new RecoverySet();
    public static final RecoverySet Fator = new RecoverySet();

    static {
        // Programa → ... FIM_PROGRAMA
        Programa.add(source.pingulangCompilerConstants.FIM_PROGRAMA);

        // Declaracao → pode vir outra Declaracao, Comando ou FIM_PROGRAMA
        Declaracao.add(source.pingulangCompilerConstants.INT_TYPE);
        Declaracao.add(source.pingulangCompilerConstants.FLOAT_TYPE);
        Declaracao.add(source.pingulangCompilerConstants.BOOL_TYPE);
        Declaracao.add(source.pingulangCompilerConstants.CHAR_TYPE);
        Declaracao.add(source.pingulangCompilerConstants.IF);
        Declaracao.add(source.pingulangCompilerConstants.WHILE);
        Declaracao.add(source.pingulangCompilerConstants.FOR);
        Declaracao.add(source.pingulangCompilerConstants.DO);
        Declaracao.add(source.pingulangCompilerConstants.ID);
        Declaracao.add(source.pingulangCompilerConstants.PRINT);
        Declaracao.add(source.pingulangCompilerConstants.INPUT);
        Declaracao.add(source.pingulangCompilerConstants.INICIO_BLOCO);
        Declaracao.add(source.pingulangCompilerConstants.FIM_PROGRAMA);

        // ListaVariaveis → FimLinha
        ListaVariaveis.add(source.pingulangCompilerConstants.PINGU);

        // Comando → pode vir outro comando, fim de programa ou fim de bloco
        Comando.add(source.pingulangCompilerConstants.FIM_PROGRAMA);
        Comando.add(source.pingulangCompilerConstants.FIM_BLOCO);

        // ComandoID → mesmo Follow de Comando
        ComandoID.union(Comando);

        // Atribuicao → pode estar em ListaVariaveis (virgula), FimLinha ou dentro de for (fecha parênteses)
        Atribuicao.add(source.pingulangCompilerConstants.PINGU);
        Atribuicao.add(source.pingulangCompilerConstants.VIRGULA);
        Atribuicao.add(source.pingulangCompilerConstants.FECHA_PARENTESES);

        // Condicional → depois vem outro Comando
        Condicional.union(Comando);

        // Repetição → igual
        Repeticao.union(Comando);
        While.union(Comando);
        For.union(Comando);
        DoWhile.union(Comando);

        // EntradaSaida → seguido de FimLinha
        EntradaSaida.add(source.pingulangCompilerConstants.PINGU);

        // Bloco → mesma lógica do comando
        Bloco.union(Comando);

        // Expressões
        Expressao.add(source.pingulangCompilerConstants.FECHA_PARENTESES);
        Expressao.add(source.pingulangCompilerConstants.PINGU);

        ExpressaoLogica.union(Expressao);
        ExpressaoRelacional.union(ExpressaoLogica);
        ExpressaoRelacional.add(source.pingulangCompilerConstants.OP_LOGICO);

        ExpressaoAritmetica.union(ExpressaoRelacional);
        ExpressaoAritmetica.add(source.pingulangCompilerConstants.OP_RELACIONAL);

        Termo.union(ExpressaoAritmetica);
        Termo.add(source.pingulangCompilerConstants.OP_ARITMETICO);

        Fator.union(Termo);
    }
}
