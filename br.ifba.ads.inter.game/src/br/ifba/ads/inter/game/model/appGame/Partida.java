
package br.ifba.ads.inter.game.model.appGame;

import br.ifba.ads.inter.game.model.base.Baralho;
import br.ifba.ads.inter.game.model.base.Carta;
import br.ifba.ads.inter.game.model.base.CartaAtaque;
import br.ifba.ads.inter.game.model.base.Jogador;
import br.ifba.ads.inter.game.percistence.BDDAOBaralho;
import br.ifba.ads.inter.game.percistence.IDAOBaralho;



public class Partida {
    
protected IDAOBaralho bancoBaralho;

private Jogador playUM;
private Jogador playDOIS;

private CartaAtaque campoUM = null;
private CartaAtaque campoDOIS = null;

private String cartaJogada = null;


int etapa;

  
/*A Classe Partida possui 3 tipos diferentes de Construtores
 * Para determinados tipos de operações distintas.
 * 1ª - Para inicia uma partida do inicio.
 * 2² - Para iniciar uma partida salvo no banco.
 * 3ª - Recuperar o historico do banco das Tabelas referente ao jogador.
 */
public Partida(String login)throws Exception { // PRIMEIRA
    this.bancoBaralho = new BDDAOBaralho();   
    this.setPlayUM(new Jogador(login,30));
    this.setPlayDOIS(new Jogador("COMPUTER",30));
    
    this.iniciaBaralho();
    // incializa os baralhos a serem usados pelos jogadores e atribue cada um ao seu.
    ////////////////////////////////// NESCESSARIO CONCERTAR AS ETAPAS!
    this.setEtapa(0); 
}


public Partida(Jogador UM, Jogador DOIS )throws Exception { // SEGUNDA

    this.setPlayUM(UM);
    this.setPlayDOIS(DOIS);
}


public Partida(Jogador login)throws Exception { //TERCEIRA

    this.setPlayUM(login);
}



 private void iniciaBaralho() throws Exception{   
    
    
    this.getPlayUM().getBaralho().setCarta(this.bancoBaralho.retornarBaralho(1));
    this.getPlayDOIS().getBaralho().setCarta(this.bancoBaralho.retornarBaralho(2));
    
    this.getPlayUM().getBaralho().embaralha();
    this.getPlayDOIS().getBaralho().embaralha();
    
    this.getPlayUM().addCartaMao(0);
    this.getPlayDOIS().addCartaMao(5);
    
 }

 /*O Método isNotNULL verifica se possui algum dado na Carta passado por parâmetro.
  * Retorna true caso nao esteja nulo.
  * Retorna false caso a Carta seja nulo.
  */
 
 
    public Boolean isNotNULL(CartaAtaque carta){
        if(carta== null) return false;
        else return true;
    
    }

/*Metodo mensagensJogada refere-se as mensagens relacionadas a cada etapa da partida.*/
  public String mensagensJogada(int etapas){
 
        switch (etapas){
        
            case 0:{return "- O Jogo começou!\n- Clique no seu baralho para pegar as cartas!\n- Boa Sorte!";}
            
            case 1:{return "- Para continuar a jogar, pegue ao menos uma carta!";}
                    
           case 2:{return "- Agora escolha entre as Cartas que possui na mão\n E faça sua jogada!";}
                
           case 3:{return "- Você jogou uma carta!\n- Vez do(a) "+this.getPlayDOIS().getNomeJogador()+"!\n- Aguarde sua vez!"; }
            
           case 4:{return " O JOGADOR " +this.getPlayDOIS().getNomeJogador()+" fez sua jogada!"; }
           
           case 5:{return "FIM DA RODADA"; }
           
           case 6:{return "O JOGADOR " +this.getPlayDOIS().getNomeJogador()+" fez seu ataque!"; }
           
           case 7:{return "Sua vez de defender! Escolha entre as Cartas que possui na mão\n E faça sua jogada!"; }   
          
           case 8:{return "FIM DA RODADA"; }
               
           case 9:{return "FIM DA RODADA"; }
           default: {return "Erro no Jogo";}
        }
 }


//METODOS DE ACESSO

    public void setPlayUM(Jogador playUM) {
        this.playUM = playUM;
    }

  

    public void setCampoUM(CartaAtaque campoUM) {
        this.campoUM = campoUM;
    }

    public void setCampoDOIS(CartaAtaque campoDOIS) {
        this.campoDOIS = campoDOIS;
    }

    public void setCartaJogada(String cartaJogada) {
        this.cartaJogada = cartaJogada;
    }


    public Jogador getPlayDOIS() {
        return playDOIS;
    }

 

    public CartaAtaque getCampoUM() {
        return campoUM;
    }

    public CartaAtaque getCampoDOIS() {
        return campoDOIS;
    }

    public String getCartaJogada() {
        return cartaJogada;
    }

    public void setPlayDOIS(Jogador playDOIS) {
        this.playDOIS = playDOIS;
    }

    public Jogador getPlayUM() {
        return playUM;
    }
    
  public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }
    
    
}
