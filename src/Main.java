
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main extends javax.swing.JFrame {
    private static CardLayout cardLayout;   // Gerenciador de layout de um container
    private static JPanel jPanel;           // Container
    private static JScrollPane jScrollPane; // Barra de rolagem
    
    public Main() {
        initComponents();
        myInitComponents();
    }
    
    private void myInitComponents(){
        cardLayout = new CardLayout();
        jPanel = new JPanel(cardLayout);    // Define o gerenciador de layout desse painel para um CardLayout        
        jScrollPane = new JScrollPane();
        
        this.setLayout(new BorderLayout()); // Define o gerenciador de layout desse JFrame para um BorderLayout
        this.add(jScrollPane);              // Adiciona, caso necessário, barras de rolagem nesse JFrame
        
        // Define a área reservada de apresentação de conteúdo
        jScrollPane.setViewportView(jPanel);    // ? Não iria fazer mais sentido colocar essa linha antes do this.add(jScrollPane)?
        
        // Adicionar painéis (cartas) ao CardLayout (gerenciador de cartas)
        jPanel.add(new EstoqueGUI(), "estoque");
        jPanel.add(new VendasGUI(), "vendas");
        
        // Primeiro painel a ser exibido (carta a ser trazida para cima)
        cardLayout.show(jPanel, "vendas");
        jPanel.setPreferredSize(new VendasGUI().getPreferredSize()); // Ajustar o tamanho do painel
    }
    
    public static void mudarTela(String nome, JPanel painel){
        cardLayout.show(jPanel, nome);
        jPanel.setPreferredSize(painel.getPreferredSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
