
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class BDDAOWindows implements IDAOWindows{
    
     
    private final String bd = ConexaoBanco.getEnderecoBanco();
    private Connection conn;
    

   private PreparedStatement pStmt;	
   private ResultSet rSet;
    
    public BDDAOWindows( ) throws Exception{ 
    Class.forName(ConexaoBanco.getNomeClasseBanco()).newInstance();
    }  
    
    
    @Override
  public List<LogarJogador> atualizarRank() throws Exception{
  
      List<LogarJogador> jogadores = new ArrayList<LogarJogador>();
      
      String comandoSQL="SELECT * FROM cadastro_jogador ORDER BY cont_Vitorias DESC";
      int i=0;
      
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    
    this.rSet = this.pStmt.executeQuery(); 
    
    while(rSet.next()&& i<4) {
        jogadores.add(new LogarJogador(rSet.getString("Login"),rSet.getInt("cont_vitorias")));

    i++;
    }  

        this.rSet.close();   
        this.pStmt.close();  
        this.conn.close();
        
        return jogadores;

  }
    
}
