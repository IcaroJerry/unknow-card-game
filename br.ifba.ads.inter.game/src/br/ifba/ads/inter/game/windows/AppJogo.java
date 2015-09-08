
package br.ifba.ads.inter.game.windows;


import br.ifba.ads.inter.game.model.appGame.Partida;
import br.ifba.ads.inter.game.model.base.CartaAtaque;
import br.ifba.ads.inter.game.model.appGame.JogosSalvo;
import br.ifba.ads.inter.game.model.exception.ExcecaoCarta;
import br.ifba.ads.inter.game.percistence.*;
import br.ifba.ads.inter.game.windows.auxiliary.PainelCarta;
import br.ifba.ads.inter.game.windows.auxiliary.SalveGame;
import br.ifba.ads.inter.game.windows.gameString.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class AppJogo extends javax.swing.JFrame {

protected IString strings; 
protected IDAOBaralho bancoBaralho;
protected IDAOHistorico bancoHistorico;
private String implemente;



private PainelCarta painelCarta;
private Partida novaPartida;
int anterior = 0;

    public Partida getNovaPartida() {
        return novaPartida;
    }

private String login;




public AppJogo(String login, String implemente, Partida partida) {
        initComponents();
        this.implemente = implemente;
    
        try {
              this.strings = (IString) Class.forName(this.implemente).newInstance();
            } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}    
        
              this.login = login;

              this.plotarTitulos();
              
          try {
                this.setNovaPartida(partida);
                this.txtJuiz.setText(this.novaPartida.mensagensJogada(this.novaPartida.getEtapa()));
                       
                

               } catch (Exception ex) {
                              JOptionPane.showMessageDialog(null,"TRATAR EXCESSAO!");
                                     }
      
               
        this.plotarDados();
             
    }
   
private void plotarTitulos(){
    this.menuApp.setText(strings.getMenu());
    this.menuRank.setText(strings.getMenuRank());
    this.menuRegras.setText(strings.getMenuRegras());
    this.menuSobre.setText(strings.getMenuSobre());
    this.menuSair.setText(strings.getSair()); 
    
   

}
private void movimentoInvalido(){

JOptionPane.showMessageDialog(null,"Ação não permitida!");
}   
 
private void plotarDados(){
 this.loginJogador1.setText(this.novaPartida.getPlayUM().getNomeJogador());
 this.loginJogador2.setText(this.novaPartida.getPlayDOIS().getNomeJogador());
 
 this.energia1.setText(String.valueOf(this.novaPartida.getPlayUM().getEnergiaVital()));
 this.energia2.setText(String.valueOf(this.novaPartida.getPlayDOIS().getEnergiaVital()));
 
 this.totalCartas1.setText(String.valueOf(this.novaPartida.getPlayUM().getBaralho().getTamanho()));
 this.totalCartas2.setText(String.valueOf(this.novaPartida.getPlayDOIS().getBaralho().getTamanho()));
 
 this.atualizaCampos();
 this.atualizaDadosMao();
 
 this.txtJuiz.setText(this.novaPartida.mensagensJogada(this.novaPartida.getEtapa()));
 
 }


private void cartaJogada(int indexLabel){
    String cod = null;
    cod = "Card_Fogo/"+this.novaPartida.getPlayUM().getCartasMao(indexLabel).getCodCarta();
    this.painelCarta = new PainelCarta(this.implemente, cod);    
      
        String message = "Escolha uma das opções abaixo"; 
        Object[] options = { "Visualizar Cartas","Jogar Carta", "Cancelar"};  
        
        int result = JOptionPane.showOptionDialog(null, message, "Painel Jogada",   
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icone.png"))
                , options, options[0]);
        
        
        
        this.setEnabled(false); 
        switch (result) {  
            case 0:
            {   this.painelCarta.setImage(cod);
                this.painelCarta.setVisible(true);
                break;  
            }    
            case 1: 
            {       if(this.novaPartida.getEtapa() ==2){
                    cod = this.novaPartida.getPlayUM().getCartasMao(indexLabel).getCodCarta();
                    this.lblCampoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
                    
                    this.novaPartida.setCampoUM(this.novaPartida.getPlayUM().getCartasMao(indexLabel));
                    this.novaPartida.getPlayUM().jogouCarta(indexLabel);
                    this.novaPartida.setEtapa(3);
                    this.plotarDados();
                    }
            
                    else if(this.novaPartida.getEtapa() == 7){
                            if(this.novaPartida.getPlayUM().getCartasMao(indexLabel).equalsNaipe(this.novaPartida.getCampoDOIS())){
                                 cod = this.novaPartida.getPlayUM().getCartasMao(indexLabel).getCodCarta();
                                 this.lblCampoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
                                 this.novaPartida.setCampoUM(this.novaPartida.getPlayUM().getCartasMao(indexLabel));
                                 this.novaPartida.getPlayUM().jogouCarta(indexLabel);
                                 this.novaPartida.setEtapa(8);
                                 this.plotarDados();
                            
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Jogada inválida! Escolha outra carta!");
                            }
                            
                            
                    }
                    
                   
                                
                    
            break;
            }
            } 
        
 
        
}

