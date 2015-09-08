
package br.ifba.ads.inter.game.model.base;

import br.ifba.ads.inter.game.model.base.Carta;
import br.ifba.ads.inter.game.model.exception.ExcecaoCarta;

/* Carta Atatque é um "tipo de" Carta, possuindo um atributo a mais,
 * o Ataque é o atributo pelo qual a Carta vai batalhar e descobrir a vencedora,
 * O ataque só pode ser calculado depois das outras verificações anteriores, segundo a regra
 * do Jogo.
 */  


public class CartaAtaque extends Carta
{
   private int ataque;
   public CartaAtaque(String cod_carta, String naipe_carta, int distancia, int ataque){
    super(cod_carta, naipe_carta, distancia); // Logo para criar uma Carta Ataque precisa dos mesmos
                                              // atributos de uma Carta.
    this.setAtaque(ataque);
    
   }
 

   
  /*Método verifica se a Carta é vencedora,
  * caso a carta que está sendo comparada for a vencedora,
  * retorna true.
  */
  public boolean isWinner(CartaAtaque outra) throws ExcecaoCarta
  {
    CartaAtaque vencedora;
    vencedora = this.ataqueCarta(outra); // Chamada de outro médoto que vefica o Ataque.
       
   
    if(vencedora.equals(this)) // metodos equals compara se o objeto eh igual a ele mesmo
    {return true;}
    
    else
    {return false;}
  
       
 
   
  } 
  /*verificaGolpe retornar um inteiro que é a difereça do ataque da carta vencedora por a que perdeu.
   Caso a carta adversaria não possa se defender, retorna o ataque total da vencedora.
   */
  
  public int verificaGolpe(CartaAtaque outra){
  
     if(outra.verificaDistancia(this)) // se a outra puder se defender.   
         return this.getAtaque()- outra.getAtaque();
     else    
         return this.getAtaque();
  
  }
  
   
   /* SE RETORNA NULL - NAIPES SÃO DIFERENTES.
    * metodo serve para calcular o Ataque e contra ataque,
    * retorna a carta que Ganhou o Ataque.
    * Faz uma chamada ao método para verificar se os naipes são compativeis.
    * caso o os NAIPES sejam iguais, VERIFICA A DISTÂNCIA,
    * caso a OUTRA CARTA puder se defender
    * verifico a vencedora.
    */
     /* @throws ExcecaoCarta "NAIPES DIFERENTES"*/
  
   public CartaAtaque ataqueCarta(CartaAtaque outra) throws ExcecaoCarta{ 
   
   
    if(this.equalsNaipe(outra))  
    {                            
        
      if(outra.verificaDistancia(this)) 
      {
        return verificaAtaque(outra);  
      }
      
      else  
      {
         return this;
      }
        
   }
   
    else{
    throw new ExcecaoCarta(1); // LANÇA EXCEÇÃO "NAIPES DIFERENTES"
    }
   }
 
   /* O método verificaAtaque entre os ataques qual carta possui o maior ataque.
    * retorna a vencedora.
    */
   /* @throws ExcecaoCarta "EMPATE!"*/
   public CartaAtaque verificaAtaque(CartaAtaque outra) throws ExcecaoCarta // verifica quem vai ganhar
    {
        
       if(this.getAtaque() > outra.getAtaque()) // Carta com maior ataque
        return this;
       
       else if (this.getAtaque() < outra.getAtaque()) // Carta com menor ataque
       return outra;
       
       else{ // LANÇA EXECAO "EMPATE"
        throw new ExcecaoCarta(2); // LANÇA EXCEÇÃO "EMPATE!"
        }
    }
   
   
   //METODOS DE ACESSO
   
   public void setAtaque(int ataque){
    this.ataque=ataque;
    }
    
   public int getAtaque( ){
     return this.ataque;
    }
}
