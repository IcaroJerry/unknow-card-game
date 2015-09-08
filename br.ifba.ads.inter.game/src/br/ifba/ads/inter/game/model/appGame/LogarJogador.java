package br.ifba.ads.inter.game.model.appGame;

/* A classe LogarJogador foi desiginada especialmente para a operação de cadastro e login de um Jogador.
 * Classe criada com objetivo de captar os dados do banco, evitando que a Aplicação
 * carregue dados desnecessários durante operações distintas. 
 */


public final class LogarJogador{
    
    
    private String login;
    private String senha;
    private int contVitorias;
    private String frase; // este atributo serve para que o Jogador possa lembrar a senha de acesso.
                           
    
    public LogarJogador(String nome, String senha, String frase){
        super();
        setLogin(nome);
        setSenha(senha);
        setFrase(frase);
        setCont(0); // sempre que cadastrado um novo jogador, ele ira iniciar com ZERO vitórias.        
    }

      public LogarJogador(String nome, int vitorias){
        super();
        setLogin(nome);
        setCont(vitorias); // sempre que cadastrado um novo jogador, ele ira iniciar com ZERO vitórias.        
    }

    public LogarJogador() {
        
    }  // Construtor sobrecarregado, usado para criar instancias de LogarJogador
                                 // em operações que não usam parêmetros para que este seja criado.
    
    
    // METODOS DE ACESSO
    public String getLogin(){
    return this.login;
    }
    
    public int getCont(){
    return this.contVitorias;
    }
    
    public String getFrase(){
    return this.frase;
    }
    
    public String getSenha(){
    return this.senha;
    }
    
    public void setLogin(String nome){
        this.login = nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setFrase(String frase){
        this.frase = frase;
    }
    
    public void setCont(int  c){
        this.contVitorias = c;
    }
    
}    