private void cartaNaoJogada(){
            this.painelCarta = new PainelCarta(this.implemente, null);
            this.painelCarta.setVisibleBtnVoltar(false);
            this.painelCarta.setVisible(true);
            JOptionPane.showMessageDialog(null, "Carta Vazia!");
            this.painelCarta.setVisible(false);
}

private void atualizaDadosMao(){
    String cod = null;
    
   try{
   cod = this.novaPartida.getPlayUM().getCartasMao(0).getCodCarta();
   this.cartaUMPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.cartaUMPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg")));}
   
   try{
   cod = this.novaPartida.getPlayUM().getCartasMao(1).getCodCarta();
   this.cartaDOISPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.cartaDOISPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg")));}
   
   try{
   cod = this.novaPartida.getPlayUM().getCartasMao(2).getCodCarta();
   this.cartaTRESPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.cartaTRESPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg")));}
   
  
   try{
   cod = this.novaPartida.getPlayUM().getCartasMao(3).getCodCarta();
   this.cartaQUATROPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.cartaQUATROPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg")));}
    

   
   try{
   cod = this.novaPartida.getPlayUM().getCartasMao(4).getCodCarta();
   this.cartaCINCOPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.cartaCINCOPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg")));}
   
}

private void campoVazio(){            
            this.painelCarta.setImage("Campo_ Vazio");
            this.painelCarta.setVisibleBtnVoltar(false);
            this.painelCarta.setVisible(true);
            JOptionPane.showMessageDialog(null, "Campo Vazio!");
            this.painelCarta.setVisible(false);


}

private void atualizaCampos(){
 String cod = null;
 try{
   cod = this.novaPartida.getCampoUM().getCodCarta();
   this.lblCampoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Fogo/"+cod+".jpg")));
   }
   catch (Exception e) {this.lblCampoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Campo_Vazio_mini.jpg")));}
  
   try{
   cod = this.novaPartida.getCampoDOIS().getCodCarta();
   this.lblCampoPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Mini_Agua/"+cod+".jpg")));
   }
   catch (Exception e) {this.lblCampoPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Campo_Vazio_mini.jpg")));}
}


public void setNovaPartida(Partida novaPartida) {
        this.novaPartida = novaPartida;
    }
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPartida = new javax.swing.JPanel();
        loginJogador1 = new javax.swing.JLabel();
        loginJogador2 = new javax.swing.JLabel();
        lblEnergiaVital1 = new javax.swing.JLabel();
        energia1 = new javax.swing.JLabel();
        totalCartas1 = new javax.swing.JLabel();
        lblCartas1 = new javax.swing.JLabel();
        lblEnergia2 = new javax.swing.JLabel();
        lblCartas2 = new javax.swing.JLabel();
        totalCartas2 = new javax.swing.JLabel();
        energia2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnProx = new javax.swing.JButton();
        cartaQUATROPlayUM = new javax.swing.JLabel();
        cartaTRESPlayDOIS = new javax.swing.JLabel();
        cartaUMPlayDOIS = new javax.swing.JLabel();
        cartaDOISPlayDOIS = new javax.swing.JLabel();
        cartaQUATROPlayDOIS = new javax.swing.JLabel();
        cartaCINCOPlayDOIS = new javax.swing.JLabel();
        baralhoPlayUM = new javax.swing.JLabel();
        baralhoPlayDOIS = new javax.swing.JLabel();
        lblRegras1 = new javax.swing.JLabel();
        cartaCINCOPlayUM = new javax.swing.JLabel();
        cartaTRESPlayUM = new javax.swing.JLabel();
        cartaDOISPlayUM = new javax.swing.JLabel();
        cartaUMPlayUM = new javax.swing.JLabel();
        lblCampoPlayDOIS = new javax.swing.JLabel();
        lblCampoPlayUM = new javax.swing.JLabel();
        lblJuiz = new javax.swing.JLabel();
        txtJuiz = new javax.swing.JTextPane();
        lblImagemPrincipal = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuApp = new javax.swing.JMenu();
        menuRank = new javax.swing.JMenuItem();
        menuRegras = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuJogo = new javax.swing.JMenu();
        menuRenicia = new javax.swing.JMenuItem();
        menuAbandonar = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();
        menuCarregar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Partida");
        setPreferredSize(new java.awt.Dimension(940, 670));
        setResizable(false);
        getContentPane().setLayout(null);

        painelPartida.setBackground(new java.awt.Color(255, 255, 255));
        painelPartida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelPartida.setLayout(null);

        loginJogador1.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        loginJogador1.setForeground(new java.awt.Color(255, 255, 255));
        loginJogador1.setText("JOGADOR 1");
        painelPartida.add(loginJogador1);
        loginJogador1.setBounds(20, 20, 140, 20);

        loginJogador2.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        loginJogador2.setForeground(new java.awt.Color(255, 255, 255));
        loginJogador2.setText("COMPUTER");
        painelPartida.add(loginJogador2);
        loginJogador2.setBounds(20, 110, 150, 20);

        lblEnergiaVital1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEnergiaVital1.setForeground(new java.awt.Color(255, 255, 255));
        lblEnergiaVital1.setText("ENERGIA VITAL");
        painelPartida.add(lblEnergiaVital1);
        lblEnergiaVital1.setBounds(120, 50, 120, 20);

        energia1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        energia1.setForeground(new java.awt.Color(255, 255, 255));
        energia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        energia1.setText("0");
        painelPartida.add(energia1);
        energia1.setBounds(150, 80, 75, 17);

        totalCartas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalCartas1.setForeground(new java.awt.Color(255, 255, 255));
        totalCartas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCartas1.setText("0");
        painelPartida.add(totalCartas1);
        totalCartas1.setBounds(10, 80, 90, 17);

        lblCartas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCartas1.setForeground(new java.awt.Color(255, 255, 255));
        lblCartas1.setText("CARTAS");
        painelPartida.add(lblCartas1);
        lblCartas1.setBounds(30, 50, 60, 20);

        lblEnergia2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEnergia2.setForeground(new java.awt.Color(255, 255, 255));
        lblEnergia2.setText("ENERGIA VITAL");
        painelPartida.add(lblEnergia2);
        lblEnergia2.setBounds(120, 140, 114, 17);

        lblCartas2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCartas2.setForeground(new java.awt.Color(255, 255, 255));
        lblCartas2.setText("CARTAS");
        painelPartida.add(lblCartas2);
        lblCartas2.setBounds(20, 140, 60, 20);

        totalCartas2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalCartas2.setForeground(new java.awt.Color(255, 255, 255));
        totalCartas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCartas2.setText("0");
        painelPartida.add(totalCartas2);
        totalCartas2.setBounds(10, 170, 83, 20);

        energia2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        energia2.setForeground(new java.awt.Color(255, 255, 255));
        energia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        energia2.setText("0");
        painelPartida.add(energia2);
        energia2.setBounds(140, 170, 82, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/painel_app.jpg"))); // NOI18N
        painelPartida.add(jLabel1);
        jLabel1.setBounds(10, 10, 250, 210);

        getContentPane().add(painelPartida);
        painelPartida.setBounds(20, 10, 270, 230);

        btnProx.setText("Continuar");
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });
        getContentPane().add(btnProx);
        btnProx.setBounds(170, 340, 100, 23);

        cartaQUATROPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg"))); // NOI18N
        cartaQUATROPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaQUATROPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(cartaQUATROPlayUM);
        cartaQUATROPlayUM.setBounds(437, 427, 98, 135);

        cartaTRESPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fundo_Agua_Mini.jpg"))); // NOI18N
        cartaTRESPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTRESPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(cartaTRESPlayDOIS);
        cartaTRESPlayDOIS.setBounds(553, 40, 98, 135);

        cartaUMPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fundo_Agua_Mini.jpg"))); // NOI18N
        cartaUMPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaUMPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(cartaUMPlayDOIS);
        cartaUMPlayDOIS.setBounds(321, 40, 98, 135);

        cartaDOISPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fundo_Agua_Mini.jpg"))); // NOI18N
        cartaDOISPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaDOISPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(cartaDOISPlayDOIS);
        cartaDOISPlayDOIS.setBounds(437, 40, 98, 135);

        cartaQUATROPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fundo_Agua_Mini.jpg"))); // NOI18N
        cartaQUATROPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaQUATROPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(cartaQUATROPlayDOIS);
        cartaQUATROPlayDOIS.setBounds(669, 40, 98, 135);

        cartaCINCOPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fundo_Agua_Mini.jpg"))); // NOI18N
        cartaCINCOPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaCINCOPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(cartaCINCOPlayDOIS);
        cartaCINCOPlayDOIS.setBounds(785, 40, 98, 135);

        baralhoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Baralho_Fogo.jpg"))); // NOI18N
        baralhoPlayUM.setToolTipText("");
        baralhoPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baralhoPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(baralhoPlayUM);
        baralhoPlayUM.setBounds(20, 480, 135, 98);

        baralhoPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Baralho_Agua.jpg"))); // NOI18N
        baralhoPlayDOIS.setToolTipText("");
        baralhoPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baralhoPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(baralhoPlayDOIS);
        baralhoPlayDOIS.setBounds(20, 370, 135, 98);

        lblRegras1.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblRegras1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegras1.setText("Baralhos:");
        getContentPane().add(lblRegras1);
        lblRegras1.setBounds(20, 340, 92, 33);

        cartaCINCOPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg"))); // NOI18N
        cartaCINCOPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaCINCOPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(cartaCINCOPlayUM);
        cartaCINCOPlayUM.setBounds(321, 427, 98, 135);

        cartaTRESPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg"))); // NOI18N
        cartaTRESPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTRESPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(cartaTRESPlayUM);
        cartaTRESPlayUM.setBounds(553, 427, 98, 135);

        cartaDOISPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg"))); // NOI18N
        cartaDOISPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaDOISPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(cartaDOISPlayUM);
        cartaDOISPlayUM.setBounds(669, 427, 98, 135);

        cartaUMPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia_Mini.jpg"))); // NOI18N
        cartaUMPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaUMPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(cartaUMPlayUM);
        cartaUMPlayUM.setBounds(785, 427, 98, 135);

        lblCampoPlayDOIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Campo_Vazio_mini.jpg"))); // NOI18N
        lblCampoPlayDOIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCampoPlayDOISMouseClicked(evt);
            }
        });
        getContentPane().add(lblCampoPlayDOIS);
        lblCampoPlayDOIS.setBounds(437, 220, 98, 135);

        lblCampoPlayUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Campo_Vazio_mini.jpg"))); // NOI18N
        lblCampoPlayUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCampoPlayUMMouseClicked(evt);
            }
        });
        getContentPane().add(lblCampoPlayUM);
        lblCampoPlayUM.setBounds(669, 220, 98, 135);

        lblJuiz.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblJuiz.setForeground(new java.awt.Color(255, 255, 255));
        lblJuiz.setText("Juiz da partida:");
        getContentPane().add(lblJuiz);
        lblJuiz.setBounds(20, 250, 150, 25);

        txtJuiz.setEditable(false);
        txtJuiz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtJuiz.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtJuiz);
        txtJuiz.setBounds(20, 280, 253, 58);

        lblImagemPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/solar-eclipse-and-lunar-eclipse.jpg"))); // NOI18N
        getContentPane().add(lblImagemPrincipal);
        lblImagemPrincipal.setBounds(0, -10, 940, 640);

        barraMenu.setBackground(new java.awt.Color(0, 0, 0));

        menuApp.setForeground(new java.awt.Color(255, 255, 255));
        menuApp.setText("Menu");

        menuRank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/coroa_ouro.jpg"))); // NOI18N
        menuRank.setText("Rank");
        menuRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRankActionPerformed(evt);
            }
        });
        menuApp.add(menuRank);

        menuRegras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/carta.jpg"))); // NOI18N
        menuRegras.setText("Regras");
        menuRegras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegrasActionPerformed(evt);
            }
        });
        menuApp.add(menuRegras);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/logoUnic.jpg"))); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuApp.add(menuSobre);
        menuApp.add(jSeparator1);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/exit.jpg"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuApp.add(menuSair);

        barraMenu.add(menuApp);

        menuJogo.setForeground(new java.awt.Color(255, 255, 255));
        menuJogo.setText("Jogo");

        menuRenicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/reset.jpg"))); // NOI18N
        menuRenicia.setText("Reiniciar Partida");
        menuRenicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReniciaActionPerformed(evt);
            }
        });
        menuJogo.add(menuRenicia);

        menuAbandonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/cancel.jpg"))); // NOI18N
        menuAbandonar.setText("Abandonar Partida");
        menuAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbandonarActionPerformed(evt);
            }
        });
        menuJogo.add(menuAbandonar);

        menuSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/save.jpg"))); // NOI18N
        menuSalvar.setText("Salvar Partida");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        menuJogo.add(menuSalvar);

        menuCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/load.jpg"))); // NOI18N
        menuCarregar.setText("Carregar Partida");
        menuCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCarregarActionPerformed(evt);
            }
        });
        menuJogo.add(menuCarregar);

        barraMenu.add(menuJogo);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Deseja Fechar?","ATENÇÃO ",JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();  
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRankActionPerformed
      Rank secundaria =  new Rank(this.implemente);
      secundaria.apagarBotao();
      secundaria.setVisible(true);
   
    }//GEN-LAST:event_menuRankActionPerformed

    private void menuRegrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegrasActionPerformed
       MenuRegras secundaria = new MenuRegras(this.implemente);
       secundaria.apagarBotao();
       secundaria.setVisible(true);
    }//GEN-LAST:event_menuRegrasActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
      MenuSobre secundaria = new MenuSobre(this.implemente);
      secundaria.apagarBotao();
      secundaria.setVisible(true);
    }//GEN-LAST:event_menuSobreActionPerformed

    private void cartaUMPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaUMPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_cartaUMPlayDOISMouseClicked

    private void cartaDOISPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaDOISPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_cartaDOISPlayDOISMouseClicked

    private void cartaTRESPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTRESPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_cartaTRESPlayDOISMouseClicked

    private void cartaQUATROPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaQUATROPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_cartaQUATROPlayDOISMouseClicked

    private void cartaCINCOPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaCINCOPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_cartaCINCOPlayDOISMouseClicked

    private void baralhoPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baralhoPlayDOISMouseClicked
        this.movimentoInvalido();
    }//GEN-LAST:event_baralhoPlayDOISMouseClicked

    private void menuReniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReniciaActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Deseja realmente reniciar a partida?",strings.getAtencao(),JOptionPane.YES_NO_OPTION )==0){  
        this.dispose();
            try {
                new AppJogo(this.login,this.implemente,new Partida(this.login)).setVisible(true);
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR PARTIDA!");
            }
        }
    }//GEN-LAST:event_menuReniciaActionPerformed

    private void cartaQUATROPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaQUATROPlayUMMouseClicked
    int indexLabel = 3;
    
    if(this.novaPartida.getEtapa() == 2 || this.novaPartida.getEtapa() == 7){  
                if(this.novaPartida.getPlayUM().getTamanhoCartasMao() >= indexLabel+1){
                    this.cartaJogada(indexLabel);
                
                }  
                else { this.cartaNaoJogada();}
       }

        
        else{ 
           JOptionPane.showMessageDialog(null, "Aguarde sua vez!");
        }
        
        this.setEnabled(true);  
    }//GEN-LAST:event_cartaQUATROPlayUMMouseClicked

    private void cartaCINCOPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaCINCOPlayUMMouseClicked
       int indexLabel = 4;
       
     if(this.novaPartida.getEtapa() == 2 || this.novaPartida.getEtapa() == 7){  
                if(this.novaPartida.getPlayUM().getTamanhoCartasMao() >= indexLabel+1){
                    this.cartaJogada(indexLabel);
                
                }  
                else { this.cartaNaoJogada();}
       }

        
        else{ 
           JOptionPane.showMessageDialog(null, "Aguarde sua vez!");
        }
        
        this.setEnabled(true);  
    }//GEN-LAST:event_cartaCINCOPlayUMMouseClicked

    private void cartaTRESPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTRESPlayUMMouseClicked
       int indexLabel = 2;
       
       if(this.novaPartida.getEtapa() == 2 || this.novaPartida.getEtapa() == 7){  
                if(this.novaPartida.getPlayUM().getTamanhoCartasMao() >= indexLabel+1){
                    this.cartaJogada(indexLabel);
                
                }  
                else { this.cartaNaoJogada();}
       }

        
        else{ 
           JOptionPane.showMessageDialog(null, "Aguarde sua vez!");
        }
        
        this.setEnabled(true);  
    }//GEN-LAST:event_cartaTRESPlayUMMouseClicked

    private void cartaDOISPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaDOISPlayUMMouseClicked
        int indexLabel = 1;
       
       if(this.novaPartida.getEtapa() == 2 || this.novaPartida.getEtapa() == 7){  
                if(this.novaPartida.getPlayUM().getTamanhoCartasMao() >= indexLabel+1){
                    this.cartaJogada(indexLabel);
                
                }  
                else { this.cartaNaoJogada();}
       }

        
        else{ 
           JOptionPane.showMessageDialog(null, "Aguarde sua vez!");
        }
        
        this.setEnabled(true);  
    }//GEN-LAST:event_cartaDOISPlayUMMouseClicked

    private void cartaUMPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaUMPlayUMMouseClicked
        int indexLabel = 0;
    
        // só pode jogar caso as etapas sejam a de atacar ou de se defender
        if(this.novaPartida.getEtapa() == 2 || this.novaPartida.getEtapa() == 7){  
                if(this.novaPartida.getPlayUM().getTamanhoCartasMao() >= indexLabel+1){
                    this.cartaJogada(indexLabel);
                
                }  
                else { this.cartaNaoJogada();}
       }

        
        else{ 
           JOptionPane.showMessageDialog(null, "Aguarde sua vez!");
        }
        
        this.setEnabled(true);  
    }//GEN-LAST:event_cartaUMPlayUMMouseClicked

    private void lblCampoPlayDOISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCampoPlayDOISMouseClicked
    this.painelCarta = new PainelCarta(this.implemente, null);
 
   try{
     String cod = "Card_Agua/"+ this.novaPartida.getCampoDOIS().getCodCarta();
        this.painelCarta.setImage(cod);
        this.painelCarta.setVisible(true);
        }
        
     catch (Exception e){ 
        this.campoVazio();
        }
    }//GEN-LAST:event_lblCampoPlayDOISMouseClicked

    private void lblCampoPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCampoPlayUMMouseClicked
    this.painelCarta = new PainelCarta(this.implemente, null);
 
   try{
     String cod = "Card_Fogo/"+ this.novaPartida.getCampoUM().getCodCarta();
        this.painelCarta.setImage(cod);
        this.painelCarta.setVisible(true);
        }
        
     catch (Exception e){ 
        this.campoVazio();
        }
           
        
    }//GEN-LAST:event_lblCampoPlayUMMouseClicked

    
    
