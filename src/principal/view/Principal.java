/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.view;


import javax.swing.JPanel;
import pagamentos.model.Cliente;
import pagamentos.view.ConsultaForm;
import pagamentos.view.TransacaoForm;
import principal.utils.ButtonTabComponent;
import simulacoes.Gastos;
import pagamentos.view.ConsultaForm;
/**
 *
 * @author root
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    
    Cliente u;
    public Principal(Cliente u) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.u = u;
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    static int i;
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/view/media/debit-card.png"))); // NOI18N
        jMenu1.setText("PAGAMENTOS");

        jMenuItem1.setText("Efetuar Transação");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Consultar Cliente/Transação");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/view/media/growth.png"))); // NOI18N
        jMenu2.setText("INVESTIMENTOS");
        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulacoes/graph.png"))); // NOI18N
        jMenu4.setText("SIMULAÇÕES");

        jMenuItem3.setText("Gastos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/view/media/settings.png"))); // NOI18N
        jMenu3.setText("CONFIGURAÇÕES");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JPanel tabTransacao;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TransacaoForm t = new TransacaoForm();
        
        tabTransacao = new JPanel();
        
        tabTransacao.add(t);
        t.setField(u.getUser());
        t.setCliente(u);
        
        tabPane.addTab("Transação", null, tabTransacao, "Envie dinheiro e boletos para outros usuários.");
        tabPane.setSelectedComponent(tabTransacao);
        
        int i = tabPane.getSelectedIndex();
        tabPane.setTabComponentAt(i, new ButtonTabComponent(tabPane));
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    JPanel tabConsulta;
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ConsultaForm c = new ConsultaForm(u);
        
        
        tabConsulta = new JPanel();
        tabConsulta.add(c);
        
        tabPane.addTab("Consulta", null, tabConsulta, "Consulte suas transações.");
        tabPane.setSelectedComponent(tabConsulta);
        
        int i = tabPane.getSelectedIndex();
        tabPane.setTabComponentAt(i, new ButtonTabComponent(tabPane));
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    JPanel tabGastos;
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        
        tabGastos = new JPanel();
        tabGastos.add(new Gastos(u));
        
        tabPane.addTab("Histórico de Transações", null, tabGastos, "Gastos e ganhos.");
        tabPane.setSelectedComponent(tabGastos);
        
        int i = tabPane.getSelectedIndex();
        tabPane.setTabComponentAt(i, new ButtonTabComponent(tabPane));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    public void run(){
        new Principal(u).setVisible(true);
        System.out.println(u.getNome());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
