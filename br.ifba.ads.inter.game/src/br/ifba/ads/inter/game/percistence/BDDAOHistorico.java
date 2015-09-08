
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.appGame.Partida;
import br.ifba.ads.inter.game.model.base.Baralho;
import br.ifba.ads.inter.game.model.base.CartaAtaque;
import br.ifba.ads.inter.game.model.base.Jogador;
import br.ifba.ads.inter.game.model.appGame.JogosSalvo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BDDAOHistorico implements IDAOHistorico{
    
     
    private final String bd = ConexaoBanco.getEnderecoBanco();
    private Connection conn;
    

   private PreparedStatement pStmt;	
   private ResultSet rSet;
    
    public BDDAOHistorico( ) throws Exception{ 
    Class.forName(ConexaoBanco.getNomeClasseBanco()).newInstance();
    }  
  
  
  
       @Override
    public void salveJogo(JogosSalvo dado) throws Exception{
    
    String comandoSQL="INSERT INTO  jogos_salvos (save_game, login, energia_1, login_adversario, energia_2,isCampo,isCampo_adversario,etapa) VALUES (?,?,?,?,?,?,?,?)";
   
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL);
  
    pStmt.setString(1, dado.getNome());
    pStmt.setString(2, dado.getPartida().getPlayUM().getNomeJogador());
    pStmt.setInt(3, dado.getPartida().getPlayUM().getEnergiaVital());
    pStmt.setString(4, dado.getPartida().getPlayDOIS().getNomeJogador());
    pStmt.setInt(5, dado.getPartida().getPlayDOIS().getEnergiaVital());
    pStmt.setString(6, dado.getPartida().isNotNULL(dado.getPartida().getCampoUM()).toString());
    pStmt.setString(7, dado.getPartida().isNotNULL(dado.getPartida().getCampoDOIS()).toString());
    pStmt.setInt(8, dado.getPartida().getEtapa());
    pStmt.executeUpdate();  
		this.pStmt.close();
                
    comandoSQL= "INSERT INTO Historico_Fogo (cod_carta, naipe, ataque, distancia, save_game, login)VALUES (?,?,?,?,?,?)";            
      
    this.pStmt = conn.prepareStatement(comandoSQL);
    
    for (int i = 0; i < dado.getPartida().getPlayUM().getBaralho().getTamanho(); i++) {  
    pStmt.setString(1,dado.getPartida().getPlayUM().getBaralho().getCarta(i).getCodCarta());
    pStmt.setString(2, dado.getPartida().getPlayUM().getBaralho().getCarta(i).getNaipe());
    pStmt.setInt(3, dado.getPartida().getPlayUM().getBaralho().getCarta(i).getAtaque());
    pStmt.setInt(4, dado.getPartida().getPlayUM().getBaralho().getCarta(i).getDistancia());
    pStmt.setString(5,dado.getNome());
    pStmt.setString(6,dado.getPartida().getPlayUM().getNomeJogador());
    pStmt.executeUpdate();  
    }

		this.pStmt.close();
                
    comandoSQL= "INSERT INTO Historico_Agua (cod_carta, naipe, ataque, distancia, save_game, login)VALUES (?,?,?,?,?,?)";            
    this.pStmt = conn.prepareStatement(comandoSQL);
    
    for (int i = 0; i < dado.getPartida().getPlayDOIS().getBaralho().getTamanho(); i++) {  
    pStmt.setString(1,dado.getPartida().getPlayDOIS().getBaralho().getCarta(i).getCodCarta());
    pStmt.setString(2, dado.getPartida().getPlayDOIS().getBaralho().getCarta(i).getNaipe());
    pStmt.setInt(3, dado.getPartida().getPlayDOIS().getBaralho().getCarta(i).getAtaque());
    pStmt.setInt(4, dado.getPartida().getPlayDOIS().getBaralho().getCarta(i).getDistancia());
    pStmt.setString(5,dado.getNome());
    pStmt.setString(6,dado.getPartida().getPlayUM().getNomeJogador());
    pStmt.executeUpdate();  
    }

		this.pStmt.close();         
                this.conn.close();

    }
 
   
    @Override
    public List<JogosSalvo> retornaJogoSalvo(String login) throws Exception{
      
     List<JogosSalvo> dados =  new ArrayList<JogosSalvo>(); 
       
      String comandoSQL="SELECT * FROM jogos_salvos Where login = ? ";
  
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL); 
    this.pStmt.setString(1, login);
    
    this.rSet = this.pStmt.executeQuery();
    while(rSet.next()) {  
                 
                      dados.add(new JogosSalvo( this.rSet.getString("save_game"),
                                                this.rSet.getDate("data"),
                                                new Partida(new Jogador(this.rSet.getString("login"),this.rSet.getInt("energia_1")))                     
                                                )
                              );
                        }  
 		this.rSet.close();
		this.pStmt.close();
		this.conn.close();
		
      return  dados;
 
    } 
    
    
    
      @Override
   public int countJogosSalvos(String jogador) throws Exception{
    
    String comandoSQL="SELECT * FROM jogos_salvos Where login = ?";
    int qnt=0;
    
    this.conn = DriverManager.getConnection(bd); 
    this.pStmt = conn.prepareStatement(comandoSQL);
    pStmt.setString(1, jogador); 
    
    
    this.rSet = this.pStmt.executeQuery(); 
    while(rSet.next()) {  
    qnt++;
    } 
    
                
    this.rSet.close();
		this.pStmt.close();
		this.conn.close();
          
    return qnt;
    }
    
  
    @Override
   public Partida retornaDadosJogoSalvo(String save,String login) throws Exception{
   
       Partida partida = null;
       Baralho baralho =  new Baralho();
       Boolean UM = false;
       Boolean DOIS = false;
       
        String comandoSQL="SELECT * FROM jogos_salvos Where save_game = ? AND login = ?";
  
       this.conn = DriverManager.getConnection(bd); 
       this.pStmt = conn.prepareStatement(comandoSQL); 
       this.pStmt.setString(1, save);
       this.pStmt.setString(2, login);
       
        this.rSet = this.pStmt.executeQuery();
        while(rSet.next()) {  
                            partida = new Partida(new Jogador(this.rSet.getString("login"),this.rSet.getInt("energia_1")),
                                                      new Jogador(this.rSet.getString("login_adversario"),this.rSet.getInt("energia_2")));
                            partida.setEtapa(this.rSet.getInt("etapa"));
                            UM = this.rSet.getBoolean("isCampo");
                            DOIS = this.rSet.getBoolean("isCampo_adversario");
        }  
 		this.rSet.close();
		this.pStmt.close();
          
        int i =0; //
               
          comandoSQL="select * from Historico_Agua  Where login = ? AND save_game = ?";
          
          this.conn = DriverManager.getConnection(bd); 
          this.pStmt = conn.prepareStatement(comandoSQL); 
          this.pStmt.setString(1, login);
          this.pStmt.setString(2, save);
          this.rSet = this.pStmt.executeQuery();
          while(rSet.next()) {  
                   
                      baralho.addCarta( new CartaAtaque(this.rSet.getString("cod_carta"),this.rSet.getString("naipe"),
                                            this.rSet.getInt("distancia"),this.rSet.getInt("ataque")));		
                        }
          
                 
          this.rSet.close();
	  this.pStmt.close();
	
        
         partida.getPlayDOIS().setBaralho(baralho);
         
         baralho =  new Baralho();
          
           this.conn = DriverManager.getConnection(bd); 
           this.pStmt = conn.prepareStatement(comandoSQL);  
           
           
          comandoSQL="select * from Historico_Fogo  Where login = ? AND save_game = ?";
          this.conn = DriverManager.getConnection(bd); 
          this.pStmt = conn.prepareStatement(comandoSQL); 
          this.pStmt.setString(1, login);
          this.pStmt.setString(2, save);
          this.rSet = this.pStmt.executeQuery();
          while(rSet.next()) {  
                   
                      baralho.addCarta( new CartaAtaque(this.rSet.getString("cod_carta"),this.rSet.getString("naipe"),
                                            this.rSet.getInt("distancia"),this.rSet.getInt("ataque")));
			
                        }
          
          this.rSet.close();
	  this.pStmt.close();
		
          partida.getPlayUM().setBaralho(baralho);
	  
          if(UM){partida.setCampoUM(partida.getPlayUM().getBaralho().getCarta(partida.getPlayUM().getBaralho().getTamanho()-1));
                 partida.getPlayUM().getBaralho().remove(partida.getPlayUM().getBaralho().getTamanho()-1);
                }
          
          if(DOIS){partida.setCampoDOIS(partida.getPlayDOIS().getBaralho().getCarta(partida.getPlayDOIS().getBaralho().getTamanho()-1));
                 partida.getPlayDOIS().getBaralho().remove(partida.getPlayDOIS().getBaralho().getTamanho()-1);
                }
          
          this.conn.close();
                
                
       return partida;

   } 

}
