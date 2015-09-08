package br.ifba.ads.inter.game.windows;

import br.ifba.ads.inter.game.windows.gameString.*;
import javax.swing.JOptionPane;

public class MenuRegras extends javax.swing.JFrame {
 
protected IString strings; 
private String implemente;

    public MenuRegras(String implemente) {
        initComponents();
        this.implemente = implemente;
    
        try {
              this.strings = (IString) Class.forName(this.implemente).newInstance();
           } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
    
        this.plotarTitulos();
    
    
    }
    
     public void apagarBotao(){
     this.btnVoltar.setVisible(false);
     this.btnOK.setVisible(true);
     }     

private void plotarTitulos(){
    this.setTitle(strings.getNomeJogo()+" - "+strings.getMenuRegras());  
    this.lblRegras.setText(strings.getRegras());
    this.painelEstruturaCartas.setTitleAt(0, strings.getRegrasBasicas());
    this.painelEstruturaCartas.setTitleAt(1, strings.getEstruturasCartas());
    this.painelEstruturaCartas.setTitleAt(2, strings.getRegrasEspecificas());
    this.btnVoltar.setText(strings.getVoltar());
    this.txtEspecifico.setText(strings.getTxtRegrasBasicas());
    this.txtBasicas.setText(strings.getTxtRegrasEspeficas());
    this.txtEstruturas.setText(strings.getTxtEstruturaCartas());
    
    this.btnOK.setVisible(false);
}  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegras = new javax.swing.JLabel();
        painelRegras = new javax.swing.JPanel();
        painelEstruturaCartas = new javax.swing.JTabbedPane();
        painelEsfecifico = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEspecifico = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEstruturas = new javax.swing.JTextArea();
        painelEstrutura = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBasicas = new javax.swing.JTextArea();
        btnVoltar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Light in Darkness - Regras");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(778, 500));
        setMinimumSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        lblRegras.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lblRegras.setForeground(new java.awt.Color(255, 255, 255));
        lblRegras.setText("Regras:");
        getContentPane().add(lblRegras);
        lblRegras.setBounds(50, 30, 180, 50);

        painelRegras.setBackground(new java.awt.Color(0, 0, 0));
        painelRegras.setLayout(null);

        painelEstruturaCartas.setBackground(new java.awt.Color(0, 0, 0));
        painelEstruturaCartas.setForeground(new java.awt.Color(255, 255, 255));

        painelEsfecifico.setBackground(new java.awt.Color(0, 0, 0));

        txtEspecifico.setEditable(false);
        txtEspecifico.setColumns(20);
        txtEspecifico.setRows(5);
        txtEspecifico.setText("1ª Cada jogador inicia com 30 pontos de Energia Vital, e com 5 cartas na mão. \n2ª Ganha o jogador que conseguir tirar todos os pontos de Energia Vital ou que tiver este maior do que o do outro caso as cartas acabem.\n3ª Apesar da mesma quantidade de cartas e equivalentes aos naipes de batalhas, cada jogador possui baralhos diferentes.\n");
        jScrollPane3.setViewportView(txtEspecifico);

        javax.swing.GroupLayout painelEsfecificoLayout = new javax.swing.GroupLayout(painelEsfecifico);
        painelEsfecifico.setLayout(painelEsfecificoLayout);
        painelEsfecificoLayout.setHorizontalGroup(
            painelEsfecificoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
            .addGroup(painelEsfecificoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEsfecificoLayout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
        painelEsfecificoLayout.setVerticalGroup(
            painelEsfecificoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
            .addGroup(painelEsfecificoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEsfecificoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        painelEstruturaCartas.addTab("Regras Específiicas", painelEsfecifico);

        txtEstruturas.setEditable(false);
        txtEstruturas.setColumns(20);
        txtEstruturas.setRows(5);
        txtEstruturas.setText("Total de cartas do Jogo: 58\n\nTotal de cartas por jogador: 45\n\nSendo 1 Rei por jogador,  4 naipes, cada um contendo 5  cartas de ataques que variam entre 4 à 10 e 4 especiais e diferentes.\nCada jogador possui os 4 naipes,  e apenas dois dele lutam entre si, ou seja, só é permitida jogadas do naipe de Lua contra o naipe de Sol e o de Lança contra o de Lua.ok\nTodas as cartas possuem um atributo chamado Distância, que varia entre 4 à 10.\nA Distância da carta permite ao jogador a ter possibilidade de se defender dos ataques de qualquer carta,\ndesde que sua Distância seja igual ou maior do que a do ataque.\n");
        jScrollPane1.setViewportView(txtEstruturas);

        painelEstruturaCartas.addTab("Estrutura das Cartas", jScrollPane1);

        painelEstrutura.setBackground(new java.awt.Color(0, 0, 0));

        txtBasicas.setEditable(false);
        txtBasicas.setColumns(20);
        txtBasicas.setRows(5);
        txtBasicas.setText("Total de cartas do Jogo: 58\n\nTotal de cartas por jogador: 45\n\nSendo 1 Rei por jogador,  4 naipes, cada um contendo 5  cartas de ataques que variam entre 4 à 10 e 4 especiais e diferentes.\nCada jogador possui os 4 naipes,  e apenas dois dele lutam entre si, ou seja, só é permitida jogadas do naipe de Lua contra o naipe de Sol e o de Lança contra o de Lua.ok\nTodas as cartas possuem um atributo chamado Distância, que varia entre 4 à 10.\nA Distância da carta permite ao jogador a ter possibilidade de se defender dos ataques de qualquer carta,\ndesde que sua Distância seja igual ou maior do que a do ataque.\n");
        jScrollPane4.setViewportView(txtBasicas);

        javax.swing.GroupLayout painelEstruturaLayout = new javax.swing.GroupLayout(painelEstrutura);
        painelEstrutura.setLayout(painelEstruturaLayout);
        painelEstruturaLayout.setHorizontalGroup(
            painelEstruturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
            .addGroup(painelEstruturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEstruturaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        painelEstruturaLayout.setVerticalGroup(
            painelEstruturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
            .addGroup(painelEstruturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEstruturaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        painelEstruturaCartas.addTab("Regras Báiscas", painelEstrutura);

        painelRegras.add(painelEstruturaCartas);
        painelEstruturaCartas.setBounds(10, 0, 600, 260);

        getContentPane().add(painelRegras);
        painelRegras.setBounds(80, 100, 640, 280);

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pictures/icones/voltar.jpg"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(370, 420, 120, 43);

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
        btnOK.setBounds(560, 420, 96, 43);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/11883universo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 778, 520);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblRegras;
    private javax.swing.JPanel painelEsfecifico;
    private javax.swing.JPanel painelEstrutura;
    private javax.swing.JTabbedPane painelEstruturaCartas;
    private javax.swing.JPanel painelRegras;
    private javax.swing.JTextArea txtBasicas;
    private javax.swing.JTextArea txtEspecifico;
    private javax.swing.JTextArea txtEstruturas;
    // End of variables declaration//GEN-END:variables
}
