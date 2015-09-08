package br.ifba.ads.inter.game.model.exception;

/* A Classe ExecaoCarta trata as exeções ocorridas na partida referente as cartas. 
 * 
 */

public class ExcecaoCarta extends Exception{
 
    private int numExcecao = 0;

    public ExcecaoCarta(int num){
       this.setNumExcecao(num);
    }
    
 public String excecaoBatalha (){
     
 switch (this.getNumExcecao())
 {
     case 1:{
           return "Os Naipes são diferentes!";
            }
     
     case 2:{
           return  "Houve Empate!";
            }
     
         
     default: return "Jogada Inválida!";
 }
 
 }   
    
  // METODOS DE ACESSO
 
     public void setNumExcecao(int numExcecao) {
        this.numExcecao = numExcecao;
    }

    public int getNumExcecao() {
        return numExcecao;
    }
    
}
