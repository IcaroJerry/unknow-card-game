
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.base.CartaAtaque;
import java.util.List;

public interface IDAOBaralho {

    public List<CartaAtaque> retornarBaralho(int cod_jogador)throws Exception;



}
