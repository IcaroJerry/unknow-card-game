
package br.ifba.ads.inter.game.windows.gameString;


public class StringES implements IString {
    
private static String nomeJogo = "Darkness into Light";
 private static String menuCadastro = "Menu Register";
 private static String menuLogin = "Login";
 private static String menuRank = "Rank";
 private static String menuSobre = "About";
 private static String menuRegras = "Rules";
 private static String sair = "Exit";
 private static String voltar = "Back";
 private static String cancelar = "Cancel";
 private static String cadastrar = "Register";
 private static String menu = "Menu";
 private static String senha = "Password:";
 private static String entrar = "Log In";
 private static String lembrarSenha = "I forgot my password:";
 private static String login = "Login";
 private static String confirmaSenha = "Confirm Password:";
 private static String fraseRecuperacao = "Sentence Retrieval";
 private static String vitorias = "Wins";
 private static String jogador = "Players";
 private static String regras = "Rules:";
 private static String regrasBasicas = "Basic Rules";
 private static String regrasEspecificas = "Specific Rules";
 private static String estruturasCartas = "Structures of Card";
 private static String infoTecnicas = "Technical Information";
 private static String versao = "Version 1.10.3";
 private static String criador = "Created By: Márcio Jóse";
 private static String desenvolvedores = "Developers:";
 private static String desejaSair = "Want to Quit?";
 private static String atencao = "Attention! ";

@Override
    public  String getDesejaSair() {
        return desejaSair;
    }

@Override
    public  String getAtencao() {
        return atencao;
    }
 @Override
    public  String getInfoTecnicas() {
        return infoTecnicas;
    }

 @Override
    public  String getVersao() {
        return versao;
    }

    public  String getCriador() {
        return criador;
    }

 @Override
    public  String getDesenvolvedores() {
        return desenvolvedores;
    }
    
 @Override
    public  String getRegrasEspecificas() {
        return regrasEspecificas;
    }

 @Override
    public  String getEstruturasCartas() {
        return estruturasCartas;
    }
 

 @Override
    public  String getRegrasBasicas() {
        return regrasBasicas;
    }
    
    
 // TEXTOS
private static String txtRegrasBasicas = ("1ª Each player begin of 30 point of vital energy and 5 cards in hand.\n"+
"2ª Wins the game: the player that get vital energy that more other or run out the cards.\n"+
"3ª Although the same amount of cards and cash equivalents at the suits of battles, each player has different decks.");

private static String txtRegrasEspeficas = ("");
 
 
private static String txtEstruturaCartas = ("Total letters of the Game: 58\n \n" +"Total letters for the player: 45\n" +
"\n" +"As King for one player, 4 suits, each containing 5 cards attack ranging from 4 to 10 and 4 specials different. \n" +
"Every player has the 4 suits, and only two of them fight each other, ie, is allowed only played the suit against the moon and sun suit against the Boom Lua.ok \n" +
"All the cards have an attribute called distance, ranging from 4 to 10. \n" +
        "The Distance of the letter allows the player the possibility of having to defend against attacks from any letter \n" +
"since their distance is equal to or larger than the attack. \n");

private static String txtInfo = ("Interdisciplinary Work - Semester 2 \n" +
"Campus Salvador 2013.1 \n" +

"\n" +
"Curse:\n" +
"            Analysis and Systems Developmentas \n" +
"	                Graduation Technology\n" +
"\n" +
"# Disciplines:\n" +
"      [ Object-Oriented Programming Schedule] - INF008\n" +
"      [ Database I ] - INF007\n" +
"      [ Data structure] - INF 006\n" +
"\n" +
"Instituto Federal de Educação, Ciências e Tecnologia\n" +
" BAHIA"); 

 @Override
 public  String getTxtInfo() {
        return txtInfo;
    }

 @Override
    public  String getTxtRegrasEspeficas() {
        return txtRegrasEspeficas;
    }

 @Override
    public  String getTxtEstruturaCartas() {
        return txtEstruturaCartas;
    }
 
  
 @Override
    public  String getTxtRegrasBasicas() {
        return txtRegrasBasicas;
    }

 @Override
    public  String getRegras() {
        return regras;
    }
 @Override
 public  String getVitorias() {
        return vitorias;
    }

 @Override
 public  String getJogador() {
        return jogador;
    }
 
 @Override
 public  String getConfirmaSenha() {
        return confirmaSenha;
    }

 @Override
 public  String getFraseRecuperacao() {
        return fraseRecuperacao;
    }   
 
 @Override
 public  String getLogin() {
        return login;
    }
 
 @Override
     public  String getSenha() {
        return senha;
    }

 @Override
    public  String getEntrar() {
        return entrar;
    }

 @Override
    public  String getLembrarSenha() {
        return lembrarSenha;
    }
 
 
 
 @Override
    public String getMenu() {
        return menu;
    }
  

 @Override
    public String getNomeJogo() {
        return nomeJogo;
    }

 @Override
    public String getMenuCadastro() {
        return menuCadastro;
    }

 @Override
    public String getMenuLogin() {
        return menuLogin;
    }

 @Override
    public String getMenuRank() {
        return menuRank;
    }

 @Override
    public String getMenuSobre() {
        return menuSobre;
    }

 @Override
    public String getMenuRegras() {
        return menuRegras;
    }

 @Override
    public String getSair() {
        return sair;
    }

 @Override
    public String getVoltar() {
        return voltar;
    }

 @Override
    public String getCancelar() {
        return cancelar;
    }

 @Override
    public String getCadastrar() {
        return cadastrar;
    }




}
