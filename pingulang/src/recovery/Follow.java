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
    	
        // Programa termina com FIM_PROGRAMA
        Programa.add(source.pingulangCompilerConstants.FIM_PROGRAMA);

        // Declaracoes seguidas por comandos ou fim
        Declaracao.add(source.pingulangCompilerConstants.IF);
        Declaracao.add(source.pingulangCompilerConstants.FOR);
        Declaracao.add(source.pingulangCompilerConstants.WHILE);
        Declaracao.add(source.pingulangCompilerConstants.DO);
        Declaracao.add(source.pingulangCompilerConstants.ID);
        Declaracao.add(source.pingulangCompilerConstants.PRINT);
        Declaracao.add(source.pingulangCompilerConstants.INPUT);
        Declaracao.add(source.pingulangCompilerConstants.INICIO_BLOCO);
        Declaracao.add(source.pingulangCompilerConstants.FIM_PROGRAMA); // pode haver só declaração

        // Lista de variáveis termina em <PINGU>
        ListaVariaveis.add(source.pingulangCompilerConstants.PINGU);

        // Comandos ocorrem em sequência ou dentro de blocos
        Comando.add(source.pingulangCompilerConstants.FIM_BLOCO);
        Comando.add(source.pingulangCompilerConstants.IF);
        Comando.add(source.pingulangCompilerConstants.FOR);
        Comando.add(source.pingulangCompilerConstants.WHILE);
        Comando.add(source.pingulangCompilerConstants.DO);
        Comando.add(source.pingulangCompilerConstants.ID);
        Comando.add(source.pingulangCompilerConstants.PRINT);
        Comando.add(source.pingulangCompilerConstants.INPUT);
        Comando.add(source.pingulangCompilerConstants.FIM_PROGRAMA);

        // Atribuições são seguidas por PINGU
        Atribuicao.add(source.pingulangCompilerConstants.PINGU);

        // Condicional pode ser seguida por outro comando ou fim de bloco
        Condicional.add(source.pingulangCompilerConstants.FIM_BLOCO);
        Condicional.add(source.pingulangCompilerConstants.IF);
        Condicional.add(source.pingulangCompilerConstants.FOR);
        Condicional.add(source.pingulangCompilerConstants.WHILE);
        Condicional.add(source.pingulangCompilerConstants.DO);
        Condicional.add(source.pingulangCompilerConstants.ID);
        Condicional.add(source.pingulangCompilerConstants.PRINT);
        Condicional.add(source.pingulangCompilerConstants.INPUT);
        Condicional.add(source.pingulangCompilerConstants.ABRE_PARENTESES);
        Condicional.add(source.pingulangCompilerConstants.FIM_PROGRAMA);

        // Repetição mesmo caso do condicional
        Repeticao.addAll(Condicional);

        While.addAll(Condicional);
        For.addAll(Condicional);
        DoWhile.addAll(Condicional);

        EntradaSaida.add(source.pingulangCompilerConstants.PINGU);

        Bloco.addAll(Condicional);

        // Expressões
        Expressao.add(source.pingulangCompilerConstants.FECHA_PARENTESES);
        Expressao.add(source.pingulangCompilerConstants.PINGU);
        Expressao.add(source.pingulangCompilerConstants.VIRGULA);

        ExpressaoLogica.addAll(Expressao);
        ExpressaoRelacional.addAll(Expressao);
        ExpressaoAritmetica.addAll(Expressao);
        Termo.addAll(Expressao);
        Fator.addAll(Expressao);
    }
}