//METODO PARA ADICIONAR CARTA A MAO - basta o jogador não possuir uma carta que ele pode pegar cartas a qualquer momento.
    private void baralhoPlayUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baralhoPlayUMMouseClicked
    
      int qnt = (5- this.novaPartida.getPlayUM().getTamanhoCartasMao());
      int index = this.novaPartida.getPlayUM().getTamanhoCartasMao();
      String cod;
     
      if(qnt == 0){
      JOptionPane.showMessageDialog(null,"Você já possui CINCO cartas na mão!");
        }
      
      else{
          if(this.novaPartida.getEtapa() == 0 || this.novaPartida.getEtapa() == 1){this.novaPartida.setEtapa(2);}
          this.novaPartida.getPlayUM().addCartaMao(1);
          cod = this.novaPartida.getPlayUM().getCartasMao(index).getCodCarta();
          this.atualizaDadosMao(); 

      }
      
       this.plotarDados();
    }//GEN-LAST:event_baralhoPlayUMMouseClicked

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
      String vencedor ="";
      if(this.novaPartida.getEtapa() == 4 || this.novaPartida.getEtapa() == 9   ){this.txtJuiz.setText(this.novaPartida.mensagensJogada(this.novaPartida.getEtapa())+vencedor);}
      else{  this.txtJuiz.setText(this.novaPartida.mensagensJogada(this.novaPartida.getEtapa()));}
      System.out.println(this.novaPartida.getEtapa());
     if(this.novaPartida.getEtapa() == 0){
     this.novaPartida.setEtapa(1);
     this.txtJuiz.setText(this.novaPartida.mensagensJogada(this.novaPartida.getEtapa()));
     }
      
     if(this.novaPartida.getEtapa() == 3){ // terceira etapa é vez do jogador dois se defender e jogar alguma carta em campo 
         
         this.novaPartida.setCampoDOIS(this.novaPartida.getPlayDOIS().jogadaAutomatica(this.novaPartida.getCampoUM()));
         this.novaPartida.setEtapa(4);
         this.plotarDados(); 
     }
     
     else if(this.novaPartida.getEtapa() == 4){ // quarta etapa olhar quem vence a batalha e a finaliza
         try {
             boolean venceu = this.novaPartida.getCampoUM().isWinner(this.novaPartida.getCampoDOIS());
             
             if(venceu){ vencedor = " Jogador UM venceu esta rodada!";
                         this.novaPartida.getPlayDOIS().golpe(
                                 this.novaPartida.getCampoUM().verificaGolpe(
                                 this.novaPartida.getCampoDOIS()
                                 )
                                 );
                        }
         
             else{ vencedor = " Jogador DOIS venceu esta rodada!"; // metodo diferente de golpe, pois quem ataca nao precisa de distancia
                    this.novaPartida.getPlayUM().golpe(this.novaPartida.getCampoDOIS().getAtaque() -
                                                       this.novaPartida.getCampoUM().getAtaque()
                                 );
            
             }
          this.plotarDados(); 
          this.novaPartida.setEtapa(5);
            
         
           
         } catch (ExcecaoCarta ex) {  this.novaPartida.setEtapa(5);
                                      JOptionPane.showMessageDialog(null, ex.excecaoBatalha());
                                     
                                      }
      
     }
     else if(this.novaPartida.getEtapa() == 5){ // quinta etapa é zerar o campo para que possa continuar a batalha
    
     this.novaPartida.setCampoUM(null);
     this.novaPartida.setCampoDOIS(null);
     this.plotarDados(); 
     anterior = 5;
     this.novaPartida.setEtapa(10);
     }
     
     else if(this.novaPartida.getEtapa() == 6){ // essa etapa o jogador dois ataca!
         this.novaPartida.setCampoDOIS(
                 this.novaPartida.getPlayDOIS().jogadaAutomatica()
                 );
         //ACRESCENTAR METODO QUE COMPARA IMEDIATAMETNE A CARTA JOGADA COM AS CARTAS DA MAO DO JOGADOR UM,
         //CASO NAO TENHA, AVISA! E DEPOIS EMBARALHA.
         this.plotarDados();
         this.novaPartida.setEtapa(7);
     }
     
     else if(this.novaPartida.getEtapa() == 8){
              try { // jogador dois ataca, jogador um defende apenas
             boolean venceu = this.novaPartida.getCampoDOIS().isWinner(this.novaPartida.getCampoUM());
                            // se o jogador dois venceu
             if(venceu){vencedor = " Jogador DOIS venceu esta rodada!"; 
                         this.novaPartida.getPlayUM().golpe(
                                 this.novaPartida.getCampoDOIS().verificaGolpe(
                                 this.novaPartida.getCampoUM()
                                 )
                                 );
                        }
         
             else{  vencedor = " Jogador UM venceu esta rodada!"; // metodo diferente de golpe, pois quem ataca nao precisa de distancia
                    this.novaPartida.getPlayDOIS().golpe(this.novaPartida.getCampoUM().getAtaque() -
                                                       this.novaPartida.getCampoDOIS().getAtaque()
                                 );
            
             }
          this.plotarDados(); 
          this.novaPartida.setEtapa(9);
           
         } catch (ExcecaoCarta ex) {  this.novaPartida.setEtapa(9);
                                      JOptionPane.showMessageDialog(null, ex.excecaoBatalha()); }
     
     }
     
     
      else if(this.novaPartida.getEtapa() == 9){ // quinta etapa é zerar o campo para que possa continuar a batalha
     this.txtJuiz.setText(this.novaPartida.mensagensJogada(5) + vencedor);    
     this.novaPartida.setCampoUM(null);
     this.novaPartida.setCampoDOIS(null);
     this.plotarDados();  
     anterior = 1;
     this.novaPartida.setEtapa(10);
     
     }
     
     else if (this.novaPartida.getEtapa() == 10){
          
           this.verificaBatalha(anterior);
         
          
     }
     else if (this.novaPartida.getEtapa() == 11){
          
          this.txtJuiz.setText("A Batalha já possui um vencedor!");
          JOptionPane.showMessageDialog(null, "A BATALHA TERMINOU!");
          
     }
     
     
     
    }//GEN-LAST:event_btnProxActionPerformed
