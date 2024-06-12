/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tubespbo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author Sean Himawan Arianto
 */
public class DialogSearch extends javax.swing.JDialog {

    /**
     * Creates new form DialogSearch
     */
    private Connection conn;
    private ResultSet rs;
    private DataBase db = new DataBase();
    public DialogSearch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textPencarian = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SaveBtn2 = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cari Produk");

        textPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPencarianActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cari Produk");

        SaveBtn2.setText("Search");
        SaveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtn2ActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPencarian)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(SaveBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackButton)
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addComponent(BackButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveBtn2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        textPencarian.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPencarianActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed

    }//GEN-LAST:event_SaveBtnActionPerformed

    private void SaveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtn2ActionPerformed

        DataBase db = new DataBase();
        db.connect();
        String requirementPencarian = textPencarian.getText();
        rs=db.view("SELECT * FROM produk");
        List<infoProduk> produkDitunjukkan = new ArrayList<>();
        infoProduk isiProduk;
        try {
            while (rs.next()) {
                String namaProduk = rs.getString("nama");
                int hargaProduk = rs.getInt("harga");
                if (CheckDistance.hitungEditDistance(requirementPencarian, namaProduk) <= 2) { 
                    GUIHalamanProduk halamanProduk = new GUIHalamanProduk(namaProduk, hargaProduk);
                    halamanProduk.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            db.disconnect();
        }

    }//GEN-LAST:event_SaveBtn2ActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        GUIHalamanUtama HalUtama = new GUIHalamanUtama(null);
        HalUtama.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DialogSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {           
            public void run() {
                DialogSearch dialog = new DialogSearch(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JButton SaveBtn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textPencarian;
    // End of variables declaration//GEN-END:variables
}
class CheckDistance {
    public static int hitungEditDistance(String inputPengguna, String hasilPencarian) {
        int[][] dp = new int[inputPengguna.length() + 1][hasilPencarian.length() + 1];

        for (int i = 0; i <= inputPengguna.length(); i++) {
            for (int j = 0; j <= hasilPencarian.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + (inputPengguna.charAt(i - 1) == hasilPencarian.charAt(j - 1) ? 0 : 1),
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                    );
                }
            }
        }

        return dp[inputPengguna.length()][hasilPencarian.length()];
    }
}


