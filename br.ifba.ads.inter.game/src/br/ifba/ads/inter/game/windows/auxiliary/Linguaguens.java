
package br.ifba.ads.inter.game.windows.auxiliary;

import br.ifba.ads.inter.game.windows.MenuInicial;
import javax.swing.JOptionPane;



public class Linguaguens extends javax.swing.JFrame {

private static String implementePT = "br.ifba.ads.inter.game.windows.gameString.StringPT";
private static String implementeES = "br.ifba.ads.inter.game.windows.gameString.StringES";
    
    public Linguaguens() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        listaLinguas = new javax.swing.JComboBox();
        lblIdioma = new javax.swing.JLabel();
        lblNomeJogo = new javax.swing.JLabel();
        lblVersao = new javax.swing.JLabel();
        lblVersao1 = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem - vindo!");
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 330, 81, 33);

        listaLinguas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listaLinguas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Português (Brasil)", "English" }));
        getContentPane().add(listaLinguas);
        listaLinguas.setBounds(290, 260, 170, 32);

        lblIdioma.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lblIdioma.setForeground(new java.awt.Color(255, 255, 255));
        lblIdioma.setText("Trevas Em Luz");
        getContentPane().add(lblIdioma);
        lblIdioma.setBounds(30, 30, 330, 40);

        lblNomeJogo.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        lblNomeJogo.setText("Versão 1.10.3");
        getContentPane().add(lblNomeJogo);
        lblNomeJogo.setBounds(560, 430, 230, 33);

        lblVersao.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lblVersao.setText("Idioma:");
        getContentPane().add(lblVersao);
        lblVersao.setBounds(290, 190, 230, 33);

        lblVersao1.setFont(new java.awt.Font("Old English Text MT", 0, 50)); // NOI18N
        lblVersao1.setForeground(new java.awt.Color(255, 255, 255));
        lblVersao1.setText("Idioma:");
        getContentPane().add(lblVersao1);
        lblVersao1.setBounds(290, 190, 210, 33);

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/167550_Papel-de-Parede-Buraco-negro--167550_1600x1200.jpg"))); // NOI18N
        getContentPane().add(lblImagem);
        lblImagem.setBounds(-180, 0, 960, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(listaLinguas.getSelectedIndex() == 0){
       this.dispose();
           try {
               new MenuInicial(implementePT).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");} 
           
       }
       else if (listaLinguas.getSelectedIndex() == 1)
       {this.dispose();
         try {
               new MenuInicial(implementeES).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");} 
       }
    }//GEN-LAST:event_jButton1ActionPerformed

  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNomeJogo;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JLabel lblVersao1;
    private javax.swing.JComboBox listaLinguas;
    // End of variables declaration//GEN-END:variables
}
