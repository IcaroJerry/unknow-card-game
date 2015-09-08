package br.ifba.ads.inter.game.windows.auxiliary;

import br.ifba.ads.inter.game.model.appGame.Partida;
import br.ifba.ads.inter.game.model.appGame.JogosSalvo;
import br.ifba.ads.inter.game.percistence.BDDAOHistorico;
import br.ifba.ads.inter.game.percistence.IDAOHistorico;
import br.ifba.ads.inter.game.windows.AppJogo;
import br.ifba.ads.inter.game.windows.MenuJogo;
import br.ifba.ads.inter.game.windows.gameString.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class SalveGame extends javax.swing.JFrame {
    
    protected IString strings;
    protected IDAOHistorico bancoHistorico;
    
    private String login;
    private String implemente;
  
    
    public SalveGame(String login, String implemente) {
        initComponents();
        this.implemente = implemente;
        this.login = login;
      
        this.setTitle("JOGOS SALVOS - "+this.login);
          
        try {   
             this.strings = (IString) Class.forName(this.implemente).newInstance();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"ERRO EM CARREGAR JOGO!");}
       
        try { 
              
        this.addLinhas();
        } catch (Exception ex) { ex.printStackTrace();}
             //JOptionPane.showMessageDialog(null,"ERRO NO SERVIDOR!");}
    }

    @SuppressWarnings("empty-statement")
   private void addLinhas() throws Exception{
   
  
   this.bancoHistorico = new BDDAOHistorico();

   DefaultTableModel model = (DefaultTableModel)this.tabelaJogos.getModel();
     Object[] linha;
    List<JogosSalvo> dados =  bancoHistorico.retornaJogoSalvo(this.login);
      
   int size = dados.size();    
   for(int i =0; i<size; i++){
     linha =   new Object[] {
                                dados.get(i).getNome(),
                                dados.get(i).getData().toString(),
                                dados.get(i).getPartida().getPlayUM().getEnergiaVital(),
                                dados.get(i).getPartida().getPlayUM().getNomeJogador()
     
                            };
     model.addRow(linha);
   }
  
  this.tabelaJogos.setModel(model);

   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbllLogin = new javax.swing.JLabel();
        lbllLogin1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaJogos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        lbllLogin.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        lbllLogin.setText("   Login:");
        lbllLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(778, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        lbllLogin1.setFont(new java.awt.Font("Old English Text MT", 0, 48)); // NOI18N
        lbllLogin1.setForeground(new java.awt.Color(255, 255, 255));
        lbllLogin1.setText("Jogos salvos:");
        lbllLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lbllLogin1);
        lbllLogin1.setBounds(50, 100, 440, 50);

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrar.setText("OK");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(240, 370, 103, 36);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(430, 370, 102, 36);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        tabelaJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogo Salvo", "Data", "Energia Vital", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaJogos.setToolTipText("");
        tabelaJogos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaJogos.setShowHorizontalLines(false);
        tabelaJogos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaJogos);
        if (tabelaJogos.getColumnModel().getColumnCount() > 0) {
            tabelaJogos.getColumnModel().getColumn(0).setResizable(false);
            tabelaJogos.getColumnModel().getColumn(1).setResizable(false);
            tabelaJogos.getColumnModel().getColumn(2).setResizable(false);
            tabelaJogos.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 627, 125);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 170, 670, 170);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifba/ads/inter/game/windows/pitcures_tela/wallpaper-de-uma-galaxia - Cópia.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
      
        int index = this.tabelaJogos.getSelectedRow();
        
        if(index<0){
        JOptionPane.showMessageDialog(null, "SELECIONE ALGUM JOGO SALVO!");
        }
        
        else{
        this.dispose();
        String salve = (String) this.tabelaJogos.getValueAt(index, 0);
        String nome = (String) this.tabelaJogos.getValueAt(index, 3);
        Partida partida;
        try {
         
            partida = this.bancoHistorico.retornaDadosJogoSalvo(salve,nome);
                partida.getPlayDOIS().addCartaMao(5);
                
                new AppJogo(this.login,this.implemente,partida).setVisible(true);
           
            } catch (Exception ex) {
                ex.printStackTrace();
              //JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR JOGO!");
            }
        
        
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        new MenuJogo(this.login, this.implemente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbllLogin;
    private javax.swing.JLabel lbllLogin1;
    private javax.swing.JTable tabelaJogos;
    // End of variables declaration//GEN-END:variables
}