private void verificaBatalha(int index){
          int energiaPlayUM =  this.novaPartida.getPlayUM().getEnergiaVital();
          int energiaPlayDOIS =  this.novaPartida.getPlayDOIS().getEnergiaVital();
          int tamanhoBaralhoUM = this.novaPartida.getPlayUM().getBaralho().getTamanho() + this.novaPartida.getPlayUM().getCartasMao().size();
          int tamalhoBaralhoDOIS = this.novaPartida.getPlayDOIS().getBaralho().getTamanho() + this.novaPartida.getPlayDOIS().getCartasMao().size();        
                  
          if(energiaPlayUM >0 && energiaPlayDOIS > 0 && tamanhoBaralhoUM >0 && tamalhoBaralhoDOIS >0 ){
          this.txtJuiz.setText("A Batalha continua!");
          this.novaPartida.setEtapa(index +1);
          }
          
          else if(tamanhoBaralhoUM ==0 ||tamalhoBaralhoDOIS ==0 ){
              
          if(energiaPlayUM < energiaPlayDOIS){
          this.txtJuiz.setText("O JOGADOR DOIS VENCEU!");   
          this.addVitoria(this.novaPartida.getPlayDOIS().getNomeJogador());
          JOptionPane.showMessageDialog(null, "A BATALHA TERMINOU!");
          this.novaPartida.setEtapa(11);
          } 
          if(energiaPlayDOIS < energiaPlayUM ){
          this.txtJuiz.setText("O JOGADOR UM VENCEU!");
          this.addVitoria(this.novaPartida.getPlayUM().getNomeJogador());
           JOptionPane.showMessageDialog(null, "A BATALHA TERMINOU!");
          this.novaPartida.setEtapa(11);
          }
          }
          
          else if(energiaPlayUM <=0){
          this.txtJuiz.setText("O JOGADOR DOIS VENCEU!");   
          this.addVitoria(this.novaPartida.getPlayDOIS().getNomeJogador());
          JOptionPane.showMessageDialog(null, "A BATALHA TERMINOU!");
          this.novaPartida.setEtapa(11);
          } 
          else if(energiaPlayDOIS <=0){
          this.txtJuiz.setText("O JOGADOR UM VENCEU!");
          this.addVitoria(this.novaPartida.getPlayUM().getNomeJogador());
           JOptionPane.showMessageDialog(null, "A BATALHA TERMINOU!");
          this.novaPartida.setEtapa(11);
          }
          
          
          
}
    private void menuAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbandonarActionPerformed
      if(JOptionPane.showConfirmDialog(null,"Deseja realmente abandonar esta partida?",strings.getAtencao(),JOptionPane.YES_NO_OPTION )==0){  
        this.dispose();}
    }//GEN-LAST:event_menuAbandonarActionPerformed

  private void  addVitoria(String login){
  
  IDAOJogador vencedor;
    try {
        vencedor = new BDDAOJogador();
        vencedor.addVitoria(login);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "ERRO NO SERVIDOR!");
    }
      
  }  
    
    
    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        String entrada = JOptionPane.showInputDialog(null,"Digite o nome do Salve-Game");
        if(entrada != null && !entrada.isEmpty()){
        try{
           bancoHistorico = new BDDAOHistorico();

          int qnt = this.novaPartida.getPlayUM().getTamanhoCartasMao();
          int qnt2 = this.novaPartida.getPlayDOIS().getTamanhoCartasMao();
         
            for(int i =0 ; i< this.novaPartida.getPlayUM().getTamanhoCartasMao(); i++){
                this.novaPartida.getPlayUM().getBaralho().addCarta(this.novaPartida.getPlayUM().getCartasMao(i));
                }
            
            for(int i =0 ; i< this.novaPartida.getPlayDOIS().getTamanhoCartasMao(); i++){
                this.novaPartida.getPlayDOIS().getBaralho().addCarta(this.novaPartida.getPlayDOIS().getCartasMao(i));      
            }
            
        
           
            boolean UM = false;
            boolean DOIS = false;
            if(this.novaPartida.isNotNULL(this.novaPartida.getCampoUM()))
            { this.novaPartida.getPlayUM().getBaralho().addCarta(this.novaPartida.getCampoUM());         
              UM=true;}
            
            if(this.novaPartida.isNotNULL(this.novaPartida.getCampoDOIS()))
            { this.novaPartida.getPlayDOIS().getBaralho().addCarta(this.novaPartida.getCampoDOIS());
               DOIS=true;}
            
            bancoHistorico.salveJogo( new JogosSalvo(entrada, this.novaPartida));
            
            if(UM){this.novaPartida.getPlayUM().getBaralho().remove(this.novaPartida.getPlayUM().getBaralho().getTamanho()-1);
                  }
            
            if(DOIS){this.novaPartida.getPlayDOIS().getBaralho().remove(this.novaPartida.getPlayDOIS().getBaralho().getTamanho()-1);
                  }
            
            
            for(int i =0 ; i< qnt; i++){
                this.novaPartida.getPlayUM().getBaralho().remove(this.novaPartida.getPlayUM().getBaralho().getTamanho()-1);     
                }
            
            for(int i =0 ; i< qnt2; i++){
                this.novaPartida.getPlayDOIS().getBaralho().remove(this.novaPartida.getPlayDOIS().getBaralho().getTamanho()-1);     
            }
            
        this.txtJuiz.setText("Partida Salva com Sucesso!");
        this.plotarDados();
        }
        
        catch (Exception e) {JOptionPane.showMessageDialog(null, "DIGITE OUTRO NOME PARA O SALVE GAME!");}
        }
    }//GEN-LAST:event_menuSalvarActionPerformed

    private void menuCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCarregarActionPerformed
      try {
            bancoHistorico = new BDDAOHistorico();
            int qnt = this.bancoHistorico.countJogosSalvos(this.login);
            
           
            if(qnt==0){
            JOptionPane.showMessageDialog(null,"Você não possui jogos salvos!");
            }
            
            else
            {    if(JOptionPane.showConfirmDialog(null,"Deseja realmente abandonar esta partida?",strings.getAtencao(),JOptionPane.YES_NO_OPTION )==0){  
                this.dispose();              
                new SalveGame(this.login, this.implemente).setVisible(true);}
            }
       
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
             }
      
    }//GEN-LAST:event_menuCarregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baralhoPlayDOIS;
    private javax.swing.JLabel baralhoPlayUM;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnProx;
    private javax.swing.JLabel cartaCINCOPlayDOIS;
    private javax.swing.JLabel cartaCINCOPlayUM;
    private javax.swing.JLabel cartaDOISPlayDOIS;
    private javax.swing.JLabel cartaDOISPlayUM;
    private javax.swing.JLabel cartaQUATROPlayDOIS;
    private javax.swing.JLabel cartaQUATROPlayUM;
    private javax.swing.JLabel cartaTRESPlayDOIS;
    private javax.swing.JLabel cartaTRESPlayUM;
    private javax.swing.JLabel cartaUMPlayDOIS;
    private javax.swing.JLabel cartaUMPlayUM;
    private javax.swing.JLabel energia1;
    private javax.swing.JLabel energia2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblCampoPlayDOIS;
    private javax.swing.JLabel lblCampoPlayUM;
    private javax.swing.JLabel lblCartas1;
    private javax.swing.JLabel lblCartas2;
    private javax.swing.JLabel lblEnergia2;
    private javax.swing.JLabel lblEnergiaVital1;
    private javax.swing.JLabel lblImagemPrincipal;
    private javax.swing.JLabel lblJuiz;
    private javax.swing.JLabel lblRegras1;
    private javax.swing.JLabel loginJogador1;
    private javax.swing.JLabel loginJogador2;
    private javax.swing.JMenuItem menuAbandonar;
    private javax.swing.JMenu menuApp;
    private javax.swing.JMenuItem menuCarregar;
    private javax.swing.JMenu menuJogo;
    private javax.swing.JMenuItem menuRank;
    private javax.swing.JMenuItem menuRegras;
    private javax.swing.JMenuItem menuRenicia;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JPanel painelPartida;
    private javax.swing.JLabel totalCartas1;
    private javax.swing.JLabel totalCartas2;
    private javax.swing.JTextPane txtJuiz;
    // End of variables declaration//GEN-END:variables
}
