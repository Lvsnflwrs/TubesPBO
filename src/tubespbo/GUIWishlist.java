/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class GUIWishlist extends javax.swing.JFrame {

    /**
     * Creates new form GUIWishlist
     */
    private DefaultListModel<String> listModel;
    private Connection conn;
    private ResultSet rs;
    private DataBase db = new DataBase();
    public GUIWishlist() {
        initComponents();
        
        listModel = new DefaultListModel();
        HapusBtn.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListProduk = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        DisplayName = new javax.swing.JLabel();
        DisplayHarga = new javax.swing.JLabel();
        DisplayStok = new javax.swing.JLabel();
        HapusBtn = new javax.swing.JButton();
        PerbaruiBtn = new javax.swing.JButton();
        BackButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListProduk);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Wishlist");

        DisplayName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DisplayName.setText("Nama   :");

        DisplayHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DisplayHarga.setText("Harga   :");

        DisplayStok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DisplayStok.setText("Stok     :");

        HapusBtn.setText("Hapus");
        HapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBtnActionPerformed(evt);
            }
        });

        PerbaruiBtn.setText("Perbarui List");
        PerbaruiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerbaruiBtnActionPerformed(evt);
            }
        });

        BackButton1.setText("Back");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(PerbaruiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DisplayName)
                                    .addComponent(DisplayHarga)
                                    .addComponent(DisplayStok))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HapusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(69, 69, 69))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BackButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(DisplayName)
                        .addGap(34, 34, 34)
                        .addComponent(DisplayHarga)
                        .addGap(34, 34, 34)
                        .addComponent(DisplayStok)
                        .addGap(51, 51, 51)
                        .addComponent(HapusBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PerbaruiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBtnActionPerformed
        String nama = ListProduk.getSelectedValue();
        
        db.connect();
        rs = db.view("SELECT * FROM produk WHERE nama = '"+nama+"'");
        try {
            if(rs.next()){
                int id = rs.getInt("id");
                db.query("DELETE FROM wishlist WHERE idProduk = "+id+" AND idPembeli = 1");
                JOptionPane.showMessageDialog(this, "Data Telah Dihapus, Silahkan Perbarui List!");
            } else {
                JOptionPane.showMessageDialog(this, "Data Tidak Ditemukan!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        db.disconnect();
    }//GEN-LAST:event_HapusBtnActionPerformed

    private void ListProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListProdukMouseClicked
        String nama = ListProduk.getSelectedValue();
        HapusBtn.setVisible(true);
        
        db.connect();
        rs = db.view("SELECT * FROM produk WHERE nama = '"+nama+"'");
        try{
            while(rs.next()){
                DisplayName.setText("Nama   : " + rs.getString("nama"));
                DisplayHarga.setText("Harga   : " + rs.getInt("harga"));
                DisplayStok.setText("Stok     : " + rs.getInt("stok"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        db.disconnect();
    }//GEN-LAST:event_ListProdukMouseClicked

    private void PerbaruiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerbaruiBtnActionPerformed
        ListProduk.removeAll();
        listModel.removeAllElements();
        
        db.connect();
        rs = db.view("SELECT p.nama FROM wishlist w JOIN produk p ON w.idProduk = p.id WHERE w.idPembeli = 1");
        try{
            while(rs.next()){
                listModel.addElement(rs.getString("nama"));
            }
            ListProduk.setModel(listModel);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        db.disconnect();
    }//GEN-LAST:event_PerbaruiBtnActionPerformed

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        GUIHalamanUtama HalamanUtama = new GUIHalamanUtama(null);
        HalamanUtama.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIWishlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton1;
    private javax.swing.JLabel DisplayHarga;
    private javax.swing.JLabel DisplayName;
    private javax.swing.JLabel DisplayStok;
    private javax.swing.JButton HapusBtn;
    private javax.swing.JList<String> ListProduk;
    private javax.swing.JButton PerbaruiBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
