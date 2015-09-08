
package br.ifba.ads.inter.game.windows.gameString;


public class StringPT implements IString {
    
 private static String nomeJogo = "Trevas em Luz";
 private static String menuCadastro = "Cadastrar Jogador";
 private static String menuLogin = "Login Jogador";
 private static String menuRank = "Rank";
 private static String menuSobre = "Sobre";
 private static String menuRegras = "Regras";
 private static String sair = "Sair";
 private static String voltar = "Voltar";
 private static String cancelar = "Cancelar";
 private static String cadastrar = "Cadastrar";
 private static String menu = "Menu";
 private static String senha = "Senha:";
 private static String entrar = "Entrar";
 private static String lembrarSenha = "Esqueci minha senha:";
 private static String login = "Login";
 private static String confirmaSenha = "Confirmar Senha:";
 private static String fraseRecuperacao = "Frase de Recuperação:";
 private static String vitorias = "Vitórias";
 private static String jogador = "Jogador";
 private static String regras = "Regras:";
 private static String regrasBasicas = "Regras Básicas";
 private static String regrasEspecificas = "Regras Específicas";
 private static String estruturasCartas = "Estruturas das Cartas";
 private static String infoTecnicas = "Informações Técnicas";
 private static String versao = "Versão 1.10.3";
 private static String criador = "Criado por: Márcio Jóse";
 private static String desenvolvedores = "Desenvolvedores:";
 private static String desejaSair = "Deseja Fechar?";
 private static String atencao = "ATENÇÃO ";

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

 @Override
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
 
 @Override
    public  String getRegras() {
        return regras;
    }
 
    
    
   /// MENSAGENS
    
    
  /// TEXTOS:
    
 private static String txtRegrasBasicas = ("1ª Cada jogador inicia com 30 pontos de Energia Vital,\ne com no máximo 5 cartas na mão.\n\n"+
"2ª Ganha o jogador que conseguir tirar todos os pontos de Energia Vital\nou que tiver este maior do que o do outro caso as cartas acabem.\n\n"+
"3ª Apesar da mesma quantidade de cartas e equivalentes aos naipes de batalhas, cada jogador possui baralhos diferentes.\n\n"+
"4ª Cada jogador só poderá jogar uma carta por vez no Campo.\n\n"+
"5ª Em uma rodada, o primeiro jogador ataque e o segundo defente depois o segundo ataca e primeiro defende.");

 private static String txtRegrasEspeficas = ("1ª - Só podem batalhar a Lua contra o Sol, a Cruz contra a Lança,\ncom exceção do Rei de cada baralho, este pode batalhar contra qualquer naipe, desde que não fuja a 2ª regra.\n\n" +
"2ª- O atributo da Distância é irrelevante para quem ataca apenas quem defende \nprecisa usar este atributo da carta maior ou igual para poder efetuar a defesa. \nCaso o jogador que está se defendo, tiver o atributo Ataque menor do que o do jogador que ataca, este toma os pontos que sobram\n"+
"(ou seja, os pontos de Ataque menos de Defesa serão debitados nos pontos vitais do jogador). \nCaso o jogador que ataca tiver menos ponto de ataque do que o jogador que defende, este toma os pontos que sobram, ou seja, um contra-ataque. \n\n" +
"3ª- Cada jogada poderá ter apenas um de tipo de batalha por vez (de acordo com a 1ª regra), ou seja,\n o jogador que defende deve jogar as cartas cujos naipes combatem com a do jogador que ataca.\n\n" +
"4ª- Caso o jogador não tenha carta para se defender segundo o naipe da batalha ou a\n Distância não sejam compatíveis para efetuar uma defesa, os pontos de Ataque deve ser debitados diretamente nos pontos de Energia Vital.");
 
 
 private static String txtEstruturaCartas = ("Total de cartas do Jogo: 58\n" +
"\n" +
"Total de cartas por jogador: 29\n" +
"\n\n" +
"Sendo 1 Rei por jogador,  4 naipes, cada um contendo 5  cartas de ataques que variam entre 4 à 10.\n" +
"Cada jogador possui os 4 naipes,  e apenas dois dele lutam entre si,\n "+
"ou seja, só é permitida jogadas de cartas com mesmo naipe ou de naipes opostos sendo eles\n"+
"o naipe de Lua contra o naipe de Sol"+
"e o de Lança o de Cruz.\n\n" +
"Todas as cartas possuem um atributo chamado Distância, que varia entre 4 à 10.\n" +
"A Distância da carta permite ao jogador a ter possibilidade de se defender dos ataques,\n" +
"desde que sua Distância seja igual ou maior do a distância da carta do seu oponente.\n\n");

 private static String txtInfo = ("Trabalho de Interdisciplinar - 2º Semestre \n" +
"                          Campus Salvador 2013.1\n" +
"\n" +
"Curso:\n" +
"            Análise e Desenvolvimento de Sistemas \n" +
"	                Graduação Tecnológica\n" +
"\n" +
"# Apresentados às disciplinas de:\n" +
"      [ Programaçao Orientada a Objeto ] - INF008\n" +
"      [ Banco de Dados I ] - INF007\n" +
"      [ Estruturas de Dados ] - INF 006\n" +
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
