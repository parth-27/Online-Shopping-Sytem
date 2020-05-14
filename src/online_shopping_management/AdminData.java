/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_shopping_management;

import java.sql.CallableStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.internal.OracleTypes;

public class AdminData extends javax.swing.JFrame {

    /**
     * Creates new form AdminData
     */
    public AdminData() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLoadDataTable = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RegisterCustomerDataTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShowAllCustomerProduct = new javax.swing.JTable();
        LoadAllCustomerProduct = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernamesubmit = new javax.swing.JTextField();
        submitbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Online Shopping Mangement");

        btnLoadDataTable.setBackground(new java.awt.Color(0, 153, 51));
        btnLoadDataTable.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnLoadDataTable.setText("Load All Customer Registration Data");
        btnLoadDataTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataTableActionPerformed(evt);
            }
        });

        RegisterCustomerDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Mobile Number", "Email", "Address", "Password"
            }
        ));
        jScrollPane2.setViewportView(RegisterCustomerDataTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("All Register Customers Data");

        ShowAllCustomerProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null,null, null, null, null},
                {null,null, null, null, null},
                {null,null, null, null, null},
                {null,null, null, null, null}
            },
            new String [] {
                "Order Id","Email" ,"Product Name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(ShowAllCustomerProduct);

        LoadAllCustomerProduct.setBackground(new java.awt.Color(0, 153, 51));
        LoadAllCustomerProduct.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoadAllCustomerProduct.setText("Load All Customer Orders");
        LoadAllCustomerProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadAllCustomerProductActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("One Customer Or Many Customers Order Info");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel4.setText("Email");

        usernamesubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamesubmitActionPerformed(evt);
            }
        });

        submitbtn.setBackground(new java.awt.Color(0, 153, 51));
        submitbtn.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        submitbtn.setText("Submit to see single customer order");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Log Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLoadDataTable)
                                .addGap(126, 126, 126)
                                .addComponent(LoadAllCustomerProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton3)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(usernamesubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(726, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(326, Short.MAX_VALUE)
                    .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadAllCustomerProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(usernamesubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(417, 417, 417))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(415, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(291, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(637, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(635, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadDataTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataTableActionPerformed
        DefaultTableModel tableMode = (DefaultTableModel) RegisterCustomerDataTable.getModel();
        tableMode.setRowCount(0);

        try {

            Connection myConnect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "goku", "goku");
            CallableStatement ps = myConnect.prepareCall("{call getuser_details(?)}");
            ps.registerOutParameter(1, OracleTypes.CURSOR);
            ps.execute();
            ResultSet rs = (ResultSet) ps.getObject(1);
            while (rs.next()) {
                String uname = rs.getString("name");
                String umail = rs.getString("email");
                String uphno = rs.getString("ph_no");
                String uadr = rs.getString("address");
                String upwd = rs.getString("password");
                tableMode.addRow(new Object[]{uname, uphno, umail, uadr, upwd});
            }
            myConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDataTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoadDataTableActionPerformed

    private void LoadAllCustomerProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadAllCustomerProductActionPerformed

        DefaultTableModel tableModel2 = (DefaultTableModel) ShowAllCustomerProduct.getModel();
        tableModel2.setRowCount(0);

        try {
            Connection myConnect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "goku", "goku");
            CallableStatement ps = myConnect.prepareCall("{call getallorders(?)}");
            ps.registerOutParameter(1, OracleTypes.CURSOR);
            ps.execute();
            ResultSet myRS = (ResultSet) ps.getObject(1);
            while (myRS.next()) {
                String ordid = Integer.toString(myRS.getInt("order_id"));
                String email = myRS.getString("email");
                String pname = myRS.getString("prod_name");
                String qty = Integer.toString(myRS.getInt("quantity"));
                String Price = Integer.toString(myRS.getInt("price"));
                tableModel2.addRow(new Object[]{ordid, email, pname, qty, Price});
            }
            myConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoadAllCustomerProductActionPerformed

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        DefaultTableModel tableMode2 = (DefaultTableModel) ShowAllCustomerProduct.getModel();
        tableMode2.setRowCount(0);
        try {
            Connection myConnect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "goku", "goku");
            CallableStatement ps = myConnect.prepareCall("{call getuserorders(?,?)}");
            ps.setString(1, usernamesubmit.getText());
            ps.registerOutParameter(2, OracleTypes.CURSOR);
            ps.execute();
            ResultSet myRS = (ResultSet) ps.getObject(2);
            while (myRS.next()) {
                String ordid = Integer.toString(myRS.getInt("order_id"));
                String email = myRS.getString("email");
                String pname = myRS.getString("prod_name");
                String qty = Integer.toString(myRS.getInt("quantity"));
                String Price = Integer.toString(myRS.getInt("price"));
                tableMode2.addRow(new Object[]{ordid, email, pname, qty, Price});
            }
            myConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitbtnActionPerformed

    private void usernamesubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamesubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamesubmitActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        AdminLogin dfrm = new AdminLogin();
        dfrm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        Select dfrm = new Select();
        dfrm.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadAllCustomerProduct;
    private static javax.swing.JTable RegisterCustomerDataTable;
    private static javax.swing.JTable ShowAllCustomerProduct;
    private javax.swing.JButton btnLoadDataTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton submitbtn;
    private javax.swing.JTextField usernamesubmit;
    // End of variables declaration//GEN-END:variables
}
