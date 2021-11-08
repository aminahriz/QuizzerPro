/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MikeRD
 */
public class Login extends javax.swing.JFrame {

   
    Registration r = new Registration();
    File userInfo = new File("users.txt");
    private ArrayList<User> users = new ArrayList<User>();
    TeacherUI l = new TeacherUI();
    static User current;
    
    
    
    /**
     * Creates new form CSISLogin
     */
    public Login() {
        Color m = new Color(100, 178, 223);
        getContentPane().setBackground(m);
        initComponents();
        fillUserArray();
    }
    
    //getter for users
    public ArrayList<User> getUsers() {
        return users;
    }

    //setter for users
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    //method to move to registration frame
     public void moveToReg(){
         //new runnable event
        java.awt.EventQueue.invokeLater(new Runnable() {
                    //void method run 
                    public void run() {
                        //make the registration page visible
                        new Registration().setVisible(true);
                    //end method
                    }
                //end method
                }
        //close parameter
        );
          //make this frame disappear
          this.setVisible(false);
    //end method
    }
    
    //method to open a box with username exists message
    public void usernameFalse(){
        //change label to show astrick
        usernameLabel.setText("*");
            //open joptionpane to show username doesnt exist error message
            JOptionPane.showMessageDialog(null,
                "Username doesn't exist. Try again, or register a new accounr",
                "Username Invalid",
                JOptionPane.ERROR_MESSAGE);
    //end method
    }
    
    //method that switches frames to landing frame
    public void moveToTeacherUI(User u){
         //new runnable event
        java.awt.EventQueue.invokeLater(new Runnable() {
                    //void method run 
                    @Override
                    public void run() {
                        try {
                            //make the teacher homepage visible
                            new TeacherUI(u).setVisible(true);
                            //end method
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                //end method
                }
        //close parameter
        );
          //make this frame disappear
          this.setVisible(false);
    //end method
    }
     //method that switches frames to student Homepage
    public void moveToStudentUI(User u){
        current = (User) u;
         //new runnable event
        java.awt.EventQueue.invokeLater(new Runnable() {
                    //void method run 
                    @Override
                    public void run() {
                        try {
                            //make the student homepage visible
                            new StudentUI(u).setVisible(true);
                            //end method
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                //end method
                }
        //close parameter
        );
          //make this frame disappear
          this.setVisible(false);
    //end method
    }
    
    //method to open a box with successful login message
    public void loginSuccess(){
        //open a box with successful login message
        JOptionPane.showMessageDialog(null,
                        "You have successfully logged in",
                        "Login Successful",
                        JOptionPane.INFORMATION_MESSAGE);
    }
    //method to open a box with password fail message
    public void passwordFail(){
        passwordLabel.setText("*");
                //open error box with password fail message
                JOptionPane.showMessageDialog(null,
                "Wrong password. Try again.",
                "Wrong",
                JOptionPane.ERROR_MESSAGE);
    }
   //method to fill array
   public void fillUserArray(){
       //try
        try {
            //variable to store number of lines in file
            int lines = r.numberOfLines(userInfo);
            //scanner to scan file
            Scanner s = new Scanner(userInfo);
            //loop through each line in file
            for (int i = 0; i<lines;i++){
                //new variable to hold line
                String line = s.nextLine();
                //new array to hold fields of line split by delimiter
                String[] fields = line.split(",");
                System.out.println(fields[0] +""+fields[1]+""+fields[2]+""+fields[3]+""+fields[4]);
                //create a new user using the array
                getUsers().add(new User(fields));
            //end loop
            }
            //close scanner
            s.close();
        //catch FNF exception
        } catch (FileNotFoundException ex) {
            //print error message
            error.setText("File may not exist");
        //end catch
        }
   //end method
   }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginButton = new javax.swing.JButton();
        UsernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        regButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginButton.setText("Login");
        LoginButton.setToolTipText("");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("LOGIN");

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Username");

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Password");

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Don't have an account?");

        regButton.setText("Register");
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("   ");

        passwordLabel.setText("     ");

        error.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordLabel))
                            .addComponent(LoginButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(error))))
                    .addComponent(jLabel1))
                .addGap(68, 68, 68))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordLabel, usernameLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(usernameLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(error)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addComponent(LoginButton)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(regButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {passwordLabel, usernameLabel});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        boolean username = r.UNExists(UsernameText.getText());
        
        if (username){
            String p = r.encrypt(r.passwordToWord(jPasswordField.getPassword()));
            String p1 = getUsers().get(r.unlocation).getPassword();
            current = (User) users.get(r.unlocation);
            if (p1.equals(p)){
                //open a box with login success message
                loginSuccess();
                
                if(getUsers().get(r.unlocation).getAccountType() == 's'){
                    //move to studentUI
                    moveToStudentUI(current);
                }
                else if(getUsers().get(r.unlocation).getAccountType() == 't')
                    moveToTeacherUI(current);
            
            } else{
                //open box with password fail message
                passwordFail();
            }
        } else{
            //open box with username doesnt exist message
            usernameFalse();
        }
        
            
        //this code should only run on successful login
        //it makes this invisible and starts the TeacherUI Jframe
        /* Create and display the form */
        
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
      moveToReg();
    }//GEN-LAST:event_regButtonActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField UsernameText;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton regButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
