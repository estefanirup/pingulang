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
    Programa.add(new Integer(pingulangCompilerConstants.EOF));
    //declaraVariavel.add(new Integer(pingulangCompilerConstants.FIM_BLOCO));
    //Declaracao.add(new Integer(PingulangCompilerConstants.))
    }
}
