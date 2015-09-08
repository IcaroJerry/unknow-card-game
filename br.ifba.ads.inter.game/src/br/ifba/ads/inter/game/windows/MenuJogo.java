package br.ifba.ads.inter.game.windows;

import br.ifba.ads.inter.game.model.appGame.Partida;
import br.ifba.ads.inter.game.percistence.*;
import br.ifba.ads.inter.game.windows.auxiliary.SalveGame;
import br.ifba.ads.inter.game.windows.auxiliary.TrocarFrase;
import br.ifba.ads.inter.game.windows.auxiliary.TrocarSenha;
import br.ifba.ads.inter.game.windows.gameString.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuJogo extends javax.swing.JFrame {

    private String login;
    private IString strings; 
    private String implemente;
    
    protected IDAOHistorico banco;

    
    public MenuJogo(String login, String implemente) {
        initComponents();
        this.login = login;
        this.implemente = implemente;
        try {   
             this.strings = (IString) Class.forName(this.implemente).newInstance();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
        this.btnIniciar.setVisible(false);
        this.painelModalidade.setVisible(false);
       
        try {
        this.banco = new BDDAOHistorico();
             } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
             }
        
    this.plotarTitulos();
    }

private void plotarTitulos(){
        this.setTitle(strings.getNomeJogo()+" - "+this.login);
        this.mensagemModoJogo.setVisible(false);
        this.mensagemErroJogo.setVisible(false);
        

}    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModalidade = new javax.swing.ButtonGroup();
        btnCarregarJogo = new javax.swing.JLabel();
        btnNovoJogo = new javax.swing.JLabel();
        mensagemModoJogo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        mensagemErroJogo = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        painelModalidade = new javax.swing.JPanel();
        radioFacil = new javax.swing.JRadioButton();
        radioMedio = new javax.swing.JRadioButton();
        radioDificil = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        barraMenuJogo = new javax.swing.JMenuBar();
        menuApp = new javax.swing.JMenu();
        menuRank = new javax.swing.JMenuItem();
        menuRegras = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuConta = new javax.swing.JMenu();
        alterarSenha = new javax.swing.JMenuItem();
        alterarFrase = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        btnCarregarJogo.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        btnCarregarJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnCarregarJogo.setText("     Carregar Jogo");
        btnCarregarJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCarregarJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarregarJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarregarJogoMouseClicked(evt);
            }
        });
        getContentPane().add(btnCarregarJogo);
        btnCarregarJogo.setBounds(220, 70, 340, 50);

        btnNovoJogo.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        btnNovoJogo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoJogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNovoJogo.setText("Novo Jogo");
        btnNovoJogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNovoJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoJogoMouseClicked(evt);
            }
        });
        getContentPane().add(btnNovoJogo);
        btnNovoJogo.setBounds(220, 180, 340, 50);

        mensagemModoJogo.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        mensagemModoJogo.setForeground(new java.awt.Color(255, 255, 255));
        mensagemModoJogo.setText("Selecione um modo antes de comçar o jogo!");
        getContentPane().add(mensagemModoJogo);
        mensagemModoJogo.setBounds(190, 250, 410, 19);

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/voltar.jpg"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(230, 360, 130, 40);

        mensagemErroJogo.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        mensagemErroJogo.setForeground(new java.awt.Color(255, 255, 255));
        mensagemErroJogo.setText("Você não possuem Jogos Salvos!");
        getContentPane().add(mensagemErroJogo);
        mensagemErroJogo.setBounds(240, 140, 300, 22);

        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/ok.jpg"))); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar);
        btnIniciar.setBounds(430, 360, 150, 42);

        painelModalidade.setBackground(new java.awt.Color(0, 0, 0));
        painelModalidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        radioFacil.setBackground(new java.awt.Color(0, 0, 0));
        grupoModalidade.add(radioFacil);
        radioFacil.setForeground(new java.awt.Color(255, 255, 255));
        radioFacil.setSelected(true);
        radioFacil.setText("Fácil");

        radioMedio.setBackground(new java.awt.Color(0, 0, 0));
        grupoModalidade.add(radioMedio);
        radioMedio.setForeground(new java.awt.Color(255, 255, 255));
        radioMedio.setText("Médio");

        radioDificil.setBackground(new java.awt.Color(0, 0, 0));
        grupoModalidade.add(radioDificil);
        radioDificil.setForeground(new java.awt.Color(255, 255, 255));
        radioDificil.setText("Difícil");

        javax.swing.GroupLayout painelModalidadeLayout = new javax.swing.GroupLayout(painelModalidade);
        painelModalidade.setLayout(painelModalidadeLayout);
        painelModalidadeLayout.setHorizontalGroup(
            painelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelModalidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioFacil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(radioMedio)
                .addGap(18, 18, 18)
                .addComponent(radioDificil)
                .addContainerGap())
        );
        painelModalidadeLayout.setVerticalGroup(
            painelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelModalidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioFacil)
                    .addComponent(radioMedio)
                    .addComponent(radioDificil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelModalidade);
        painelModalidade.setBounds(290, 280, 210, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/artleo.com-10451.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -50, 1060, 540);

        barraMenuJogo.setBackground(new java.awt.Color(0, 0, 102));
        barraMenuJogo.setForeground(new java.awt.Color(255, 255, 255));

        menuApp.setForeground(new java.awt.Color(255, 255, 255));
        menuApp.setText("Menu");

        menuRank.setBackground(new java.awt.Color(0, 0, 0));
        menuRank.setForeground(new java.awt.Color(255, 255, 255));
        menuRank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/coroa_ouro.jpg"))); // NOI18N
        menuRank.setText("Rank");
        menuRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRankActionPerformed(evt);
            }
        });
        menuApp.add(menuRank);

        menuRegras.setBackground(new java.awt.Color(0, 0, 0));
        menuRegras.setForeground(new java.awt.Color(255, 255, 255));
        menuRegras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/carta.jpg"))); // NOI18N
        menuRegras.setText("Regras");
        menuRegras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegrasActionPerformed(evt);
            }
        });
        menuApp.add(menuRegras);

        menuSobre.setBackground(new java.awt.Color(0, 0, 0));
        menuSobre.setForeground(new java.awt.Color(255, 255, 255));
        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/logoUnic.jpg"))); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuApp.add(menuSobre);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        menuApp.add(jSeparator1);

        menuSair.setBackground(new java.awt.Color(0, 0, 0));
        menuSair.setForeground(new java.awt.Color(255, 255, 255));
        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/exit.jpg"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuApp.add(menuSair);

        barraMenuJogo.add(menuApp);

        menuConta.setForeground(new java.awt.Color(255, 255, 255));
        menuConta.setText("Conta Jogador");

        alterarSenha.setBackground(new java.awt.Color(0, 0, 102));
        alterarSenha.setForeground(new java.awt.Color(255, 255, 255));
        alterarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/senha.jpg"))); // NOI18N
        alterarSenha.setText("Alterar Senha");
        alterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarSenhaActionPerformed(evt);
            }
        });
        menuConta.add(alterarSenha);

        alterarFrase.setBackground(new java.awt.Color(0, 0, 102));
        alterarFrase.setForeground(new java.awt.Color(255, 255, 255));
        alterarFrase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/frase.jpg"))); // NOI18N
        alterarFrase.setText("Alterar Frase de Recuperação");
        alterarFrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarFraseActionPerformed(evt);
            }
        });
        menuConta.add(alterarFrase);

        barraMenuJogo.add(menuConta);

        setJMenuBar(barraMenuJogo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
      this.dispose();
        try {
               new MenuInicial(this.implemente).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}

    }//GEN-LAST:event_btnVoltarActionPerformed

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

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.dispose();
        try {
            new AppJogo(this.login,this.implemente,new Partida(this.login)).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR PARTIDA!");
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnNovoJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoJogoMouseClicked
        painelModalidade.setVisible(true);
        btnIniciar.setVisible(true);
    }//GEN-LAST:event_btnNovoJogoMouseClicked

    private void alterarFraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarFraseActionPerformed
        this.dispose();
        new TrocarFrase(this.login, this.implemente).setVisible(true);
    }//GEN-LAST:event_alterarFraseActionPerformed

    private void alterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarSenhaActionPerformed
        this.dispose();
        new TrocarSenha(this.login, this.implemente).setVisible(true);
    }//GEN-LAST:event_alterarSenhaActionPerformed

    private void btnCarregarJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarJogoMouseClicked
        try {
             
            int qnt = this.banco.countJogosSalvos(login);

            if(qnt==0){
            JOptionPane.showMessageDialog(null,"Você não possui jogos salvos!");
            }
            
            else
            {
                this.dispose(); 
                new SalveGame(this.login, this.implemente).setVisible(true);
            }
        
        } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
        }
       
    }//GEN-LAST:event_btnCarregarJogoMouseClicked

    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem alterarFrase;
    private javax.swing.JMenuItem alterarSenha;
    private javax.swing.JMenuBar barraMenuJogo;
    private javax.swing.JLabel btnCarregarJogo;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel btnNovoJogo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup grupoModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel mensagemErroJogo;
    private javax.swing.JLabel mensagemModoJogo;
    private javax.swing.JMenu menuApp;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenuItem menuRank;
    private javax.swing.JMenuItem menuRegras;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JPanel painelModalidade;
    private javax.swing.JRadioButton radioDificil;
    private javax.swing.JRadioButton radioFacil;
    private javax.swing.JRadioButton radioMedio;
    // End of variables declaration//GEN-END:variables
}
