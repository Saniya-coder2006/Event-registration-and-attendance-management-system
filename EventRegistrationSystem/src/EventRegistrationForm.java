 import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import ui.DBConnection;


public class EventRegistrationForm extends javax.swing.JFrame {

    // constructor
    public EventRegistrationForm() {
        initComponents();   // this MUST be here
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("College Event Regrstration");
        setBackground(new java.awt.Color(204, 248, 255));
        setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        setForeground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Event Registration System");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 20, 241, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Student Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 96, 212, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Select Event:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 220, 20));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tech Fest ", "Cultural Fest", "Sports Meet", "Workshop", " " }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 128, 323, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 159, 38));

        jTextField1.addActionListener(this::jTextField1ActionPerformed);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 94, 323, -1));
        jTextField1.getAccessibleContext().setAccessibleName("");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caa4330e-a647-4bc7-a6af-6b6d91fbb509.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 450));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

     // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database not connected");
            return;
        }

        String name = jTextField1.getText().trim();
        String event = jComboBox2.getSelectedItem().toString();
        
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter student name");
            return;
        }

        String sql = "INSERT INTO registrations(name, event,date) VALUES (?, ?,CURDATE())";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, event);

        pst.executeUpdate();
        

    JOptionPane.showMessageDialog(this, "Registered successfully");

    // Clear fields
    jTextField1.setText("");
    jComboBox2.setSelectedIndex(0);

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
} 
        

       
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

   public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        new EventRegistrationForm().setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}


