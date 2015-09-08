
package br.ifba.ads.inter.game.percistence;


public class ConexaoBanco {
 
    private static final String enderecoBanco= "jdbc:sqlserver://localhost:1433; databaseName=interdisciplinar;integratedSecurity=true;";
    private static final String nomeClasseBanco = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    
    public static String getEnderecoBanco() {
        return enderecoBanco;
    }

    public static String getNomeClasseBanco() {
        return nomeClasseBanco;
    }
    
    
    
}
