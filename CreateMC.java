/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

/**
 *
 * @author timbi
 */
public class CreateMC extends javax.swing.JFrame {
    String question, answer, mc1, mc2, mc3, mc4;
    /**
     * Creates new form CreateNumeric
     */
    public CreateMC() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionVar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        answerVar = new javax.swing.JTextField();
        finishVar = new javax.swing.JButton();
        newVar = new javax.swing.JButton();
        quitVar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        mc2Var = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mc1Var = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mc3Var = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mc4Var = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("New Question");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Question:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("MC1:");

        answerVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerVarActionPerformed(evt);
            }
        });

        finishVar.setText("Finish");
        finishVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishVarActionPerformed(evt);
            }
        });

        newVar.setText("New Question");
        newVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVarActionPerformed(evt);
            }
        });

        quitVar.setText("Quit");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Answer:");

        mc2Var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mc2VarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("MC2:");

        mc1Var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mc1VarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("MC3:");

        mc3Var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mc3VarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("MC4:");

        mc4Var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mc4VarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(quitVar)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionVar, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mc1Var, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mc2Var, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(answerVar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(mc3Var, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(mc4Var, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(newVar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishVar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mc2Var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(mc1Var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mc3Var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(mc4Var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishVar)
                    .addComponent(newVar)
                    .addComponent(quitVar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finishVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishVarActionPerformed
        question = questionVar.getText();
        answer = answerVar.getText();
        mc1 = mc1Var.getText();
        mc2 = mc2Var.getText();
        mc3 = mc3Var.getText();
        mc4 = mc4Var.getText();
        MultipleChoice qmc = new MultipleChoice("mc", question, mc1, mc2, mc3, mc4);
        Questions.questions.add(qmc);
        Questions.questions.remove(qmc);
        MultipleChoice amc = new MultipleChoice("mc", question, mc1, mc2, mc3, mc4, answer);
        Questions.answers.add(amc);
        Questions.answers.remove(amc);
        Questions.writeToFileQQ(CreateQuiz.quizName, CreateQuiz.quizNum);
        Questions.writeToFileAA(CreateQuiz.quizName, CreateQuiz.quizNum);
        Questions.answers.clear();
        Questions.questions.clear();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateMC().setVisible(false);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_finishVarActionPerformed

    private void answerVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerVarActionPerformed

    private void mc2VarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mc2VarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mc2VarActionPerformed

    private void mc1VarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mc1VarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mc1VarActionPerformed

    private void mc3VarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mc3VarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mc3VarActionPerformed

    private void mc4VarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mc4VarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mc4VarActionPerformed

    private void newVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVarActionPerformed
        // TODO add your handling code here:\
        Questions q = new Questions();
        question = questionVar.getText();
        answer = answerVar.getText();
        mc1 = mc1Var.getText();
        mc2 = mc2Var.getText();
        mc3 = mc3Var.getText();
        mc4 = mc4Var.getText();
        MultipleChoice qmc = new MultipleChoice("mc", question, mc1, mc2, mc3, mc4);
        Questions.questions.add(qmc);
        Questions.questions.remove(qmc);
        MultipleChoice amc = new MultipleChoice("mc", question, mc1, mc2, mc3, mc4, answer);
        Questions.answers.add(amc);
        Questions.answers.remove(amc);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateMC().setVisible(false);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TypeQuestion().setVisible(true);
            }
        });
    }//GEN-LAST:event_newVarActionPerformed

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
            java.util.logging.Logger.getLogger(CreateMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateMC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerVar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton finishVar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField mc1Var;
    private javax.swing.JTextField mc2Var;
    private javax.swing.JTextField mc3Var;
    private javax.swing.JTextField mc4Var;
    private javax.swing.JButton newVar;
    private javax.swing.JTextField questionVar;
    private javax.swing.JButton quitVar;
    // End of variables declaration//GEN-END:variables
}
