
package br.ifba.ads.inter.game.model.appGame;

import java.sql.Date;
/*A classe JogosSalvo serve para representação dos dados de Jogos Salvo.*/

public class JogosSalvo {

    private String nome;
    private Date data;
    private Partida partida;
  
      
 /*A Classe JogosSalvo possui três Construtores diferentes
 * Para determinados tipos de operações distintas.
 * 1ª - Para criar instâncias do objeto.
 * 2² - Para salvar os dados.
 * 3ª - Recuperar o historico do banco das Tabelas referente aos Historicos.
 */
    public JogosSalvo(){}
    
    public JogosSalvo(String nome, Date data,Partida partida) {
        this.setNome(nome);
        this.setData(data);
        this.setPartida(partida);
    }
    
     public JogosSalvo(String nome,Partida partida) {
        this.setNome(nome);
        this.setPartida(partida);
    }
    
    // METODOS DE ACESSO
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
      public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
