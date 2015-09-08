
package br.ifba.ads.inter.game.model.base;


public abstract class Carta
{
    /*Esta classe se refere a um dos objetos principais desta aplicação,
     * Toda CARTA possui um CÓDIGO único,
     * Toda CARTA possiu um NAIPE, segundo as regras do jogo,
     * Toda CARTA possui uma DISTANCIA, segundo as regras do jogo.
     * Toda CARTA possiu um contador, porém está versão de do jogo, todas as cartas estão
     * com o seu contador valendo 1, logo não foi necessário usa-lo, porém deixamos declarado para ser
     * usado nas próximas versões.
     */
    
    private String codCarta;
    private String naipe;
    private int distancia;
    private int contadorJogada; // não é utilizado nesta versão do jogo.

    
    public Carta(String codCarta, String naipe_carta, int distancia)
    {
        super();
        this.setCodCarta(codCarta);
        this.setNaipe(naipe_carta);
        this.setDistancia(distancia);
     
        
    
    }
    
   /* METODOS DA MECÂNICA DO JOGO */
    
    /* Metodo verifica a distância entre as cartas:
     * return true se puder se defender
     * return false caso não seja possivel defesa ou contra-ataque
    */
   public boolean verificaDistancia(Carta outra)
   {
       if(this.getDistancia()>= outra.getDistancia())
          return true; 
        
       else
       return false;
               
    }
    
 
    
    
 /* Uma Carta só pode batalhar com outra primeiramente de acordo o seu Naipe
  * e segundo a regra do Jogo. O método EQUALSNAIPE serve para representar esta regra.
  * "Reis" batalham com todos naipes
  */
   public final boolean equalsNaipe(Carta outra){      
        if ("Rei".equals(this.getNaipe())) 
        {return true;}
        else if ("Rei".equals(outra.getNaipe()))
        {return true;}
        else if (("Lua".equals(this.getNaipe()))&&("Lua".equals(outra.getNaipe())))
        {return true;}
        else if (("Lança".equals(this.getNaipe()))&&("Lança".equals(outra.getNaipe())))
        {return true;}
        else if (("Lua".equals(this.getNaipe()))&&("Lança".equals(outra.getNaipe())))
        {return true;}
        else if (("Lança".equals(this.getNaipe()))&&("Lua".equals(outra.getNaipe())))
        {return true;}
        else if (("Sol".equals(this.getNaipe()))&&("Sol".equals(outra.getNaipe())))
        {return true;}
        else if (("Cruz".equals(this.getNaipe()))&&("Cruz".equals(outra.getNaipe())))
        {return true;}
        else if (("Sol".equals(this.getNaipe()))&&("Cruz".equals(outra.getNaipe())))
        {return true;}
        else if (("Cruz".equals(this.getNaipe()))&&("Sol".equals(outra.getNaipe())))
        {return true;}
        else
        {return false;}
        
    }
    
   
   // APARTIR DAQUI APENAS METODOS DE ACESSO
    protected void setCodCarta(String cod_carta) {
        this.codCarta = cod_carta;
    }
    
    public String getCodCarta(){
        return this.codCarta;
    }
        
    
    public String getNaipe() {
        return naipe;
    }
       
    protected void setNaipe(String naipe) {
    this.naipe = naipe;
    }

    protected void setDistancia(int distancia){
    this.distancia = distancia;
    }
    
    public int getDistancia( ){
    return this.distancia;
    }
  

}
