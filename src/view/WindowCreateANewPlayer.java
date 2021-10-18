/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.Company;
import domain.Player;
import domain.Helper;
import exceptions.PlayerAlreadyExistException;
import exceptions.TheDataIsEmptyException;
import exceptions.TheDataEnteredIsNotInTheRangeException;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class WindowCreateANewPlayer extends javax.swing.JFrame {

    private Company company;
    private JLabel[] labelImages = new JLabel[7];
    private Helper helper;

    /**
     * Creates new form WindowCreateANewPlayer
     * when the instance of the window is created, the components are 
     * initialized, the player's avatars are displayed and the properties
     * are defined as the size
     * @param company
     */
    public WindowCreateANewPlayer(Company company) {
        initComponents();
        this.company = company;
        this.helper = new Helper();
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        labelImages[1] = labelImage1;
        labelImages[2] = labelImage2;
        labelImages[3] = labelImage3;
        labelImages[4] = labelImage4;
        labelImages[5] = labelImage5;
        labelImages[6] = labelImage6;
        showImages();
        radioImage1.setSelected(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /***
     * the images are created and displayed in the window
     */
    public void showImages() {
        for (int i = 1; i < labelImages.length; i++) {
            helper.putImage("/images/avatar" + i + ".PNG", labelImages[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupImages = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelCreateANewPlayer = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelAlias = new javax.swing.JLabel();
        textFieldAlias = new javax.swing.JTextField();
        labelAge = new javax.swing.JLabel();
        buttonCreate = new javax.swing.JButton();
        textFieldAge = new javax.swing.JTextField();
        labelImage1 = new javax.swing.JLabel();
        labelImage2 = new javax.swing.JLabel();
        labelImage3 = new javax.swing.JLabel();
        labelImage4 = new javax.swing.JLabel();
        labelImage5 = new javax.swing.JLabel();
        labelImage6 = new javax.swing.JLabel();
        labelSelectAAvatar = new javax.swing.JLabel();
        radioImage1 = new javax.swing.JRadioButton();
        radioImage2 = new javax.swing.JRadioButton();
        radioImage3 = new javax.swing.JRadioButton();
        radioImage4 = new javax.swing.JRadioButton();
        radioImage5 = new javax.swing.JRadioButton();
        radioImage6 = new javax.swing.JRadioButton();
        buttonReturnToMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCreateANewPlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        labelCreateANewPlayer.setText("Create a new player");

        labelName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelName.setText("Name");

        textFieldName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelAlias.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelAlias.setText("Alias");

        textFieldAlias.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldAlias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelAge.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelAge.setText("Age");

        buttonCreate.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonCreate.setText("Create");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        textFieldAge.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        textFieldAge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAgeActionPerformed(evt);
            }
        });

        labelSelectAAvatar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        labelSelectAAvatar.setText("Select a avatar");

        buttonGroupImages.add(radioImage1);

        buttonGroupImages.add(radioImage2);

        buttonGroupImages.add(radioImage3);

        buttonGroupImages.add(radioImage4);

        buttonGroupImages.add(radioImage5);

        buttonGroupImages.add(radioImage6);

        buttonReturnToMainMenu.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonReturnToMainMenu.setText("Return to main menu");
        buttonReturnToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(labelCreateANewPlayer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelAlias)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(labelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(radioImage1)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioImage2)
                                        .addGap(29, 29, 29)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldName)
                                .addComponent(textFieldAlias)
                                .addComponent(textFieldAge, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelSelectAAvatar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(radioImage3)
                                        .addGap(71, 71, 71)
                                        .addComponent(radioImage4)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(radioImage5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioImage6)
                                        .addGap(27, 27, 27))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(buttonCreate)
                        .addGap(18, 18, 18)
                        .addComponent(buttonReturnToMainMenu)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreateANewPlayer)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlias)
                    .addComponent(textFieldAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAge)
                    .addComponent(textFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(labelSelectAAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(labelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioImage1)
                            .addComponent(radioImage4)
                            .addComponent(radioImage5)
                            .addComponent(radioImage6))
                        .addContainerGap(100, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioImage3)
                            .addComponent(radioImage2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCreate)
                            .addComponent(buttonReturnToMainMenu))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /***
     * it is validated that all the entered data are correct, the player 
     * is created and it is saved in the system, in case all the configured 
     * players have not yet been selected, the option of selecting this is 
     * given at the moment
     * @param evt 
     */
    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        // TODO add your handling code here:
        String nameEntered = textFieldName.getText();
        String aliasEntered = textFieldAlias.getText();
        String ageAux = textFieldAge.getText();
        int ageEntered;
        try {
            helper.validateTheDataHaveBeenEntered(nameEntered, "name");
            helper.validateTheDataHaveBeenEntered(aliasEntered, "alias");
            helper.validateTheDataHaveBeenEntered(ageAux, "age");
            company.validateExistPlayer(aliasEntered);
            ageEntered = helper.convertStringNumberToInt(ageAux, "age");
            helper.validateThatIntIsInARange(5, 120, ageEntered, "age");
            Player playerAux = company.createPlayer(nameEntered, aliasEntered, ageEntered, getPathAvatar());
            if (!company.getGame().allConfiguredPlayersAreSelected()) {
                Object[] buttons = {"Yes", "No"};
                int selected = JOptionPane.showOptionDialog(null, "Select this player for this game?",
                        "Player created correctly", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
                if (selected == 0) {
                    company.getGame().getListSelectedPlayers().add(playerAux);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Player created correctly", "", 1);
            }
            this.setVisible(false);
        } catch (PlayerAlreadyExistException | TheDataEnteredIsNotInTheRangeException | TheDataIsEmptyException ex) {
            ex.getMessage();
        }

    }//GEN-LAST:event_buttonCreateActionPerformed
    
    /***
     * according to the radioButton selected, the string of the path of the
     * image to which it is related in the view is returned
     * @return 
     */
    public String getPathAvatar() {
        String path = "";
        if (radioImage1.isSelected()) {
            path = "/images/avatar1.PNG";
        } else {
            if (radioImage2.isSelected()) {
                path = "/images/avatar2.PNG";
            } else {
                if (radioImage3.isSelected()) {
                    path = "/images/avatar3.PNG";
                } else {
                    if (radioImage4.isSelected()) {
                        path = "/images/avatar4.PNG";
                    } else {
                        if (radioImage5.isSelected()) {
                            path = "/images/avatar5.PNG";
                        } else {
                            if (radioImage6.isSelected()) {
                                path = "/images/avatar6.PNG";
                            }
                        }
                    }
                }
            }
        }
        return path;
    }


    private void textFieldAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAgeActionPerformed
    /***
     * the current window is hidden to show only the main menu window
     * @param evt 
     */
    private void buttonReturnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnToMainMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonReturnToMainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(WindowCreateANewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowCreateANewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowCreateANewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowCreateANewPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreate;
    private javax.swing.ButtonGroup buttonGroupImages;
    private javax.swing.JButton buttonReturnToMainMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAge;
    private javax.swing.JLabel labelAlias;
    private javax.swing.JLabel labelCreateANewPlayer;
    private javax.swing.JLabel labelImage1;
    private javax.swing.JLabel labelImage2;
    private javax.swing.JLabel labelImage3;
    private javax.swing.JLabel labelImage4;
    private javax.swing.JLabel labelImage5;
    private javax.swing.JLabel labelImage6;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSelectAAvatar;
    private javax.swing.JRadioButton radioImage1;
    private javax.swing.JRadioButton radioImage2;
    private javax.swing.JRadioButton radioImage3;
    private javax.swing.JRadioButton radioImage4;
    private javax.swing.JRadioButton radioImage5;
    private javax.swing.JRadioButton radioImage6;
    private javax.swing.JTextField textFieldAge;
    private javax.swing.JTextField textFieldAlias;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables
}
