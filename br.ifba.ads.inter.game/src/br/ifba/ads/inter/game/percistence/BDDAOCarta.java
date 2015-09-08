
package br.ifba.ads.inter.game.percistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BDDAOCarta implements IDAOCarta {
    
    
    private final String bd = ConexaoBanco.getEnderecoBanco();
    private Connection conn;
    

   private PreparedStatement pStmt;	
   private ResultSet rSet;
    
    public BDDAOCarta( ) throws Exception{ 
    Class.forName(ConexaoBanco.getNomeClasseBanco()).newInstance();
    }  
    
    
    
}
