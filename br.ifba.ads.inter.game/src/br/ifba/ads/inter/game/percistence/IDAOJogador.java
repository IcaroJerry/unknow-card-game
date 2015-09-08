
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import java.util.Set;


public interface IDAOJogador {
    
    
  public void salvarJogador(String campoLogin, String senha, String fraseRecuperacao) throws Exception;
  public LogarJogador carregarJogador(String campoLogin, String senha) throws Exception; 
  public boolean buscaJogador(String jogador) throws Exception;
  public boolean buscaJogador(String jogador, String senha) throws Exception;
  public String buscaFrase(String jogador) throws Exception;
  public void updateSenha (String jogador ,String senha)throws Exception;
  public void updateFrase (String jogador ,String frase)throws Exception;
  public void addVitoria(String jogador)throws Exception;
  
  
    
}
