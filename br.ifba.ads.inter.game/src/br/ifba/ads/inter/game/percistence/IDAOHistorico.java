
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.appGame.Partida;
import br.ifba.ads.inter.game.model.base.Baralho;
import br.ifba.ads.inter.game.model.appGame.JogosSalvo;
import java.util.List;

public interface IDAOHistorico {
    
   public void salveJogo(JogosSalvo dado) throws Exception;
   public int countJogosSalvos(String jogador) throws Exception;
   public List<JogosSalvo> retornaJogoSalvo(String login) throws Exception;
   
   public Partida retornaDadosJogoSalvo(String save, String login) throws Exception;
   
}
