
package br.ifba.ads.inter.game.percistence;

import br.ifba.ads.inter.game.model.base.CartaAtaque;
import br.ifba.ads.inter.game.model.base.Baralho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class BDDAOBaralho implements IDAOBaralho{
    
    
    private final String bd = ConexaoBanco.getEnderecoBanco();
    private Connection conn;
    

   private PreparedStatement pStmt;	
   private ResultSet rSet;
    
    public BDDAOBaralho( ) throws Exception{ 
    Class.forName(ConexaoBanco.getNomeClasseBanco()).newInstance();
    }  
    
    
    @Override
     public List<CartaAtaque> retornarBaralho(int cod_jogador)throws Exception {
    
    Baralho baralho = new Baralho(); 
    
    if(cod_jogador == 1)
    {
        baralho.addCarta( new CartaAtaque("R11","Rei_Fogo", 8, 10));
        baralho.addCarta( new CartaAtaque("S10","Sol", 8, 10));
        baralho.addCarta( new CartaAtaque("S11","Sol", 4, 4));
        baralho.addCarta( new CartaAtaque("S12","Sol", 5, 5));
        baralho.addCarta( new CartaAtaque("S13","Sol", 6, 6));
        baralho.addCarta( new CartaAtaque("S14","Sol", 7, 7));
        baralho.addCarta( new CartaAtaque("S15","Sol", 8, 8));
        baralho.addCarta( new CartaAtaque("S16","Sol", 10, 10));
        baralho.addCarta( new CartaAtaque("L10","Lua", 10, 4));
        baralho.addCarta( new CartaAtaque("L11","Lua", 9, 5));
        baralho.addCarta( new CartaAtaque("L12","Lua", 8, 6));
        baralho.addCarta( new CartaAtaque("L13","Lua", 7, 7));
        baralho.addCarta( new CartaAtaque("L14","Lua", 6, 8));
        baralho.addCarta( new CartaAtaque("L15","Lua", 5, 9));
        baralho.addCarta( new CartaAtaque("L16","Lua", 4, 10));
        baralho.addCarta( new CartaAtaque("C10","Cruz", 4, 4));
        baralho.addCarta( new CartaAtaque("C11","Cruz", 5, 5));
        baralho.addCarta( new CartaAtaque("C12","Cruz", 6, 6));
        baralho.addCarta( new CartaAtaque("C13","Cruz", 7, 7));
        baralho.addCarta( new CartaAtaque("C14","Cruz", 8, 8));
        baralho.addCarta( new CartaAtaque("C15","Cruz", 9, 9));
        baralho.addCarta( new CartaAtaque("C16","Cruz", 10, 10));
        baralho.addCarta( new CartaAtaque("LA10","Lança", 10, 4));
        baralho.addCarta( new CartaAtaque("LA11","Lança", 9, 5));
        baralho.addCarta( new CartaAtaque("LA12","Lança", 8, 6));
        baralho.addCarta( new CartaAtaque("LA13","Lança", 7, 7));
        baralho.addCarta( new CartaAtaque("LA14","Lança", 6, 8));
        baralho.addCarta( new CartaAtaque("LA15","Lança", 5, 9));
        baralho.addCarta( new CartaAtaque("LA16","Lança", 4, 10));
    }
    
     else
    {
        baralho.addCarta( new CartaAtaque("R21","Rei_Água", 8, 10));
        baralho.addCarta( new CartaAtaque("S20","Sol", 8, 10));
        baralho.addCarta( new CartaAtaque("S21","Sol", 4, 4));
        baralho.addCarta( new CartaAtaque("S22","Sol", 5, 5));
        baralho.addCarta( new CartaAtaque("S23","Sol", 6, 6));
        baralho.addCarta( new CartaAtaque("S24","Sol", 7, 7));
        baralho.addCarta( new CartaAtaque("S25","Sol", 8, 8));
        baralho.addCarta( new CartaAtaque("S26","Sol", 10, 10));
        baralho.addCarta( new CartaAtaque("L20","Lua", 4, 4));
        baralho.addCarta( new CartaAtaque("L21","Lua", 5, 5));
        baralho.addCarta( new CartaAtaque("L22","Lua", 6, 6));
        baralho.addCarta( new CartaAtaque("L23","Lua", 7, 7));
        baralho.addCarta( new CartaAtaque("L24","Lua", 8, 8));
        baralho.addCarta( new CartaAtaque("L25","Lua", 9, 9));
        baralho.addCarta( new CartaAtaque("L26","Lua", 10, 10));
        baralho.addCarta( new CartaAtaque("C20","Cruz", 10, 4));
        baralho.addCarta( new CartaAtaque("C21","Cruz", 9, 5));
        baralho.addCarta( new CartaAtaque("C22","Cruz", 8, 6));
        baralho.addCarta( new CartaAtaque("C23","Cruz", 7, 7));
        baralho.addCarta( new CartaAtaque("C24","Cruz", 6, 8));
        baralho.addCarta( new CartaAtaque("C25","Cruz", 5, 9));
        baralho.addCarta( new CartaAtaque("C26","Cruz", 4, 10));
        baralho.addCarta( new CartaAtaque("LA20","Lança", 4, 4));
        baralho.addCarta( new CartaAtaque("LA21","Lança", 5, 5));
        baralho.addCarta( new CartaAtaque("LA22","Lança", 6, 6));
        baralho.addCarta( new CartaAtaque("LA23","Lança", 7, 7));
        baralho.addCarta( new CartaAtaque("LA24","Lança", 8, 8));
        baralho.addCarta( new CartaAtaque("LA25","Lança", 9, 9));
        baralho.addCarta( new CartaAtaque("LA26","Lança", 10, 10));
    }
		
    return baralho.getBaralho();
}
    
    
}
