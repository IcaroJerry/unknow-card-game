
package br.ifba.ads.inter.game.windows;


import br.ifba.ads.inter.game.model.appGame.LogarJogador;
import br.ifba.ads.inter.game.percistence.*;
import br.ifba.ads.inter.game.validation.ValidadorCadastro;
import br.ifba.ads.inter.game.windows.gameString.*;
import javax.swing.JOptionPane;

public class CarregarJogador extends javax.swing.JFrame {
    
    protected IString strings; 
    protected IDAOJogador bancoJogador;
    private String implemente;
    
    
    private String mensagem;
    private boolean existe;
    private LogarJogador jogador = new LogarJogador();
    private ValidadorCadastro validador = new ValidadorCadastro();
    
    public CarregarJogador(String implemente) {
    initComponents();
    this.implemente = implemente;
    
    try {
           this.strings = (IString) Class.forName(this.implemente).newInstance();
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
   this.plotarTitulos();
    }
    
private void plotarTitulos(){
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenuLogin());
    
    this.labelLogin.setText(strings.getLogin());
    this.labelSenha.setText(strings.getSenha());
    this.radioSenha.setText(strings.getLembrarSenha());
    this.btnLogar.setText(strings.getEntrar());
    this.btnCancelar.setText(strings.getCancelar());
    this.lblFraseRecuperacao.setVisible(false);
    this.labelErro.setVisible(false);
    this.labelErroLogin.setVisible(false);
}
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblFraseRecuperacao = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        labelErro = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        radioSenha = new javax.swing.JRadioButton();
        txtSenha = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        labelErroLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("menuInicial"); // NOI18N
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        lblFraseRecuperacao.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        lblFraseRecuperacao.setForeground(new java.awt.Color(255, 0, 0));
        lblFraseRecuperacao.setText("Frase de RECUPERACAO");
        getContentPane().add(lblFraseRecuperacao);
        lblFraseRecuperacao.setBounds(50, 390, 286, 26);

        labelLogin.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin.setText("   Login:");
        getContentPane().add(labelLogin);
        labelLogin.setBounds(140, 170, 160, 33);

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
        txtLogin.setBounds(310, 170, 220, 30);

        labelSenha.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelSenha.setText("   Senha:");
        getContentPane().add(labelSenha);
        labelSenha.setBounds(140, 230, 160, 33);

        labelErro.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        labelErro.setForeground(new java.awt.Color(255, 0, 0));
        labelErro.setText("MENSAGEM DE ERRO!");
        getContentPane().add(labelErro);
        labelErro.setBounds(320, 280, 191, 26);

        btnLogar.setBackground(new java.awt.Color(255, 255, 255));
        btnLogar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/chave.jpg"))); // NOI18N
        btnLogar.setText("Entrar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogar);
        btnLogar.setBounds(310, 340, 110, 36);

        radioSenha.setBackground(new java.awt.Color(0, 0, 0));
        radioSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioSenha.setForeground(new java.awt.Color(255, 255, 255));
        radioSenha.setText("Esqueci minha senha:");
        radioSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(radioSenha);
        radioSenha.setBounds(50, 360, 200, 25);

        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(310, 230, 220, 30);

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
        btnCancelar.setBounds(460, 340, 130, 38);

        labelErroLogin.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        labelErroLogin.setForeground(new java.awt.Color(255, 0, 0));
        labelErroLogin.setText("Login inválido");
        getContentPane().add(labelErroLogin);
        labelErroLogin.setBounds(310, 140, 191, 26);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/galaxia-217418.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void radioSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSenhaActionPerformed
      if(this.radioSenha.isSelected())    
      {
        if(txtLogin.getText().isEmpty())    {lblFraseRecuperacao.setText("Nenhum Login foi digitado!");}
        
        else { 
            try {
                this.bancoJogador =  new BDDAOJogador();
                this.mensagem = this.bancoJogador.buscaFrase(txtLogin.getText());
             }    
   
                    catch (Exception ex) {      
                            JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
                                        }   
            
                if(this.mensagem == null){ lblFraseRecuperacao.setText("Login Inválido!"); }
                else{lblFraseRecuperacao.setText(this.mensagem);}    
          
            
        
        
        }
      this.lblFraseRecuperacao.setVisible(true);
      }
           
        else  {lblFraseRecuperacao.setVisible(false);}
        
      
    }//GEN-LAST:event_radioSenhaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
        try {
               new MenuInicial(this.implemente).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaKeyTyped

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
       radioSenha.setSelected(false);
       this.lblFraseRecuperacao.setVisible(false);
    }//GEN-LAST:event_txtLoginKeyPressed

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
   
        try {
         this.bancoJogador =  new BDDAOJogador();
         this.existe = this.bancoJogador.buscaJogador(this.txtLogin.getText(),new String(this.txtSenha.getPassword()));
         this.mensagem = this.validador.confirmaERRO(this.txtLogin.getText(),
                                       (new String(this.txtSenha.getPassword())),existe);
         
         
         if( mensagem != null)   
                 JOptionPane.showMessageDialog(null,mensagem);
          else
         {       
                 jogador.setLogin(this.txtLogin.getText());  
                 this.dispose();
                 new MenuJogo(jogador.getLogin(), this.implemente).setVisible(true); 
          }
         }    
   
         catch (Exception ex) {      
             JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");
                }

        
    }//GEN-LAST:event_btnLogarActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelErro;
    private javax.swing.JLabel labelErroLogin;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel lblFraseRecuperacao;
    private javax.swing.JRadioButton radioSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
