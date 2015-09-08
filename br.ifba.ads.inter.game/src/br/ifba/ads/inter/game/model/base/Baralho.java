
package br.ifba.ads.inter.game.model.base;


import java.util.ArrayList;  
import java.util.List;  
import java.util.Collections;

public class Baralho
{
   private List<CartaAtaque> carta;

   
   public Baralho(){
       super();
       this.carta = new ArrayList<CartaAtaque>();
  
    }
   
   /* A classe Baralho foi criada para represenar o conjunto de cartas que cada jogador irá possuir.
    * Os jogadores possuem conjuntos de Cartas diferentes.
    * Alguns dos métodos criados foram para facilitar a aplicação e melhorar legibilidade do código.
    * 
    */

   //METODOS DE APLICAÇÃO
   
   public int getTamanho()
   {
       return this.carta.size();
   }
   
   public void addCarta(CartaAtaque c)
   {
       this.carta.add(c);
    }
   
    
    public void embaralha()
    {
        Collections.shuffle(this.carta);
    }
    
    public void remove(int i)
    {
        this.carta.remove(i);
    }
   
   //METODOS DE ACESSO
    public void setCarta(List<CartaAtaque> carta) {
        
        this.carta = carta;
    }
   
    
   public List<CartaAtaque> getBaralho()
   {
       return this.carta;
    }
  
  public CartaAtaque getCarta(int i)
   {
       return this.carta.get(i);
    }
  
      
}
