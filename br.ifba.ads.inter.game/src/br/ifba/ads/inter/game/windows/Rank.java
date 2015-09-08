
package br.ifba.ads.inter.game.windows;

import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import br.ifba.ads.inter.game.percistence.*;
import br.ifba.ads.inter.game.windows.gameString.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class Rank extends javax.swing.JFrame  {

    protected IString strings;
    private String implemente;
    protected IDAOWindows banco;
    
    public Rank(String implemente)  {
        initComponents();
        this.implemente = implemente;
    
    try {
              this.strings = (IString) Class.forName(this.implemente).newInstance();
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
    try {
          this.banco = new BDDAOWindows();
          this.atualizaRank();
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "ERRO NO SERVIDOR!");
      }
    
      this.plotarTitulos();
    }
 
 public void apagarBotao(){
 this.btnvoltar.setVisible(false);
 this.btnOK.setVisible(true);
 
 }   
    
private void plotarTitulos(){
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenuRank());

    this.lblLogin.setText(strings.getLogin());
    this.lblVitorias.setText(strings.getVitorias());
    this.btnvoltar.setText(strings.getVoltar());
    this.btnOK.setVisible(false);

}
public void atualizaRank() throws Exception{

List<LogarJogador> jogadores = this.banco.atualizarRank();
    try{
    nomeJogador1.setText(jogadores.get(0).getLogin());   contJogador1.setText(""+jogadores.get(0).getCont());
   
    nomeJogador2.setText(jogadores.get(1).getLogin());   contJogador2.setText(""+jogadores.get(1).getCont());
    
    nomeJogador3.setText(jogadores.get(2).getLogin());   contJogador3.setText(""+jogadores.get(2).getCont());
   
    nomeJogador4.setText(jogadores.get(3).getLogin());   contJogador4.setText(""+jogadores.get(3).getCont());
    
    }
    catch (Exception e){
   
  
    }

}



    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblVitorias = new javax.swing.JLabel();
        nomeJogador4 = new javax.swing.JLabel();
        contJogador1 = new javax.swing.JLabel();
        nomeJogador1 = new javax.swing.JLabel();
        contJogador2 = new javax.swing.JLabel();
        nomeJogador2 = new javax.swing.JLabel();
        contJogador3 = new javax.swing.JLabel();
        nomeJogador3 = new javax.swing.JLabel();
        contJogador4 = new javax.swing.JLabel();
        btnvoltar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Rank");
        setBackground(new java.awt.Color(255, 255, 204));
        setForeground(new java.awt.Color(255, 255, 204));
        setPreferredSize(new java.awt.Dimension(696, 691));
        setResizable(false);
        getContentPane().setLayout(null);

        lblLogin.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblLogin);
        lblLogin.setBounds(200, 50, 210, 50);

        lblVitorias.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lblVitorias.setForeground(new java.awt.Color(255, 255, 255));
        lblVitorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVitorias.setText("Vitórias");
        lblVitorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblVitorias);
        lblVitorias.setBounds(450, 50, 190, 50);

        nomeJogador4.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 1, 30)); // NOI18N
        nomeJogador4.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador4.setText("Jogador_4");
        getContentPane().add(nomeJogador4);
        nomeJogador4.setBounds(200, 520, 240, 39);

        contJogador1.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        contJogador1.setForeground(new java.awt.Color(255, 255, 255));
        contJogador1.setText("0");
        getContentPane().add(contJogador1);
        contJogador1.setBounds(530, 140, 120, 50);

        nomeJogador1.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 1, 30)); // NOI18N
        nomeJogador1.setText("Jogador_1");
        getContentPane().add(nomeJogador1);
        nomeJogador1.setBounds(210, 130, 270, 50);

        contJogador2.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        contJogador2.setForeground(new java.awt.Color(255, 255, 255));
        contJogador2.setText("0");
        getContentPane().add(contJogador2);
        contJogador2.setBounds(540, 240, 120, 76);

        nomeJogador2.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 1, 30)); // NOI18N
        nomeJogador2.setText("Jogador_2");
        getContentPane().add(nomeJogador2);
        nomeJogador2.setBounds(210, 250, 260, 50);

        contJogador3.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        contJogador3.setForeground(new java.awt.Color(255, 255, 255));
        contJogador3.setText("0");
        getContentPane().add(contJogador3);
        contJogador3.setBounds(540, 390, 110, 57);

        nomeJogador3.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 1, 30)); // NOI18N
        nomeJogador3.setText("Jogador_3");
        getContentPane().add(nomeJogador3);
        nomeJogador3.setBounds(210, 390, 250, 50);

        contJogador4.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        contJogador4.setForeground(new java.awt.Color(255, 255, 255));
        contJogador4.setText("0");
        getContentPane().add(contJogador4);
        contJogador4.setBounds(540, 510, 110, 57);

        btnvoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/voltar.jpg"))); // NOI18N
        btnvoltar.setText("Voltar");
        btnvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnvoltar);
        btnvoltar.setBounds(510, 600, 140, 38);

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/ok.jpg"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK);
        btnOK.setBounds(320, 600, 140, 38);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/tela_rank.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoltarActionPerformed
           this.dispose();
           new MenuInicial(this.implemente).setVisible(true);
          
     
    }//GEN-LAST:event_btnvoltarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnvoltar;
    private javax.swing.JLabel contJogador1;
    private javax.swing.JLabel contJogador2;
    private javax.swing.JLabel contJogador3;
    private javax.swing.JLabel contJogador4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblVitorias;
    private javax.swing.JLabel nomeJogador1;
    private javax.swing.JLabel nomeJogador2;
    private javax.swing.JLabel nomeJogador3;
    private javax.swing.JLabel nomeJogador4;
    // End of variables declaration//GEN-END:variables
}
