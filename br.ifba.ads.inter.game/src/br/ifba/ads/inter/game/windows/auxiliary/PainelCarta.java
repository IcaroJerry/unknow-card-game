package br.ifba.ads.inter.game.windows.auxiliary;

import javax.swing.*;

public class PainelCarta extends JFrame {

    protected String implemente;
    private String  cod = null;
   
     
     
    public PainelCarta(String implemente, String cod) {
        initComponents();
        this.implemente = implemente;

        
        if(cod != null)
        {
            this.lblCartaGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/"+cod+".jpg")));   
                        this.cod = cod;
        }   
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCartaGrande = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel de Carta");
        setMinimumSize(new java.awt.Dimension(393, 600));
        setModalExclusionType(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        lblCartaGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/Fogo_Carta_Vazia.jpg"))); // NOI18N
        getContentPane().add(lblCartaGrande);
        lblCartaGrande.setBounds(50, 40, 300, 444);

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setText("OK");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(140, 500, 90, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/167550_Papel-de-Parede-Buraco-negro--167550_1600x1200.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-190, -10, 780, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       this.dispose();
    }//GEN-LAST:event_formWindowClosed

    
    public void setImage(String cod){
    this.lblCartaGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/"+cod+".jpg")));   
    }
    
    
    public String getCod() {
        return cod;
    }
    public void setVisibleBtnVoltar(boolean visible){
    this.btnVoltar.setVisible(visible);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCartaGrande;
    // End of variables declaration//GEN-END:variables
}
