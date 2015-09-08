
package br.ifba.ads.inter.game.windows.auxiliary;


import br.ifba.ads.inter.game.percistence.BDDAOJogador;
import br.ifba.ads.inter.game.percistence.IDAOJogador;
import br.ifba.ads.inter.game.windows.MenuJogo;
import br.ifba.ads.inter.game.windows.gameString.IString;
import br.ifba.ads.inter.game.windows.gameString.StringPT;
import javax.swing.JOptionPane;



public class TrocarFrase extends javax.swing.JFrame {

    protected IString strings; 
    protected IDAOJogador bancoJogador;
    
    private String login;
    private String implemente;
    MenuJogo menu;
    
    public TrocarFrase(String login,String implemente) {
        initComponents();
        this.implemente = implemente;
        
        try {   
             this.strings = (IString) Class.forName(this.implemente).newInstance();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
        
        this.login = login;

        menu = new MenuJogo(this.login, this.implemente);
        menu.setVisible(true);
        menu.setEnabled(false);
        
        this.plotarTitulos();
    }

    
  private void plotarTitulos(){
    this.setTitle(strings.getNomeJogo()+" - "+ this.login);
        try {
            this.bancoJogador = new BDDAOJogador();
            this.txtAntigo.setText(bancoJogador.buscaFrase(this.login));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
        }
    
  }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegras1 = new javax.swing.JLabel();
        btnVoltar1 = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtNovo = new javax.swing.JTextField();
        txtAntigo = new javax.swing.JTextField();
        lblRegras2 = new javax.swing.JLabel();
        lblDesenvolvedores = new javax.swing.JLabel();
        lblDesenvolvedores1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegras1.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblRegras1.setText("Trocar");

        btnVoltar1.setText("Confirmar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        btnVoltar.setText("Cancelar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtAntigo.setEditable(false);
        txtAntigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAntigo.setText("exemploteste");
        txtAntigo.setToolTipText("");
        txtAntigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAntigoActionPerformed(evt);
            }
        });

        lblRegras2.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblRegras2.setText("frase:");

        lblDesenvolvedores.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblDesenvolvedores.setText("Frase antiga:");

        lblDesenvolvedores1.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblDesenvolvedores1.setText("Nova frase:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblRegras2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDesenvolvedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAntigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDesenvolvedores1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(lblRegras1)
                    .addContainerGap(379, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblRegras2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesenvolvedores)
                    .addComponent(txtAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDesenvolvedores1)
                    .addComponent(txtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(lblRegras1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
    try {
        bancoJogador.updateFrase(this.login, this.txtNovo.getText()); 
        menu.setEnabled(true);
        this.dispose();
    } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
        }
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
      menu.setEnabled(true);
      this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtAntigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAntigoActionPerformed
        
    }//GEN-LAST:event_txtAntigoActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel lblDesenvolvedores;
    private javax.swing.JLabel lblDesenvolvedores1;
    private javax.swing.JLabel lblRegras1;
    private javax.swing.JLabel lblRegras2;
    private javax.swing.JTextField txtAntigo;
    private javax.swing.JTextField txtNovo;
    // End of variables declaration//GEN-END:variables
}
