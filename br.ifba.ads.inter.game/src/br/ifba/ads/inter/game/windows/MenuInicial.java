
package br.ifba.ads.inter.game.windows;


import br.ifba.ads.inter.game.windows.gameString.IString;
import javax.swing.JOptionPane;


public class MenuInicial extends javax.swing.JFrame {

protected IString strings;
private String implemente;

private CadastrarJogador menuCadastro;
private CarregarJogador menuLogin;

private Rank menuRank;
 
private MenuSobre menuSobre;
private MenuRegras menuRegras;

    public MenuInicial(String implemente) { 
    
    initComponents();
    this.implemente = implemente;
    
    try {
    this.strings = (IString) Class.forName(this.implemente).newInstance();
    
    
    } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
    this.menuCadastro = new CadastrarJogador(this.implemente);
    this.menuLogin = new CarregarJogador(this.implemente);
    this.menuSobre = new MenuSobre(this.implemente);
    this.menuRegras = new MenuRegras(this.implemente);
    this.menuRank = new Rank(this.implemente);
    this.plotarTitulos();
    }

private void plotarTitulos(){
    
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenu());
    this.btnCadastrarJogador.setText(strings.getMenuCadastro());
    this.btnLogarJogador.setText(strings.getMenuLogin());
    this.btnRank.setText(strings.getMenuRank());
    this.btnRegras.setText(strings.getMenuRegras());
    this.btnSobre.setText(strings.getMenuSobre());
    this.btnSair.setText(strings.getSair());

}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        btnLogarJogador = new javax.swing.JLabel();
        btnRank = new javax.swing.JLabel();
        btnSair = new javax.swing.JLabel();
        btnCadastrarJogador = new javax.swing.JLabel();
        btnSobre = new javax.swing.JLabel();
        btnRegras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Menu");
        setBackground(new java.awt.Color(51, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(778, 500));
        setMinimumSize(new java.awt.Dimension(700, 300));
        setName("MenuInicial"); // NOI18N
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${iconImage.graphics.clip.bounds2D.centerY}"), this, org.jdesktop.beansbinding.BeanProperty.create("iconImage"), "");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${iconImages}"), this, org.jdesktop.beansbinding.BeanProperty.create("iconImages"));
        bindingGroup.addBinding(binding);

        getContentPane().setLayout(null);

        btnLogarJogador.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnLogarJogador.setForeground(new java.awt.Color(255, 255, 255));
        btnLogarJogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogarJogador.setText("Login Jogador");
        btnLogarJogador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogarJogador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogarJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogarJogadorMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogarJogador);
        btnLogarJogador.setBounds(230, 180, 310, 33);

        btnRank.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnRank.setForeground(new java.awt.Color(255, 255, 255));
        btnRank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRank.setText("Rank");
        btnRank.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRankMouseClicked(evt);
            }
        });
        getContentPane().add(btnRank);
        btnRank.setBounds(230, 240, 310, 33);

        btnSair.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSair.setText("Sair");
        btnSair.setToolTipText("");
        btnSair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(230, 400, 310, 33);

        btnCadastrarJogador.setBackground(new java.awt.Color(255, 51, 0));
        btnCadastrarJogador.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnCadastrarJogador.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarJogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCadastrarJogador.setText("Cadastrar Jogador");
        btnCadastrarJogador.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(244, 255, 255), new java.awt.Color(0, 0, 0)));
        btnCadastrarJogador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrarJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarJogadorMouseClicked(evt);
            }
        });
        getContentPane().add(btnCadastrarJogador);
        btnCadastrarJogador.setBounds(230, 120, 310, 40);

        btnSobre.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnSobre.setForeground(new java.awt.Color(255, 255, 255));
        btnSobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSobre.setText("Sobre");
        btnSobre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSobreMouseClicked(evt);
            }
        });
        getContentPane().add(btnSobre);
        btnSobre.setBounds(230, 290, 310, 33);

        btnRegras.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        btnRegras.setForeground(new java.awt.Color(255, 255, 255));
        btnRegras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegras.setText("Regras");
        btnRegras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegras);
        btnRegras.setBounds(230, 340, 310, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/galaxia-217418.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 500);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarJogadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarJogadorMouseClicked
      this.menuCadastro.setVisible(true);
      this.dispose();
        
    }//GEN-LAST:event_btnCadastrarJogadorMouseClicked

    private void btnLogarJogadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogarJogadorMouseClicked
       this.menuLogin.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnLogarJogadorMouseClicked

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        this.fechar();
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnRankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankMouseClicked
       this.menuRank.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRankMouseClicked

    private void btnSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSobreMouseClicked
       this.menuSobre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSobreMouseClicked

    private void btnRegrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegrasMouseClicked
       this.menuRegras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegrasMouseClicked
private void fechar(){  
        if(JOptionPane.showConfirmDialog(null,strings.getDesejaSair(),strings.getAtencao(),JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();  
        }  
    }  
 
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCadastrarJogador;
    private javax.swing.JLabel btnLogarJogador;
    private javax.swing.JLabel btnRank;
    private javax.swing.JLabel btnRegras;
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel btnSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
