
package br.ifba.ads.inter.game.windows;

import br.ifba.ads.inter.game.windows.gameString.*;
import javax.swing.JOptionPane;

public class MenuSobre extends javax.swing.JFrame {
  
    protected IString strings; 
    private String implemente;
    
    public MenuSobre(String implemente) {
        initComponents();
       this.implemente = implemente;
    
        try {
              this.strings = (IString) Class.forName(this.implemente).newInstance();
             }

        catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
        
        this.plotarTitulos();
    }
    
     public void apagarBotao(){
        this.btnVoltar.setVisible(false);
        this.btnOK.setVisible(true);
     }      
    
private void plotarTitulos(){
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenuSobre());
    
    this.btnVoltar.setText(strings.getVoltar());
    this.lblCriador.setText(strings.getCriador());
    this.lblDesenvolvedores.setText(strings.getDesenvolvedores());
    this.labelTitulo.setText(strings.getInfoTecnicas());
    this.lblVersao.setText(strings.getVersao());
    this.caixaInfo.setText(strings.getTxtInfo());
    
    this.btnOK.setVisible(false);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        painelEquipe = new javax.swing.JPanel();
        labelRodrigo = new javax.swing.JLabel();
        labelBruno = new javax.swing.JLabel();
        labelIcaro = new javax.swing.JLabel();
        labelLuis = new javax.swing.JLabel();
        labelHelislana = new javax.swing.JLabel();
        imagem = new javax.swing.JLabel();
        lblDesenvolvedores = new javax.swing.JLabel();
        caixaInfo = new java.awt.TextArea();
        btnVoltar = new javax.swing.JButton();
        lblVersao = new javax.swing.JLabel();
        lblCriador = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Sobre");
        setPreferredSize(new java.awt.Dimension(810, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Informações Técnicas");
        getContentPane().add(labelTitulo);
        labelTitulo.setBounds(50, 30, 420, 50);

        painelEquipe.setBackground(new java.awt.Color(51, 0, 51));

        labelRodrigo.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelRodrigo.setForeground(new java.awt.Color(255, 255, 255));
        labelRodrigo.setText("Rodrigo Brito");

        labelBruno.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelBruno.setForeground(new java.awt.Color(255, 255, 255));
        labelBruno.setText("Bruno Araújo");

        labelIcaro.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelIcaro.setForeground(new java.awt.Color(255, 255, 255));
        labelIcaro.setText("Ícaro Jerry");

        labelLuis.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelLuis.setForeground(new java.awt.Color(255, 255, 255));
        labelLuis.setText("Luis Belo");

        labelHelislana.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelHelislana.setForeground(new java.awt.Color(255, 255, 255));
        labelHelislana.setText("Helislana Freitas");

        imagem.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/LoGo.jpg"))); // NOI18N

        javax.swing.GroupLayout painelEquipeLayout = new javax.swing.GroupLayout(painelEquipe);
        painelEquipe.setLayout(painelEquipeLayout);
        painelEquipeLayout.setHorizontalGroup(
            painelEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEquipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBruno)
                    .addGroup(painelEquipeLayout.createSequentialGroup()
                        .addGroup(painelEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIcaro)
                            .addComponent(labelHelislana)
                            .addComponent(labelLuis)
                            .addComponent(labelRodrigo))
                        .addGap(18, 18, 18)
                        .addComponent(imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelEquipeLayout.setVerticalGroup(
            painelEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEquipeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBruno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEquipeLayout.createSequentialGroup()
                        .addComponent(labelIcaro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHelislana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLuis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelRodrigo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(painelEquipe);
        painelEquipe.setBounds(469, 320, 300, 220);

        lblDesenvolvedores.setBackground(new java.awt.Color(255, 255, 255));
        lblDesenvolvedores.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        lblDesenvolvedores.setForeground(new java.awt.Color(255, 255, 255));
        lblDesenvolvedores.setText("Desenvolvedores:");
        getContentPane().add(lblDesenvolvedores);
        lblDesenvolvedores.setBounds(470, 280, 220, 33);

        caixaInfo.setEditable(false);
        getContentPane().add(caixaInfo);
        caixaInfo.setBounds(60, 100, 337, 301);

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/voltar.jpg"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(630, 600, 120, 44);

        lblVersao.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblVersao.setForeground(new java.awt.Color(255, 255, 255));
        lblVersao.setText("Versão: 1.2");
        getContentPane().add(lblVersao);
        lblVersao.setBounds(290, 410, 110, 24);

        lblCriador.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        lblCriador.setForeground(new java.awt.Color(255, 255, 255));
        lblCriador.setText("Criado por: Márcio Jóse");
        getContentPane().add(lblCriador);
        lblCriador.setBounds(580, 60, 180, 20);

        btnOK.setBackground(new java.awt.Color(255, 255, 255));
        btnOK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/ok.jpg"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK);
        btnOK.setBounds(480, 600, 96, 43);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/tela_sobre.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 890, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
         this.dispose();
        try {
               new MenuInicial(this.implemente).setVisible(true);
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnVoltar;
    private java.awt.TextArea caixaInfo;
    private javax.swing.JLabel imagem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelBruno;
    private javax.swing.JLabel labelHelislana;
    private javax.swing.JLabel labelIcaro;
    private javax.swing.JLabel labelLuis;
    private javax.swing.JLabel labelRodrigo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel lblCriador;
    private javax.swing.JLabel lblDesenvolvedores;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JPanel painelEquipe;
    // End of variables declaration//GEN-END:variables
}
