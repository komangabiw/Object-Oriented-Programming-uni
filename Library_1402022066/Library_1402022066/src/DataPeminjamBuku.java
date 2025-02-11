
import java.awt.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;  
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author I Komang Abimanyu/1402022066
 */
public class DataPeminjamBuku extends javax.swing.JFrame {
    /**
     * Creates new form DataPeminjamBuku
     */
    public DataPeminjamBuku() {
        initComponents();
        Image img = new ImageIcon(this.getClass().getResource("/images/logoG.jpg")).getImage();
        this.setIconImage(img);
        dbConnect.koneksi();
        display();
        read();
    }
    
    public void read(){
        //INSERT INTO datapeminjamanbuku (ID, tanggal, nama, npm, judulBuku, pengarang)
        //SELECT ID, tanggal, nama, npm, judulBuku, pengarang FROM formpeminjamanbuku;
        String truncate = "TRUNCATE datapeminjamanbuku";
        String sqlRead = "INSERT INTO datapeminjamanbuku select * FROM formpeminjamanbuku";
        
        try
        {
            dbConnect.pst = dbConnect.con.prepareCall(truncate);
            dbConnect.pst.executeUpdate();
            dbConnect.pst = dbConnect.con.prepareCall(sqlRead);
            dbConnect.pst.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(DataPeminjamBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        int id = dataTable.getSelectedRow() + 1;
        //set format date
        String date = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(date); 
        String dateFormat = String.valueOf(format.format(tanggal.getDate()));
        
        String updateNama = nama.getText();
        String updateNpm = npm.getText();
        String updateJudul = judul.getText();
        String updatePengarang = pengarang.getText();
        boolean cekAngka = true;
        for(int i = 0; i < npm.getText().length();i++){
            if( !Character.isDigit(npm.getText().charAt(i))){
                cekAngka = false;
                break;
            }
        }
        if(cekAngka){
                try
            {
                dbConnect.pst = dbConnect.con.prepareStatement("UPDATE formpeminjamanbuku set tanggal=?, nama=?, npm=?, judulBuku=?, pengarang=? where id=?");
                dbConnect.pst.setString(1, dateFormat);
                dbConnect.pst.setString(2, updateNama);
                dbConnect.pst.setString(3, updateNpm);
                dbConnect.pst.setString(4, updateJudul);
                dbConnect.pst.setString(5, updatePengarang);
                dbConnect.pst.setString(6,"" + id);
                dbConnect.pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                clean();
            } catch (SQLException ex)
            {
                Logger.getLogger(DataPeminjamBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Data Tidak Berhasil Di Edit, NPM terkontaminasi",
                        "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(){
        // row + 1 karena id dimulai dari 1
        int row = dataTable.getSelectedRow() + 1;
        String sqlDelete = "DELETE FROM formpeminjamanbuku where id = " + row;
        //        ALTER TABLE formpeminjamanbuku DROP ID;  drop atribut id
        String alterDropID = "ALTER TABLE formpeminjamanbuku DROP ID";
        //        ALTER TABLE formpeminjamanbuku AUTO_INCREMENT = 1; buat auto inc di table 
        String alterAutoInc = "ALTER TABLE formpeminjamanbuku AUTO_INCREMENT = 1";
        //        ALTER TABLE formpeminjamanbuku ADD ID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
        //        buat id PK auto inc
        String alterAddID = "ALTER TABLE formpeminjamanbuku ADD ID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
        try{
            dbConnect.pst = dbConnect.con.prepareCall(sqlDelete);
            dbConnect.pst.executeUpdate();
            dbConnect.pst = dbConnect.con.prepareCall(alterDropID);
            dbConnect.pst.executeUpdate();
            dbConnect.pst = dbConnect.con.prepareCall(alterAutoInc);
            dbConnect.pst.executeUpdate();
            dbConnect.pst = dbConnect.con.prepareCall(alterAddID);
            dbConnect.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public void display(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Tanggal", 
            "Nama", "NPM", "Judul Buku", "Pengarang"}, 0);
        try{
            dbConnect.rs = dbConnect.stm.executeQuery("select * from datapeminjamanbuku");
            while(dbConnect.rs.next()){
                model.addRow(new Object[]{dbConnect.rs.getString("tanggal"), dbConnect.rs.getString("nama"), dbConnect.rs.getString("npm"),
                dbConnect.rs.getString("judulBuku"), dbConnect.rs.getString("pengarang")});
                dataTable.setModel(model);
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void clean(){
        nama.setText("");
        npm.setText("");
        judul.setText("");
        pengarang.setText("");
        tanggal.setCalendar(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        npm = new javax.swing.JTextField();
        pengarang = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Copy Gramedia");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(101, 78, 146));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(165, 192, 221));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PEMINJAMAN BUKU");

        jPanel2.setBackground(new java.awt.Color(101, 78, 146));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null}
            },
            new String [] {
                "Tanggal", "Nama Peminjam", "NPM", "Judul", "Pengarang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(165, 192, 221));
        jLabel2.setText("Tanggal");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(165, 192, 221));
        jLabel3.setText("Nama Peminjam");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(165, 192, 221));
        jLabel4.setText("NPM");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(165, 192, 221));
        jLabel6.setText("Judul");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(165, 192, 221));
        jLabel7.setText("Pengarang");

        judul.setBackground(new java.awt.Color(165, 192, 221));
        judul.setForeground(new java.awt.Color(0, 0, 0));
        judul.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        nama.setBackground(new java.awt.Color(165, 192, 221));
        nama.setForeground(new java.awt.Color(0, 0, 0));
        nama.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        npm.setBackground(new java.awt.Color(165, 192, 221));
        npm.setForeground(new java.awt.Color(0, 0, 0));
        npm.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        pengarang.setBackground(new java.awt.Color(165, 192, 221));
        pengarang.setForeground(new java.awt.Color(0, 0, 0));
        pengarang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButton2.setBackground(new java.awt.Color(101, 78, 146));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(165, 192, 221));
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(101, 78, 146));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(165, 192, 221));
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(101, 78, 146));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(165, 192, 221));
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(101, 78, 146));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(165, 192, 221));
        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tanggal.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(npm, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(npm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton5)))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        Library_1402022066 baru = new Library_1402022066();
        dispose();
        baru.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        read();
        display();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        delete();
        clean();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model =(DefaultTableModel) dataTable.getModel();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date = formatter.parse(model.getValueAt(dataTable.getSelectedRow(), 0).toString());
            tanggal.setDate(date);
            nama.setText(model.getValueAt(dataTable.getSelectedRow(), 1).toString());
            npm.setText(model.getValueAt(dataTable.getSelectedRow(), 2).toString());
            judul.setText(model.getValueAt(dataTable.getSelectedRow(), 3).toString());
            pengarang.setText(model.getValueAt(dataTable.getSelectedRow(), 4).toString());
        } catch (ParseException ex)
        {
            Logger.getLogger(DataPeminjamBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dataTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(DataPeminjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(DataPeminjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(DataPeminjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(DataPeminjamBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPeminjamBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField npm;
    private javax.swing.JTextField pengarang;
    private com.toedter.calendar.JDateChooser tanggal;
    // End of variables declaration//GEN-END:variables
}
