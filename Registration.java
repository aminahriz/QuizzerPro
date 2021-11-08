/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

//new Registration frame
public class Registration extends javax.swing.JFrame {

    //create new File to represent userInfo.txt 
    File userInfo = new File("users.txt");
    //set delimiter as ,
    String delim = ",";
    //create new file to represent dictbadpass.txt
    File badPasswords = new File("dictbadpass.txt");
    //new array list to hold all CSIS users
    private ArrayList<User> userList = new ArrayList<User>();
    //integer to locate password
    int unlocation;
    //string to compile errors
    String errors;
    //variables to hold registration fields
    private String username;
    private String password;
    private String fname;
    private String lname;
    private char account;
    //variables to check if registration fields are acceptable
    boolean UNError;
    boolean fnameGood;
    boolean lnameGood;
    boolean goodPass;
    

    //Constructs a new Registration form
    public Registration() {
        initComponents();
        buttonGroup1.add(studentButton);
        buttonGroup1.add(teacherButton);
    }

    //getter for userList
    public ArrayList<User> getUserList() {
        return userList;
    }

    //setter for userList
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    //getter for username
    public String getUsername() {
        return username;
    }

    //getter for password
    public String getPassword() {
        return password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for fname
    public String getFname() {
        return fname;
    }

    //setter for fname
    public void setFname(String fname) {
        this.fname = fname;
    }

    //getter for lname
    public String getLname() {
        return lname;
    }

    //setter for lname
    public void setLname(String lname) {
        this.lname = lname;
    }
    

    //method that shows an error box with all error messages applicable
    public void failMessage() {
        //displays a box with all error messages applicable
        JOptionPane.showMessageDialog(null,
                errors,
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
        //end method
    }

    //method that shows box with successful registration message
    public void successMessage() {
        //show box with successful registration message
        JOptionPane.showMessageDialog(null,
                "You have successfully been registered, you may now log in",
                "Successful Registration",
                JOptionPane.INFORMATION_MESSAGE);
    }

    //method to compile all errors in registration fields
    public void errorCompilation() {
        //clears error message
        errors = "";
        //username is the text in usernameText text field
        username = usernameText.getText();
        // check if username already exists
        UNError = !UNExists(username);
        //if username exists
        if (!UNError) {
            //change label to show error
            UNfeeback.setText("*");
            //add error to error message
            errors += "Username already exists\n";
            //if the username is empty
        }
        if (getUsername().isEmpty()) {
            //change label to show error
            UNfeeback.setText("*");
            //add error to error message
            errors += "Enter a username\n";
            //set UNError to true
            UNError = false;
            //end if
        }
        String[] emailAt = username.split("@");
//        Boolean dot = false;
//        if (emailAt.length>=2){
//            //this part isnt working
//            String[] emailDot = emailAt[1].split(".");
//            if (emailDot.length>=2){
//                dot = true;
//            }
//        }
      
        if (emailAt.length<2){
            UNfeeback.setText("*");
            errors += "Email is invalid\n";
            UNError = false;
        }

        //initialize and convert password to string
        password = passwordToWord(passwordText.getPassword());
        //check if password strong
        goodPass = passwordStrong(password);
        //if not
        if (!goodPass) {
            //change label to show error
            passwordFeedback.setText("*");
            //add error to error message
            errors += "Weak Password. Password must:\n\t-contain at least 10 characters\n\t-contain 1 uppercase, 1 lowercase, 1 number & 1 symbol"
                    + "\n\t-not be a word\n\t-not contain a comma\n";
        } //else if password is strong
        else {
            //encrypt the password
            setPassword(encrypt(getPassword()));
            //end if
        }

        //set first name to text from textbox
        setFname(fnameText.getText());
        //check if fname is good
        fnameGood = nameGood(getFname());
        //if not good
        if (!fnameGood) {
            //change label to shwo error
            fnameFeedback.setText("*");
            //add error to error messgae
            errors += "Name not acceptable. Must be\n\t-at least 2 characters\n\t-include no numbers or symbols except -";
            //end if
        }
        //set last name to text from textbox
        setLname(lnameText.getText());
        //check if lname is good
        lnameGood = nameGood(getLname());
        //if not good
        if (!lnameGood) {
            //change label to show error
            lnameFeedback.setText("*");
            //if fname good
            if (fnameGood) {
                //add error to error message
                errors += "Name not acceptable. Must be\n\t-at least 2 characters\n\t-include no numbers or symbols except -\n";
                //end if
            }
            //end if
        }
        if (!studentButton.isSelected()|| !studentButton.isSelected() ){
            typeError.setText("*");
            errors += "Please select and account type";
        }
        if(studentButton.isSelected()){
            account = 's';
        }
        if(teacherButton.isSelected()){
            account = 't';
        }
        
    }

    //method to format a name, takes in a name
    public String formatName(String name) {
        //creates a list of names seperated by dashes
        String[] names = name.split("-");
        //creates an empty formatted string
        String formatted = "";
        //loops through all the names in the list
        for (int i = 0; i < names.length; i++) {
            //if i is greater than 0
            if (i > 0) {
                //add - to formatted string
                formatted = formatted + "-";
                //end if
            }
            //create a hold variable to hold the first letter of the name capitalized plus the rest of the letters in lowercase
            String hold = names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
            //add the hold string to formatted string
            formatted = formatted + hold;
            //end loop
        }
        //return the formatted name
        return formatted;
    }

    //method to switch to login frame
    public void login() {
        //new runnable event
        java.awt.EventQueue.invokeLater(new Runnable() {
            //void method run 
            public void run() {
                //make the login page visible
                new Login().setVisible(true);
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

    //method encrypts passwords
    public String encrypt(String password) {
        //declare and initialize encrypted
        String encrypted = "";
        //try
        try {
            //create new instance of MessageDigest class using SHA-256 algorithm
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            //give the helper function the password
            sha.update(password.getBytes());
            //encrypt the password
            byte byteData[] = sha.digest();

            //loop through byte
            for (int i = 0; i < byteData.length; ++i) {
                //add converted byte to encrypted password
                encrypted += (Integer.toHexString((byteData[i] & 0xFF) | 0x100).substring(1, 3));
                //end loop
            }
            //catch exception
        } catch (NoSuchAlgorithmException ex) {
            //print explanation message
            error.setText("No such algorithm exists");
            //end catch
        }

        //return encrypted password
        return encrypted;

        //end method
    }

    //method to check if a name is acceptable
    public boolean nameGood(String name) {
        //set good to true
        boolean good = true;
        //if the name has less than two characters
        if (name.length() < 2) {
            //set good to false
            good = false;
            //end if
        }
        //loop through characters in name
        for (int i = 0; i < name.length(); i++) {
            //letter is the character at index
            char letter = name.charAt(i);
            //if the character is not a letter
            if (Character.isLetter(letter) == false) {
                //if the character is not a dash
                if (letter != '-') {
                    //set good to false
                    good = false;
                    //break loop
                    break;
                    //end if
                }
                //end if
            }
            //end loop
        }
        //return good
        return good;
        //end method
    }

    //method that counts the number of lines in the file
    public int numberOfLines(File f) {
        //variable to count the number of lines
        int count = 0;
        //try counting the lines in the file
        try {
            //create a scannr for the file
            Scanner fscan = new Scanner(f);
            //while there is a next line in the file
            while (fscan.hasNextLine()) {
                //scan the next line
                fscan.nextLine();
                //add one to count
                count++;
                //end while
            }
            //close the scanner
            fscan.close();
            //end try
        } //catch file does not exist exception
        catch (FileNotFoundException e) {
            //print "file doesnt exist"
            error.setText("File doesn' exist");
            //end catch
        }
        //return count
        return count;
//end method
    }

    //method to see if a username already exists
    public boolean UNExists(String un) {
        //exists is false
        boolean exists = false;
        //try
        try {
            //new scanner to scan userInfo file
            Scanner fscan = new Scanner(userInfo);
            //for loop to loop through each line in the file
            for (int i = 0; i < numberOfLines(userInfo); i++) {
                //line is the next line in the file
                String line = fscan.nextLine();
                //array to seperate each field
                String fields[] = line.split(delim);
                //if the username at the line equals the parameter
                if (fields[0].equals(un)) {
                    //exists is true
                    exists = true;
                    //save location
                    unlocation = i;
                    //break the loop
                    break;
                    //end if
                }
                //end for loop       
            }
            //close scanner
            fscan.close();
            //end try    
        } //catch the file not found exception
        catch (FileNotFoundException ex) {
            //print file not found
            error.setText("File not found");
            //end catch
        }
        //return exists
        return exists;
        //end method
    }

    //method that converts password array to a string
    public String passwordToWord(char[] passwordArray) {
        //set lengthPass to length of password array
        int lengthPass = passwordArray.length;
        //set pass as empty
        String pass = "";
        //loop through lengthPass
        for (int i = 0; i < lengthPass; i++) {
            //add character at index of array to pass
            pass += passwordArray[i];
            //end loop
        }
        //return pass
        return pass;
    }

    //method that checks strength of password
    public boolean passwordStrong(String password) {
       
        //try
        try {
            //check 1: check if the password contain each needed character
            //declare boolean capital, lower, number, and symbol and set all to false
            boolean capital = false, lower = false, number = false, symbol = false;
            //loop through the length of password
            for (int i = 0; i < password.length(); i++) {
                //if capital and lower and number and symbol are true
                if (capital && lower && number && symbol) {
                    //break loop
                    break;
                } //else if character at index is uppercase
                else if (Character.isUpperCase(password.charAt(i))) {
                    //set capital to true
                    capital = true;
                    //end else if
                } //else if character at index is lowercase
                else if (Character.isLowerCase(password.charAt(i))) {
                    //set lower to true
                    lower = true;
                    //end else if    
                } //if character at index is a number
                else if (Character.isDigit(password.charAt(i))) {
                    //set number to true
                    number = true;
                    //end else if
                } //else if character is not a number or a letter
                else if (Character.isDigit(password.charAt(i)) == false && Character.isLetter(password.charAt(i)) == false) {
                    //set symbol to true
                    symbol = true;
                    //end else if
                }
                //end loop
            }

            //if capital, lower, number or symbol are false
            if (!capital || !lower || !number || !symbol) {
                //return false and end the method
                return false;
                //end if
            }

            //Check 2: password is long enough
            //if password is less than 10 characters
            if (password.length() < 10) {
                
                //end the method and return false
                return false;
                //end if
            }
            //new scanner to scan badPasswords
            Scanner scan = new Scanner(badPasswords);

            //check 3: if the password contains words in the bad password file
            //warning: this takes a super long time to comb through each word, if you dont have time, 
            //just comment this out or make sure word is near top of file (ex. 123)
            //loop through all the lines in badPasswords
            int passNum = numberOfLines(badPasswords);
            for (int i = 0; i < passNum; i++) {
                //declare and set bad as next line in file
                String bad = scan.nextLine();
                //declare and set lowPass as password in lowercase
                String lowPass = password.toLowerCase();
                //if lowPass contains bad
                if (lowPass.contains(bad)) {
                    
                    //end the method and return false
                    return false;
                    //end if
                }
                //end loop
            }
            scan.close();
            //catch file not foundexception
        } catch (FileNotFoundException ex) {
            //print error message to label
            error.setText("File not found.");
//end catch
        }

        //return true since the method hasn't ended yet
        return true;
        //end method
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        fnameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lnameText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        UNfeeback = new javax.swing.JLabel();
        fnameFeedback = new javax.swing.JLabel();
        lnameFeedback = new javax.swing.JLabel();
        passwordFeedback = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        studentButton = new javax.swing.JRadioButton();
        teacherButton = new javax.swing.JRadioButton();
        typeError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("New User Registration");

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("First Name");

        lnameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextActionPerformed(evt);
            }
        });

        jLabel5.setText("Last Name");

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        UNfeeback.setText("  ");

        fnameFeedback.setText("  ");

        lnameFeedback.setText("    ");

        passwordFeedback.setText("   ");

        jLabel6.setText("Already have an account?");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        error.setText("   ");

        studentButton.setText("Student");

        teacherButton.setText("Teacher");

        typeError.setText("      ");

        jLabel7.setText("You are a:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginButton)
                                .addGap(70, 70, 70)
                                .addComponent(error)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(15, 15, 15)
                                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(13, 13, 13)
                                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(10, 10, 10)
                                        .addComponent(fnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(studentButton)
                                                .addGap(23, 23, 23)
                                                .addComponent(teacherButton))
                                            .addComponent(lnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fnameFeedback, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lnameFeedback, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(passwordFeedback, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UNfeeback, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeError))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(RegisterButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {UNfeeback, fnameFeedback, lnameFeedback, passwordFeedback});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(error)
                        .addGap(0, 269, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(UNfeeback))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(passwordFeedback))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(fnameFeedback))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(lnameFeedback))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentButton)
                            .addComponent(teacherButton)
                            .addComponent(typeError)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RegisterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(loginButton))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {UNfeeback, fnameFeedback, fnameText, lnameFeedback, lnameText, passwordFeedback, passwordText, usernameText});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTextActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        //compile all errors in registration fields
        errorCompilation();

        //if all true
        if (UNError && goodPass && lnameGood && fnameGood && (studentButton.isSelected() || teacherButton.isSelected())) {
            try {
                //Add info to file
                PrintWriter pw = new PrintWriter(new FileWriter(userInfo, true));
                //Add a line with each field seperated by delimiter
                pw.println(getUsername() + delim + getPassword() + delim + formatName(getFname()) + delim + formatName(getLname()) + delim + account);
                //close printwriter
                pw.close();
                //catch exception
            } catch (FileNotFoundException ex) {
                //print error message
                error.setText("File not found");
                //catch exception
            } catch (IOException ex) {
                //print error messgae
                error.setText("File not found/I/O error");
            }

            //show box with successful registration message
            successMessage();
            //creates a file for the user: this is where all of their classes will be stored
            File newFile = new File(getUsername()+".txt");
            //go to login screen
            login();

            //else if one is false
        } else {
            failMessage();
            //end if
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed


    }//GEN-LAST:event_usernameTextActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel UNfeeback;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel error;
    private javax.swing.JLabel fnameFeedback;
    private javax.swing.JTextField fnameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lnameFeedback;
    private javax.swing.JTextField lnameText;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordFeedback;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JRadioButton studentButton;
    private javax.swing.JRadioButton teacherButton;
    private javax.swing.JLabel typeError;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
