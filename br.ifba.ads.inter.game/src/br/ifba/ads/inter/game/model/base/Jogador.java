package br.ifba.ads.inter.game.model.base;

import java.util.*;

/* Diferente da classe LOGARJOGADOR, está classe foi designada especialmente para a própria a aplicação da PARTIDA.
* É utilizado "ARRAYLIST" devido melhor eficiencia nas inserções e remoções de objetos (cartas).
*/


public class Jogador{
    
    private String nomeJogador; // De acordo ao nome do Jogador, são os demais atributos.
    private int energiaVital;
    private List<CartaAtaque> cartasMao = new ArrayList<CartaAtaque>();//as cartas da mão do jogador
    private Baralho baralho;    // Um Baralho é uma LISTA de CARTAS

/* CONSTRUTOR de JOGADOR, necessario apenas o NOME (que diferenciará os Jogadores),
* e a ENERGIA VITAL, devido a possibilidade das partidas (as que são de jogos salvo) não inciarem com o padrão(30), 
*/
   public Jogador(String nome, int energia){
        super();
        this.setNomeJogador(nome);
        this.energiaVital = energia;
        this.baralho = new Baralho();
    }

/*Método retira da ENERGIA VITAL os pontos sofrido pelo ATAQUE.*/   
public void golpe(int ataque){ 
  
  this.energiaVital-=ataque;
}
  
  
  /* Método utilizado para realizar a jogada do computador.
   * verifica se o Computador tem alguma carta compatível na mão
   * refente a carta que esta no Campo do jogador UM.
   */
   public CartaAtaque jogadaAutomatica(CartaAtaque cartaCampo)
   {
      CartaAtaque carta = null;
      
       for(int i=0;i<this.getCartasMao().size();i++)
       {   if(cartaCampo.equalsNaipe(this.getCartasMao(i))) // compara as cartas da mão com as do campo
            {carta = this.getCartasMao(i);
             this.getCartasMao().remove(i);
             this.addCartaMao(1);
             break;} 
            // retorna a primeira que achar naipe igual
       }
       
      if(carta == null){
            for(int i=0; i<5; i++){
                this.getBaralho().addCarta(this.getCartasMao(i));
               
             }
              for(int i=0; i<5; i++){
                this.getCartasMao().remove(0);
               
             }
                this.getBaralho().embaralha();
                this.addCartaMao(5);
                
                return this.jogadaAutomatica(cartaCampo);
       }
      return carta;
      }  
     
   public CartaAtaque jogadaAutomatica()
   {
     CartaAtaque carta = this.getCartasMao(0);
             this.getCartasMao().remove(0);
              this.addCartaMao(1);
       return carta;
   }
   
   
public void jogouCarta(int index){
 this.getCartasMao().remove(index);
  
}
/*Método para adicionar cartas na mão, passando como parametro um inteiro Quantidade.
 * Remove a carta do Baralho a medida que adiona as Cartas da Mão do Jogador
 */
public void addCartaMao(int qnt)
{ 
int i;
for(i=0; i<qnt; i++){
    int index = (this.baralho.getTamanho() -1);
    this.cartasMao.add(this.baralho.getCarta(index));//insere c na última posição         
    this.baralho.remove(index);
    }     
} 
  
  
// METODOS DE ACESSO 
  
public int contCartas(){  // metodo não utilizado
   
   return this.baralho.getTamanho();
   
   }
    
public void setEnergiaVital(int energiaVital) {
        this.energiaVital = energiaVital;
    }

public int getEnergiaVital() {
        return this.energiaVital;
    }

public List<CartaAtaque> getCartasMao() { // repetição
        return this.cartasMao;
    }
    
 public CartaAtaque getCartasMao(int index) { // repetição
        return this.cartasMao.get(index);
    }
      
public void setCartasMao(List<CartaAtaque> carta){
        this.cartasMao=carta;
}

public void setCartasMao(CartaAtaque c){
this.cartasMao.add(c);
}
     
public Baralho getBaralho()//retorna o baralho
{
 return this.baralho;
    }
      
public void setNomeJogador(String nome){
this.nomeJogador = nome;
}
    

        
public String getNomeJogador( ){
return this.nomeJogador;
}

    
    
public void setBaralho(Baralho baralho)
{ this.baralho =  baralho;
    }

public int getTamanhoCartasMao(){
   return  this.getCartasMao().size();

}  
    

}