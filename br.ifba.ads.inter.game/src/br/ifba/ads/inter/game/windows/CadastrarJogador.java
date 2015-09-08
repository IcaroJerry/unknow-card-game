
package br.ifba.ads.inter.game.windows;


import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import br.ifba.ads.inter.game.percistence.*;
import br.ifba.ads.inter.game.validation.ValidadorCadastro;
import br.ifba.ads.inter.game.windows.gameString.*;
import java.awt.Color;
import javax.swing.JOptionPane;



public class CadastrarJogador extends javax.swing.JFrame {
protected IString strings;
protected IDAOJogador bancoJogador;
private String implemente;

private LogarJogador novo = new LogarJogador();    
private ValidadorCadastro validador = new ValidadorCadastro();
private String mensagem = null;
private boolean existe;

public CadastrarJogador(String implemente){
        
        initComponents();
        this.implemente = implemente;
        try {
            
            this.strings = (IString) Class.forName(this.implemente).newInstance();
     
              try{   
              this.bancoJogador = new BDDAOJogador();
              } 
              catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");} 

        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
   this.plotarTitulos();   
}

private void plotarTitulos(){
    
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenuCadastro());
    
    this.lbllLogin.setText(strings.getLogin());
    this.lblSenha.setText(strings.getSenha());
    this.lblConfirma.setText(strings.getConfirmaSenha());
    this.lblFraseRecuperacao.setText(strings.getFraseRecuperacao());
    this.btnCancelar.setText(strings.getCancelar());
    this.btnCadastrar.setText(strings.getCadastrar()); 
    this.redefine();
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbllLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        labelErroLogin = new javax.swing.JLabel();
        labelErroConfirmacao = new javax.swing.JLabel();
        lblConfirma = new javax.swing.JLabel();
        lblFraseRecuperacao = new javax.swing.JLabel();
        txtFraseRecuperacao = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();
        labelErroSenha = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        lbllLogin.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        lbllLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbllLogin.setText("   Login:");
        lbllLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lbllLogin);
        lbllLogin.setBounds(110, 110, 140, 33);

        lblSenha.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("   Senha:");
        lblSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblSenha);
        lblSenha.setBounds(100, 160, 150, 36);

        txtLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });
        getContentPane().add(txtLogin);
        txtLogin.setBounds(270, 110, 220, 30);

        labelErroLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelErroLogin.setForeground(new java.awt.Color(0, 153, 0));
        labelErroLogin.setText("mensagem do login");
        getContentPane().add(labelErroLogin);
        labelErroLogin.setBounds(390, 80, 170, 17);

        labelErroConfirmacao.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelErroConfirmacao.setForeground(new java.awt.Color(255, 255, 255));
        labelErroConfirmacao.setText("Senhas não conferem, digite novamente!");
        getContentPane().add(labelErroConfirmacao);
        labelErroConfirmacao.setBounds(240, 290, 270, 17);

        lblConfirma.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        lblConfirma.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirma.setText("Confirmar Senha:");
        lblConfirma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblConfirma);
        lblConfirma.setBounds(50, 250, 220, 29);

        lblFraseRecuperacao.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        lblFraseRecuperacao.setForeground(new java.awt.Color(255, 255, 255));
        lblFraseRecuperacao.setText("Frase de Recuperação:");
        lblFraseRecuperacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblFraseRecuperacao);
        lblFraseRecuperacao.setBounds(20, 337, 440, 30);

        txtFraseRecuperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFraseRecuperacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFraseRecuperacao);
        txtFraseRecuperacao.setBounds(280, 340, 220, 30);

        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(270, 160, 220, 30);

        txtConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmacao);
        txtConfirmacao.setBounds(280, 250, 220, 30);

        labelErroSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelErroSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelErroSenha.setText("Senha deve conter entre 4 e 6 dígitos!");
        getContentPane().add(labelErroSenha);
        labelErroSenha.setBounds(230, 210, 290, 17);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/cancel_mni.jpg"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(420, 410, 150, 36);

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/cadastrar.jpg"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(163, 410, 140, 36);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/galaxia-217418.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed

    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtFraseRecuperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFraseRecuperacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFraseRecuperacaoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        try {
               new MenuInicial(this.implemente).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacaoActionPerformed
      
    }//GEN-LAST:event_txtConfirmacaoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        try{
        
         this.existe = this.bancoJogador.buscaJogador(txtLogin.getText());
         this.mensagem = validador.confirmaERRO(txtLogin.getText(),
                                       (new String(txtSenha.getPassword())),(new String(txtConfirmacao.getPassword())),
                                       txtFraseRecuperacao.getText(),existe);
         
         if( mensagem != null)
         {           
                 JOptionPane.showMessageDialog(null,mensagem);
                 labelErroConfirmacao.setVisible(validador.confereSenhas((new String(txtSenha.getPassword())), (new String(txtConfirmacao.getPassword()))));
                 
                 this.mostraErro(existe);
         }  
      
         else
         {  
                         novo.setLogin(txtLogin.getText());
                         novo.setFrase(txtFraseRecuperacao.getText()); 
                         novo.setSenha((new String(txtSenha.getPassword())));
                 this.bancoJogador.salvarJogador(novo.getLogin(), novo.getSenha(), novo.getFrase());
                 JOptionPane.showMessageDialog(null,"Jogador Cadastrado com Sucesso!");
                 this.dispose();
                 new MenuJogo(novo.getLogin(), this.implemente).setVisible(true); 
          
                   
          }
         }
      catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");}
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
   
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if(evt.getKeyChar() == ' '){
        JOptionPane.showMessageDialog(null, "Digíto Inválido!");
        }
    String campo = txtLogin.getText();
    txtLogin.setText(campo.replaceAll(" ", ""));
    this.redefine();
    }//GEN-LAST:event_txtLoginKeyPressed

private void redefine(){
         this.labelErroConfirmacao.setVisible(false);
        this.labelErroSenha.setVisible(false);
        this.labelErroLogin.setText("Login disponível!");
        this.labelErroLogin.setForeground(Color.GREEN);
        this.labelErroLogin.setVisible(false);

}
  
  public void mostraErro(boolean existe){
  
  
                          if((validador.tamanhoMax((new String(txtSenha.getPassword()))) == true)||
                             (validador.tamanhoMin((new String(txtSenha.getPassword()))) == true))
                          {labelErroSenha.setVisible(true);}
                          
                          if(validador.existeJogador(existe))
                          {   labelErroLogin.setText("Login já Cadastrado. Digite outro!");
                              labelErroLogin.setForeground(Color.RED);
                              labelErroLogin.setVisible(true);}
                          else{labelErroLogin.setVisible(true);}
  
  
  }
 
  
  
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelErroConfirmacao;
    private javax.swing.JLabel labelErroLogin;
    private javax.swing.JLabel labelErroSenha;
    private javax.swing.JLabel lblConfirma;
    private javax.swing.JLabel lblFraseRecuperacao;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lbllLogin;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JTextField txtFraseRecuperacao;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
