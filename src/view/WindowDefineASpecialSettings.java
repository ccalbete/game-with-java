/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.Company;
import domain.Helper;
import exceptions.*;

public class WindowDefineASpecialSettings extends javax.swing.JFrame {

    private Company company;
    private Helper helper;

    /**
     * when the window instance is created, the components are initialized, 
     * the current configuration values ​​are displayed and properties such as 
     * size are defined
     * Creates new form WindowDefineASpecialSettings
     */
    WindowDefineASpecialSettings(Company company) {
        this.company = company;
        this.helper = new Helper();
        initComponents();
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        textFieldQuantityPlayers.setText(Integer.toString(company.getGame().getQuantityPlayersConfigured()));
        textFieldQuantityOfBirdsPerPlayer.setText(Integer.toString(company.getGame().getQuantityBirdsPlayerConfigured()));
        textFieldQuantityTurnsIsFinished.setVisible(true);
        textFieldQuantityTurnsIsFinished.setText(Integer.toString(company.getGame().getQuantityTurnsToFinishConfigured()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupWayToFinish = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelDefineASpecialSettings = new javax.swing.JLabel();
        textFieldQuantityPlayers = new javax.swing.JTextField();
        labelQuantityPlayers = new javax.swing.JLabel();
        labelQuantityOfBirdsPerPlayer = new javax.swing.JLabel();
        textFieldQuantityOfBirdsPerPlayer = new javax.swing.JTextField();
        labelWayToFinish = new javax.swing.JLabel();
        radioAllTheBirdsArePlaced = new javax.swing.JRadioButton();
        radioQuantityTurnsIsFinished = new javax.swing.JRadioButton();
        textFieldQuantityTurnsIsFinished = new javax.swing.JTextField();
        buttonDontSaveAndReturnMenu = new javax.swing.JButton();
        buttonSaveAndReturnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelDefineASpecialSettings.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        labelDefineASpecialSettings.setText("Define a special settings");

        textFieldQuantityPlayers.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldQuantityPlayers.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldQuantityPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantityPlayersActionPerformed(evt);
            }
        });

        labelQuantityPlayers.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelQuantityPlayers.setText("Quantity Players");

        labelQuantityOfBirdsPerPlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelQuantityOfBirdsPerPlayer.setText("Quantity of birds per player");

        textFieldQuantityOfBirdsPerPlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldQuantityOfBirdsPerPlayer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldQuantityOfBirdsPerPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantityOfBirdsPerPlayerActionPerformed(evt);
            }
        });

        labelWayToFinish.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelWayToFinish.setText("Way to finish");

        buttonGroupWayToFinish.add(radioAllTheBirdsArePlaced);
        radioAllTheBirdsArePlaced.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        radioAllTheBirdsArePlaced.setText("All the birds are placed");
        radioAllTheBirdsArePlaced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAllTheBirdsArePlacedActionPerformed(evt);
            }
        });

        buttonGroupWayToFinish.add(radioQuantityTurnsIsFinished);
        radioQuantityTurnsIsFinished.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        radioQuantityTurnsIsFinished.setSelected(true);
        radioQuantityTurnsIsFinished.setText("The quantity turns is finished");
        radioQuantityTurnsIsFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioQuantityTurnsIsFinishedActionPerformed(evt);
            }
        });

        textFieldQuantityTurnsIsFinished.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldQuantityTurnsIsFinished.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonDontSaveAndReturnMenu.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonDontSaveAndReturnMenu.setText("Don't save and return to the main menu");
        buttonDontSaveAndReturnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDontSaveAndReturnMenuActionPerformed(evt);
            }
        });

        buttonSaveAndReturnMenu.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonSaveAndReturnMenu.setText("Save and return to the main menu");
        buttonSaveAndReturnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveAndReturnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelWayToFinish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQuantityOfBirdsPerPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQuantityPlayers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldQuantityPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioAllTheBirdsArePlaced)
                    .addComponent(textFieldQuantityOfBirdsPerPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioQuantityTurnsIsFinished)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldQuantityTurnsIsFinished, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonSaveAndReturnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(165, 165, 165)
                            .addComponent(labelDefineASpecialSettings))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(buttonDontSaveAndReturnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDefineASpecialSettings)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantityPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldQuantityPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantityOfBirdsPerPlayer)
                    .addComponent(textFieldQuantityOfBirdsPerPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelWayToFinish)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioQuantityTurnsIsFinished)
                        .addComponent(textFieldQuantityTurnsIsFinished, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioAllTheBirdsArePlaced)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(buttonSaveAndReturnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDontSaveAndReturnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldQuantityPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantityPlayersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantityPlayersActionPerformed

    private void textFieldQuantityOfBirdsPerPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantityOfBirdsPerPlayerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantityOfBirdsPerPlayerActionPerformed
    /***
     * every time you click the radioButton of waytofinish all the birds 
     * is placed the element is hidden to enter the number of turns to finish
     * @param evt 
     */
    private void radioAllTheBirdsArePlacedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAllTheBirdsArePlacedActionPerformed
        // TODO add your handling code here:
        textFieldQuantityTurnsIsFinished.setVisible(false);
    }//GEN-LAST:event_radioAllTheBirdsArePlacedActionPerformed
    /***
     * every time you click the radixButton of waytofinish the quantity turns 
     * is finished, the element that allows you to enter the quantity and the 
     * current value is displayed
     * @param evt 
     */
    private void radioQuantityTurnsIsFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioQuantityTurnsIsFinishedActionPerformed
        // TODO add your handling code here:
        textFieldQuantityTurnsIsFinished.setVisible(true);
        textFieldQuantityTurnsIsFinished.setText(Integer.toString(company.getGame().getQuantityTurnsToFinishConfigured()));
    }//GEN-LAST:event_radioQuantityTurnsIsFinishedActionPerformed
    /***
     * it is validated that all the data are correct and the values ​​of 
     * the configuration are overwritten
     * @param evt 
     */
    private void buttonSaveAndReturnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveAndReturnMenuActionPerformed

        try {
            /*the entered data is validated, if any is not correct, the message exception is thrown and if 
             all are correct they are saved as new configuration
             */
            helper.validateTheDataHaveBeenEntered(textFieldQuantityPlayers.getText(), "quantity players");
            int quantityPlayers = helper.convertStringNumberToInt(textFieldQuantityPlayers.getText(), 
                    "quantity players");
            helper.validateThatIntIsInARange(2, 4, quantityPlayers, "quantity players");

            helper.validateTheDataHaveBeenEntered(textFieldQuantityOfBirdsPerPlayer.getText(), "quantity birds");
            int quantityBirds = helper.convertStringNumberToInt(textFieldQuantityOfBirdsPerPlayer.getText(), "quantity birds");
            helper.validateThatIntIsInARange(5, 45, quantityBirds, "quantity birds");

            if (radioQuantityTurnsIsFinished.isSelected()) {
                helper.validateTheDataHaveBeenEntered(textFieldQuantityTurnsIsFinished.getText(), "quantity turns to finish");
                int quantityTurnsToFinish = helper.convertStringNumberToInt(textFieldQuantityTurnsIsFinished.getText(), "quantity turns to finish");
                helper.validateThatIntIsInARange(1, 50, quantityTurnsToFinish, "quantity turns to finish");
                company.getGame().defineSpecialSettings(quantityPlayers, quantityBirds, quantityTurnsToFinish);
            } else {
                company.getGame().defineSpecialSettings(quantityPlayers, quantityBirds);
            }
            this.setVisible(false);
        } catch (TheDataEnteredIsNotInTheRangeException | TheDataIsEmptyException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_buttonSaveAndReturnMenuActionPerformed
    /***
     * this window is hidden so that only the main menu window is displayed
     * @param evt 
     */
    private void buttonDontSaveAndReturnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDontSaveAndReturnMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonDontSaveAndReturnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(WindowDefineASpecialSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowDefineASpecialSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowDefineASpecialSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowDefineASpecialSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDontSaveAndReturnMenu;
    private javax.swing.ButtonGroup buttonGroupWayToFinish;
    private javax.swing.JButton buttonSaveAndReturnMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDefineASpecialSettings;
    private javax.swing.JLabel labelQuantityOfBirdsPerPlayer;
    private javax.swing.JLabel labelQuantityPlayers;
    private javax.swing.JLabel labelWayToFinish;
    private javax.swing.JRadioButton radioAllTheBirdsArePlaced;
    private javax.swing.JRadioButton radioQuantityTurnsIsFinished;
    private javax.swing.JTextField textFieldQuantityOfBirdsPerPlayer;
    private javax.swing.JTextField textFieldQuantityPlayers;
    private javax.swing.JTextField textFieldQuantityTurnsIsFinished;
    // End of variables declaration//GEN-END:variables
}
