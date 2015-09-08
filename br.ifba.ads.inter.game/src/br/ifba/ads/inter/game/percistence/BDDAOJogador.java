
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;


public class BDDAOJogador implements IDAOJogador{
 
    private final String bd = ConexaoBanco.getEnderecoBanco();
    private Connection conn;
    

   private PreparedStatement pStmt;	
   private ResultSet rSet;
    
    public BDDAOJogador( ) throws Exception{ 
    Class.forName(ConexaoBanco.getNomeClasseBanco()).newInstance();
    }  

    @Override
    public void salvarJogador(String campoLogin, String senha, String fraseRecuperacao) throws Exception{
    
    String comandoSQL = "insert into cadastro_jogador (login,senha,frase_recuperacao,cont_vitorias) values (?,?,?,?)";
    
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL);
  
    pStmt.setString(1, campoLogin);
    pStmt.setString(2, senha);
    pStmt.setString(3, fraseRecuperacao);
    pStmt.setInt(4, 0);
    pStmt.executeUpdate();  
    
                this.rSet.close();
		this.pStmt.close();
		this.conn.close();
    
    }
    
//    @Override
//    public LogarJogador carregarJogador(String campoLogin, String senha) throws Exception{
//    LogarJogador  p = null;
//    
//    String comandoSQL = "select * from cadastro_jogador where login = ? And senha = ?";
//    
//    this.conn = DriverManager.getConnection(bd); 
//    this.pStmt = conn.prepareStatement(comandoSQL);
//    
//    pStmt.setString(1, campoLogin);
//    pStmt.setString(2, senha);
//    
//    if(rSet.next()){
//			p = new LogarJogador();
//			p.setLogin(this.rSet.getString("login"));
//			p.setSenha(this.rSet.getString("senha"));
//			p.setFrase(this.rSet.getString("frase_recuperacao"));
//                        p.setCont(this.rSet.getInt("cont_vitorias"));
//    }
//		else
//			throw new Exception(); // jogador não existe
//                
//    this.rSet.close();
//    this.pStmt.close();
//    this.conn.close();
//   
//   return p;
//    }
    
    @Override
    public LogarJogador carregarJogador(String campoLogin, String senha) throws Exception{
    
	LogarJogador p = new LogarJogador();
	p.setLogin("teste");
	p.setSenha("1234");
	p.setFrase("teste, 1234");
        p.setCont(0);
   
        return p;
    }

    @Override
    public boolean buscaJogador(String jogador) throws Exception {  // se true jogador existe
    
   String comandoSQL="SELECT login FROM cadastro_jogador WHERE login = ?";
    
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL);
    
    pStmt.setString(1, jogador);  
    this.rSet = this.pStmt.executeQuery();  
    jogador = null; // transforma jogador como null.
    while(rSet.next()) {  
    jogador = rSet.getString("Login");  
    }  
                this.rSet.close();
		this.pStmt.close();
		this.conn.close();
                
if(jogador == null)
    return false;
else
    return true;
                
}

    @Override
    public boolean buscaJogador(String jogador, String senha) throws Exception {  // se true jogador existe
    
   String comandoSQL="SELECT login FROM cadastro_jogador WHERE login = ? AND senha = ?";
    
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL);
    
    pStmt.setString(1, jogador);  
    pStmt.setString(2, senha);  
    this.rSet = this.pStmt.executeQuery();  
    jogador = null; // transforma jogador como null.
    while(rSet.next()) {  
    jogador = rSet.getString("Login");  
    }  
                this.rSet.close();
		this.pStmt.close();
		this.conn.close();
             
if(jogador == null)
    return true;
else
    return false;
                
}

    @Override
    public String buscaFrase(String jogador) throws Exception {  
    
   String comandoSQL="SELECT * FROM cadastro_jogador WHERE login = ?";
     
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    
    pStmt.setString(1, jogador);  
    this.rSet = this.pStmt.executeQuery();
    String frase = null;
    
    while(rSet.next()) {  
    frase = rSet.getString("frase_recuperacao");  
    }  

    this.rSet.close();  
    this.pStmt.close();  
    this.conn.close(); 

return frase;  
}  
    
    @Override
    public void updateFrase (String jogador, String frase)throws Exception {
   String comandoSQL="UPDATE cadastro_jogador SET frase_recuperacao = ?  WHERE login = ?";
     
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    
    pStmt.setString(1, frase); 
    pStmt.setString(2, jogador);  
    pStmt.executeUpdate();  
    
                this.rSet.close();
		this.pStmt.close();
		this.conn.close();


         
     }
     
    @Override
    public void updateSenha (String jogador ,String senha)throws Exception {
    String comandoSQL="UPDATE cadastro_jogador SET Senha = ?  WHERE login = ?";
     
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    
    pStmt.setString(1, senha);  
    pStmt.setString(2, jogador);  
    pStmt.executeUpdate();  
    
                this.rSet.close();
		this.pStmt.close();
		this.conn.close();


         
     }
    
    @Override
    public void addVitoria (String jogador)throws Exception {
   String comandoSQL="UPDATE cadastro_jogador SET cont_vitorias = cont_vitorias+1  WHERE login = ?";
     
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    
    pStmt.setString(1, jogador);  
    pStmt.executeUpdate();  
    

		this.pStmt.close();
		this.conn.close();


         
     }
    
  
   
}
