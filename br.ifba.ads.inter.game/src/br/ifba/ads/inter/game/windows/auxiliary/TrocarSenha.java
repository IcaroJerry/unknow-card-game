package br.ifba.ads.inter.game.windows.auxiliary;


import br.ifba.ads.inter.game.percistence.BDDAOJogador;
import br.ifba.ads.inter.game.percistence.IDAOJogador;
import br.ifba.ads.inter.game.validation.ValidadorCadastro;
import br.ifba.ads.inter.game.windows.MenuJogo;
import br.ifba.ads.inter.game.windows.gameString.*;
import javax.swing.JOptionPane;

public class TrocarSenha extends javax.swing.JFrame {

    protected IString strings; 
    protected IDAOJogador bancoJogador;
    
    private boolean existe;
    private String mensagem;
    private String login;
    private String implemente;
    private ValidadorCadastro validador;
    MenuJogo menu;
    
    
    
    public TrocarSenha(String login, String implemente) {
        initComponents();
        this.implemente = implemente;
        this.validador = new ValidadorCadastro();
        
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
        }

    
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegras = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        lblRegras1 = new javax.swing.JLabel();
        txtSenhaAntiga = new javax.swing.JPasswordField();
        txtSenhaNova = new javax.swing.JPasswordField();
        txtConfirma = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegras.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblRegras.setText("senha:");

        btnVoltar.setText("Cancelar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnVoltar1.setText("Confirmar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        lblRegras1.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lblRegras1.setText("Trocar");

        jLabel1.setText("Senha antiga:");

        jLabel2.setText("Nova senha:");

        jLabel3.setText("Confirmar senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegras1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRegras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegras1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
      menu.setEnabled(true);
      this.dispose(); 
          
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
try {   
        this.existe = bancoJogador.buscaJogador(this.login, (new String(this.txtSenhaAntiga.getPassword())));
    
        if(existe){
        JOptionPane.showMessageDialog(null,this.validador.confirmaERROBD(existe));
        }
        else{
        this.mensagem = validador.confirmaERRO((new String(this.txtSenhaNova.getPassword())),
                                             (new String(this.txtConfirma.getPassword())));
      
        if(this.mensagem != null)
        { JOptionPane.showMessageDialog(null,mensagem);}
          
        else
         {   bancoJogador.updateSenha(this.login,new String(txtSenhaNova.getPassword())); 
            menu.setEnabled(true);
            this.dispose();    
        } 
      }
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
        }
      
        
      
    
    }//GEN-LAST:event_btnVoltar1ActionPerformed


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblRegras;
    private javax.swing.JLabel lblRegras1;
    private javax.swing.JPasswordField txtConfirma;
    private javax.swing.JPasswordField txtSenhaAntiga;
    private javax.swing.JPasswordField txtSenhaNova;
    // End of variables declaration//GEN-END:variables
}
