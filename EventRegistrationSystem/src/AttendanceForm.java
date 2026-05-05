/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
public class AttendanceForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AttendanceForm.class.getName());

    /**
     * Creates new form AttendanceForm
     */
    private ButtonGroup bg;
    public AttendanceForm() {
        initComponents();
        setTodayDate();
        loadStudents();
        
        bg = new ButtonGroup();
        bg.add(radioPresent);
        bg.add(radioAbsent);
        
        comboStudent.addActionListener(e->loadStudentID());
    }
    
    private void setTodayDate(){
        java.sql.Date today = new
        java.sql.Date(System.currentTimeMillis());
        lblDate.setText(today.toString());
    }
    private void loadStudents(){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT name FROM registrations");
            comboStudent.removeAllItems();
            
            while(rs.next()){
                comboStudent.addItem(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
            }
        }
    
                    
                
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated +by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboStudent = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboEvent = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        radioPresent = new javax.swing.JRadioButton();
        radioAbsent = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c78d8835-fecc-4d5e-bad9-a88be7733421.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c78d8835-fecc-4d5e-bad9-a88be7733421.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Attendance Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 154, 32));

        jLabel2.setText("Student Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 56, 90, 27));

        comboStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel4.setText("Student ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));
        getContentPane().add(txtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel5.setText("Event Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        comboEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tech Fest", "Cultural Fest", "Sports Meet", "Workshop", " " }));
        getContentPane().add(comboEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        jLabel6.setText("Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 100, 30));

        jLabel7.setText("Status:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 50, 30));

        radioPresent.setText("Present");
        getContentPane().add(radioPresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        radioAbsent.setText("Absent");
        radioAbsent.addActionListener(this::radioAbsentActionPerformed);
        getContentPane().add(radioAbsent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        btnSave.setBackground(new java.awt.Color(0, 204, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save Attendance");
        btnSave.addActionListener(this::btnSaveActionPerformed);
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caa4330e-a647-4bc7-a6af-6b6d91fbb509.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioAbsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAbsentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAbsentActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
try {

    Connection con = DBConnection.getConnection();
        String name =
                comboStudent.getSelectedItem().toString();
        
        String event =
                comboEvent.getSelectedItem().toString();
        
        String status = "";
        
        if (radioPresent.isSelected()) {
            status = "Present";
        } else if (radioAbsent.isSelected()) {
            status = "Absent";
        }else{
            JOptionPane.showMessageDialog(this, "Please select status ");
            return;
        }
        
        PreparedStatement pst =
                con.prepareStatement(
                        "INSERT INTO attendance (name,event,date,status)VALUES (?,?,?,?)"
                );
        
        pst.setString(1, name);
        
        pst.setString(2, event);
        pst.setDate(3,
                new java.sql.Date(System.currentTimeMillis()));
        pst.setString(4, status);
        
        pst.executeUpdate();
        
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Attendance Saved Successfully"
        );
    

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        e.getMessage()
    );
}        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       java.awt.EventQueue.invokeLater(()->{
           new AttendanceForm().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboEvent;
    private javax.swing.JComboBox<String> comboStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDate;
    private javax.swing.JRadioButton radioAbsent;
    private javax.swing.JRadioButton radioPresent;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables

    private void loadEvent() {
        try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT event_name FROM events");

        comboEvent.removeAllItems();

        while (rs.next()) {
            comboEvent.addItem(rs.getString("event_name"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

        
    }

    private void loadStudentID() {
        try {
        String name = comboStudent.getSelectedItem().toString();

        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "SELECT id FROM registrations WHERE name=?"
        );

        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            txtStudentId.setText(rs.getString("id"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    
    }

