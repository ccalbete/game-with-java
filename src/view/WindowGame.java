/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.Company;
import domain.Helper;
import domain.Player;
import exceptions.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class WindowGame extends javax.swing.JFrame {

    private JButton[][] botones;
    private Company company;
    private int[] positionButtons = new int[5];
    private Color colorBorder = Color.white;
    private Player currentPlayer;
    private JLabel[] labelsQuantityBirdsPerPlayer;
    private Helper helper;

    /**
     * when the window instance is created, the components are initialized, the
     * player of the first turn is obtained, the properties of the window are
     * defined as the size, the default values ​​of the elements are loaded
     * Creates new form Window
     */
    public WindowGame(Company company) {
        this.company = company;
        this.helper = new Helper();
        currentPlayer = company.getGame().getThePlayerNextTurn();
        company.getGame().assignColorToPlayers();
        initComponents();
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panelJuego.setLayout(new GridLayout(11, 11, 2, 2));
        botones = new JButton[11][11];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                Color color = helper.convertColors(company.getGame().getBoard().getMatrix()[i][j]);
                jButton.setBackground(color);
                panelJuego.add(jButton);
                botones[i][j] = jButton;

                if (i % 2 == 0 && j % 2 == 0) {
                    paintTablet(i, j, colorBorder);
                    colorBorder = changeColor(colorBorder);
                }

            }
        }
        labelSelectADirection.setVisible(false);
        comboBoxDirection.setVisible(false);
        labelCurrentPlayer.setText("Player: " + currentPlayer + " - Color: " + currentPlayer.getColor());
        labelPressTwoSquares.setText("Press two " + currentPlayer.getColor().toLowerCase() + " squares");
        labelPressASquare.setVisible(false);
        helper.putImage(currentPlayer.getPathAvatar(), labelImagePlayer);
        company.getGame().increaseQuantityOfOpponentToPlayers();
        company.getGame().increaseQuantityGamesPlayedToPlayers();
        labelsQuantityBirdsPerPlayer = new JLabel[4];
        labelsQuantityBirdsPerPlayer[0] = labelQuantityBirdsPlayer1;
        labelsQuantityBirdsPerPlayer[1] = labelQuantityBirdsPlayer2;
        labelsQuantityBirdsPerPlayer[2] = labelQuantityBirdsPlayer3;
        labelsQuantityBirdsPerPlayer[3] = labelQuantityBirdsPlayer4;
        labelQuantityBirdsPlayer3.setVisible(false);
        labelQuantityBirdsPlayer4.setVisible(false);
        updateQuantityBirdsPerPlayer();
    }

    /**
     * *
     * auxiliary method to know when to change background color of border
     *
     * @param color
     * @return
     */
    public Color changeColor(Color color) {
        if (color == Color.white) {
            return Color.gray;
        } else {
            return Color.white;
        }
    }

    /**
     * *
     * method that allows to give color of edge to the tablet
     *
     * @param i
     * @param j
     * @param color
     */
    public void paintTablet(int i, int j, Color color) {
        botones[i][j].setBorder(BorderFactory.createLineBorder(color, 6));
        botones[i - 1][j].setBorder(BorderFactory.createLineBorder(color, 6));
        botones[i][j - 1].setBorder(BorderFactory.createLineBorder(color, 6));
        botones[i - 1][j - 1].setBorder(BorderFactory.createLineBorder(color, 6));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioTypeMovement = new javax.swing.ButtonGroup();
        panelJuego = new java.awt.Panel();
        radioConnect = new javax.swing.JRadioButton();
        radioExtend = new javax.swing.JRadioButton();
        buttonPlay = new javax.swing.JButton();
        comboBoxDirection = new javax.swing.JComboBox();
        labelChooseTypeMovement = new javax.swing.JLabel();
        labelCurrentPlayer = new javax.swing.JLabel();
        labelQuantityBirdsPlayer1 = new javax.swing.JLabel();
        labelQuantityBirdsPlayer2 = new javax.swing.JLabel();
        labelQuantityBirdsPlayer3 = new javax.swing.JLabel();
        labelQuantityBirdsPlayer4 = new javax.swing.JLabel();
        labelTurnOf = new javax.swing.JLabel();
        labelPressTwoSquares = new javax.swing.JLabel();
        labelPressASquare = new javax.swing.JLabel();
        labelSelectADirection = new javax.swing.JLabel();
        labelBirdsPerPlayer = new javax.swing.JLabel();
        labelImagePlayer = new javax.swing.JLabel();
        buttonGiveUp = new javax.swing.JButton();
        labelCoordinatesButton1 = new javax.swing.JLabel();
        labelCoordinatesButton2 = new javax.swing.JLabel();
        labelColumn1 = new javax.swing.JLabel();
        labelColumn2 = new javax.swing.JLabel();
        labelColumn3 = new javax.swing.JLabel();
        labelColumn4 = new javax.swing.JLabel();
        labelColumn5 = new javax.swing.JLabel();
        labelColumn6 = new javax.swing.JLabel();
        labelColumn7 = new javax.swing.JLabel();
        labelColumn8 = new javax.swing.JLabel();
        labelColumn9 = new javax.swing.JLabel();
        labelColumn10 = new javax.swing.JLabel();
        labelRow1 = new javax.swing.JLabel();
        labelRow2 = new javax.swing.JLabel();
        labelRow3 = new javax.swing.JLabel();
        labelRow4 = new javax.swing.JLabel();
        labelRow5 = new javax.swing.JLabel();
        labelRow6 = new javax.swing.JLabel();
        labelRow7 = new javax.swing.JLabel();
        labelRow8 = new javax.swing.JLabel();
        labelRow9 = new javax.swing.JLabel();
        labelRow10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 600, 800, 800));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego);
        panelJuego.setBounds(30, 30, 490, 320);

        radioTypeMovement.add(radioConnect);
        radioConnect.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        radioConnect.setSelected(true);
        radioConnect.setText("Connect positions");
        radioConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioConnectActionPerformed(evt);
            }
        });
        getContentPane().add(radioConnect);
        radioConnect.setBounds(530, 140, 130, 23);

        radioTypeMovement.add(radioExtend);
        radioExtend.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        radioExtend.setText("Extend position in direction");
        radioExtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioExtendActionPerformed(evt);
            }
        });
        getContentPane().add(radioExtend);
        radioExtend.setBounds(530, 210, 170, 40);

        buttonPlay.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonPlay.setText("Play");
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlay);
        buttonPlay.setBounds(570, 400, 90, 23);

        comboBoxDirection.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        comboBoxDirection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "up", "down", "right", "left" }));
        getContentPane().add(comboBoxDirection);
        comboBoxDirection.setBounds(630, 290, 60, 20);

        labelChooseTypeMovement.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 11)); // NOI18N
        labelChooseTypeMovement.setText("Choose the type movement:");
        getContentPane().add(labelChooseTypeMovement);
        labelChooseTypeMovement.setBounds(530, 70, 180, 30);

        labelCurrentPlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        getContentPane().add(labelCurrentPlayer);
        labelCurrentPlayer.setBounds(20, 370, 200, 20);

        labelQuantityBirdsPlayer1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelQuantityBirdsPlayer1);
        labelQuantityBirdsPlayer1.setBounds(270, 370, 210, 20);

        labelQuantityBirdsPlayer2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelQuantityBirdsPlayer2);
        labelQuantityBirdsPlayer2.setBounds(270, 390, 210, 20);

        labelQuantityBirdsPlayer3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelQuantityBirdsPlayer3);
        labelQuantityBirdsPlayer3.setBounds(270, 410, 210, 20);

        labelQuantityBirdsPlayer4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelQuantityBirdsPlayer4);
        labelQuantityBirdsPlayer4.setBounds(270, 430, 210, 20);

        labelTurnOf.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        labelTurnOf.setText("Current turn:");
        getContentPane().add(labelTurnOf);
        labelTurnOf.setBounds(20, 350, 80, 20);

        labelPressTwoSquares.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelPressTwoSquares);
        labelPressTwoSquares.setBounds(550, 170, 140, 20);

        labelPressASquare.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelPressASquare);
        labelPressASquare.setBounds(550, 250, 140, 20);

        labelSelectADirection.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        labelSelectADirection.setText("Select a direction");
        getContentPane().add(labelSelectADirection);
        labelSelectADirection.setBounds(540, 290, 90, 20);

        labelBirdsPerPlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        labelBirdsPerPlayer.setText("Birds placed per player:");
        getContentPane().add(labelBirdsPerPlayer);
        labelBirdsPerPlayer.setBounds(270, 350, 150, 20);

        labelImagePlayer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelImagePlayer);
        labelImagePlayer.setBounds(30, 390, 150, 70);

        buttonGiveUp.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        buttonGiveUp.setText("Give up");
        buttonGiveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGiveUpActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGiveUp);
        buttonGiveUp.setBounds(570, 440, 90, 23);

        labelCoordinatesButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelCoordinatesButton1);
        labelCoordinatesButton1.setBounds(530, 330, 130, 20);

        labelCoordinatesButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        getContentPane().add(labelCoordinatesButton2);
        labelCoordinatesButton2.setBounds(530, 360, 130, 20);

        labelColumn1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn1.setText("1");
        getContentPane().add(labelColumn1);
        labelColumn1.setBounds(40, 10, 20, 14);

        labelColumn2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn2.setText("2");
        getContentPane().add(labelColumn2);
        labelColumn2.setBounds(90, 10, 20, 14);

        labelColumn3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn3.setText("3");
        getContentPane().add(labelColumn3);
        labelColumn3.setBounds(140, 10, 20, 14);

        labelColumn4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn4.setText("4");
        getContentPane().add(labelColumn4);
        labelColumn4.setBounds(180, 10, 34, 14);

        labelColumn5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn5.setText("5");
        getContentPane().add(labelColumn5);
        labelColumn5.setBounds(230, 10, 34, 14);

        labelColumn6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn6.setText("6");
        getContentPane().add(labelColumn6);
        labelColumn6.setBounds(280, 10, 34, 14);

        labelColumn7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn7.setText("7");
        getContentPane().add(labelColumn7);
        labelColumn7.setBounds(330, 10, 34, 14);

        labelColumn8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn8.setText("8");
        getContentPane().add(labelColumn8);
        labelColumn8.setBounds(380, 10, 34, 14);

        labelColumn9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn9.setText("9");
        getContentPane().add(labelColumn9);
        labelColumn9.setBounds(440, 10, 20, 14);

        labelColumn10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelColumn10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelColumn10.setText("10");
        getContentPane().add(labelColumn10);
        labelColumn10.setBounds(490, 10, 9, 14);

        labelRow1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow1.setText("1");
        getContentPane().add(labelRow1);
        labelRow1.setBounds(0, 30, 34, 14);

        labelRow2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow2.setText("2");
        getContentPane().add(labelRow2);
        labelRow2.setBounds(0, 60, 34, 14);

        labelRow3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow3.setText("3");
        getContentPane().add(labelRow3);
        labelRow3.setBounds(0, 90, 34, 14);

        labelRow4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow4.setText("4");
        getContentPane().add(labelRow4);
        labelRow4.setBounds(0, 120, 34, 14);

        labelRow5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow5.setText("5");
        getContentPane().add(labelRow5);
        labelRow5.setBounds(0, 150, 34, 14);

        labelRow6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow6.setText("6");
        getContentPane().add(labelRow6);
        labelRow6.setBounds(0, 180, 30, 14);

        labelRow7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow7.setText("7");
        getContentPane().add(labelRow7);
        labelRow7.setBounds(0, 210, 34, 14);

        labelRow8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow8.setText("8");
        getContentPane().add(labelRow8);
        labelRow8.setBounds(0, 240, 34, 14);

        labelRow9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow9.setText("9");
        getContentPane().add(labelRow9);
        labelRow9.setBounds(0, 270, 30, 14);

        labelRow10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        labelRow10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRow10.setText("10");
        getContentPane().add(labelRow10);
        labelRow10.setBounds(0, 300, 30, 14);

        setBounds(0, 0, 716, 557);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * *
     * it is validated that all the entered data are correct, the movement is
     * specified, in case of being well placed birds, in case of being wrong
     * throws an exception and an error message. At the end, update the board
     * with the new data
     *
     * @param evt
     */
    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        if (!company.getGame().gameOver()) {
            try {
                // TODO add your handling code here:
                helper.validateQuantityOfMovementData(positionButtons);
                helper.validateIfTheSamePositions(positionButtons);
                company.getGame().getBoard().validateColorsMatch(positionButtons, currentPlayer);
                if (radioConnect.isSelected()) {
                    company.getGame().getBoard().validatePositionsAreHorizontalOrVertical(positionButtons[1],
                            positionButtons[3], positionButtons[2], positionButtons[4]);
                    if (company.getGame().getBoard().positionsAreVertical(positionButtons[2], positionButtons[4])) {
                        int[] columnRowMatch = {positionButtons[2], positionButtons[1], positionButtons[3]};
                        company.getGame().getBoard().connectPositionsVertically(currentPlayer, columnRowMatch);
                    }
                    if (company.getGame().getBoard().positionsAreHorizontal(positionButtons[1], positionButtons[3])) {
                        int[] rowColumnMatch = {positionButtons[1], positionButtons[2], positionButtons[4]};
                        company.getGame().getBoard().connectPositionsHorizontally(currentPlayer, rowColumnMatch);
                    }
                } else {
                    int[] rowColumnMatch = {positionButtons[1], positionButtons[2]};
                    company.getGame().getBoard().extendInDirection(rowColumnMatch,
                            currentPlayer, (String) comboBoxDirection.getSelectedItem());
                }
                refreshBoard();
            } catch (TheDataIsEmptyException | CouldNotConnectPositionsException |
                    PositionsAreNeitherHorizontalNorVerticalException | PositionsAreTheSameException |
                    PositionsAreNotPlayerColorException | CouldNotExtendDirectionException ex) {
                labelCoordinatesButton1.setText("");
                labelCoordinatesButton2.setText("");
                radioConnect.setSelected(true);
                labelPressTwoSquares.setVisible(true);
                labelPressTwoSquares.setText("Press two " + currentPlayer.getColor().toLowerCase() + " squares");
                labelSelectADirection.setVisible(false);
                comboBoxDirection.setVisible(false);
                labelPressASquare.setVisible(false);
                ex.getMessage();
            }
        } else {
            refreshBoard();
            company.getGame().setQuantityGamesPlayedOfPlayers();
            showWinners(company.getGame().getWinnersPlayers());
        }
    }//GEN-LAST:event_buttonPlayActionPerformed

    /**
     * *
     * winners are received per parameter and displayed in a window
     *
     * @param winners
     */
    public void showWinners(ArrayList<Player> winners) {
        String winnersToShow = "Winner(s): ";
        for (int i = 0; i < winners.size(); i++) {
            if (i != 0) {
                winnersToShow += ", ";
            }
            winnersToShow += winners.get(i);
        }
        JOptionPane.showMessageDialog(null, winnersToShow, "Game Over", 1);
        this.setVisible(false);
    }

    /**
     * *
     * each time the connect movement type is selected, the previous values ​​
     * of button coordinates are deleted and informative text is shown of which
     * data is necessary to carry out this movement
     *
     * @param evt
     */
    private void radioConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioConnectActionPerformed
        // TODO add your handling code here:
        positionButtons[0] = 0;
        positionButtons[1] = 0;
        positionButtons[2] = 0;
        positionButtons[3] = 0;
        positionButtons[4] = 0;
        labelPressTwoSquares.setVisible(true);
        labelPressTwoSquares.setText("Press two " + currentPlayer.getColor().toLowerCase() + " squares");
        labelSelectADirection.setVisible(false);
        comboBoxDirection.setVisible(false);
        labelPressASquare.setVisible(false);
        labelCoordinatesButton1.setText("");
        labelCoordinatesButton2.setText("");
    }//GEN-LAST:event_radioConnectActionPerformed

    /**
     * *
     * each time the extend movement type is selected, the previous values ​​of
     * pressed button coordinates are erased and informative text is shown of
     * what data is necessary to perform this movement
     *
     * @param evt
     */
    private void radioExtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioExtendActionPerformed
        // TODO add your handling code here:
        positionButtons[0] = 1;
        positionButtons[1] = 0;
        positionButtons[2] = 0;
        positionButtons[3] = 0;
        positionButtons[4] = 0;
        labelPressASquare.setVisible(true);
        labelPressASquare.setText("Press one " + currentPlayer.getColor().toLowerCase() + " square");
        labelSelectADirection.setVisible(true);
        comboBoxDirection.setVisible(true);
        labelPressTwoSquares.setVisible(false);
        labelCoordinatesButton1.setText("");
        labelCoordinatesButton2.setText("");

    }//GEN-LAST:event_radioExtendActionPerformed
    /**
     * *
     * when the player surrenders, the other players are shown as winners
     *
     * @param evt
     */
    private void buttonGiveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGiveUpActionPerformed
        // TODO add your handling code here:
        showWinners(company.getGame().getPlayersWhoDidNotSurrender(currentPlayer));

    }//GEN-LAST:event_buttonGiveUpActionPerformed
    /**
     * method that asks position by position if it has to show bird and shows
     * it, also updates the labels of the number of birds placed and the current
     * player turn
     */
    private void refreshBoard() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (company.getGame().getBoard().existBirdInPosition(i, j, currentPlayer.getColor())) {
                    Color color = helper.convertColors(currentPlayer.getColor());
                    botones[i][j].setBackground(color);
                    botones[i][j].setText("X");
                    botones[i][j].setEnabled(false);
                }
            }
        }
        currentPlayer = company.getGame().getThePlayerNextTurn();
        labelCurrentPlayer.setText("Player: " + currentPlayer + " - Color: " + currentPlayer.getColor());
        updateQuantityBirdsPerPlayer();
        helper.putImage(currentPlayer.getPathAvatar(), labelImagePlayer);
        labelCoordinatesButton1.setText("");
        labelCoordinatesButton2.setText("");
        radioConnect.setSelected(true);
        labelPressTwoSquares.setVisible(true);
        labelPressTwoSquares.setText("Press two " + currentPlayer.getColor().toLowerCase() + " squares");
        labelSelectADirection.setVisible(false);
        comboBoxDirection.setVisible(false);
        labelPressASquare.setVisible(false);
    }

    /**
     * *
     * method that updates the label that shows the number of birds that each
     * player has placed
     */
    public void updateQuantityBirdsPerPlayer() {
        for (int i = 0; i < company.getGame().getListSelectedPlayers().size(); i++) {
            updateQuantityBirdsToPlayer(labelsQuantityBirdsPerPlayer[i], i);
        }
    }

    /**
     * *
     * auxiliary method that updates the label that shows the number of birds
     * that a player has in specific
     *
     * @param label
     * @param position
     */
    public void updateQuantityBirdsToPlayer(JLabel label, int position) {
        label.setVisible(true);
        label.setText("Player " + company.getGame().getListSelectedPlayers().get(position)
                + ": " + company.getGame().getListSelectedPlayers().get(position).getQuantityBirdsOnBoard()
                + " ");
    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
// cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
// Método a completar!.
// En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
// fila 1 y columna 1 corresponden a la posición de arriba a la izquierda.
// Debe indicarse cómo responder al click de ese botón.
        if (radioExtend.isSelected()) {
            positionButtons[1] = fila;
            positionButtons[2] = columna;
            labelCoordinatesButton1.setText("Button 1 pressed "
                    + "(" + positionButtons[1] + "," + positionButtons[2] + ")");
            labelCoordinatesButton2.setVisible(false);
        } else {
            if (positionButtons[1] != 0 && positionButtons[3] != 0) {
                positionButtons[1] = fila;
                positionButtons[2] = columna;
                positionButtons[3] = 0;
                positionButtons[4] = 0;
                labelCoordinatesButton1.setText("Button 1 pressed "
                        + "(" + positionButtons[1] + "," + positionButtons[2] + ")");
                labelCoordinatesButton2.setText("Button 2 pressed "
                        + "( , )");
            } else {
                if (positionButtons[1] == 0 || positionButtons[3] != 0) {
                    positionButtons[1] = fila;
                    positionButtons[2] = columna;
                    labelCoordinatesButton1.setText("Button 1 pressed "
                            + "(" + positionButtons[1] + "," + positionButtons[2] + ")");
                    labelCoordinatesButton2.setText("Button 2 pressed "
                            + "( , )");
                } else {
                    positionButtons[3] = fila;
                    positionButtons[4] = columna;
                    labelCoordinatesButton1.setText("Button 1 pressed "
                            + "(" + positionButtons[1] + "," + positionButtons[2] + ")");

                    labelCoordinatesButton2.setText("Button 2 pressed "
                            + "(" + positionButtons[3] + "," + positionButtons[4] + ")");
                }
            }
        }
    }

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
            java.util.logging.Logger.getLogger(WindowGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGiveUp;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JComboBox comboBoxDirection;
    private javax.swing.JLabel labelBirdsPerPlayer;
    private javax.swing.JLabel labelChooseTypeMovement;
    private javax.swing.JLabel labelColumn1;
    private javax.swing.JLabel labelColumn10;
    private javax.swing.JLabel labelColumn2;
    private javax.swing.JLabel labelColumn3;
    private javax.swing.JLabel labelColumn4;
    private javax.swing.JLabel labelColumn5;
    private javax.swing.JLabel labelColumn6;
    private javax.swing.JLabel labelColumn7;
    private javax.swing.JLabel labelColumn8;
    private javax.swing.JLabel labelColumn9;
    private javax.swing.JLabel labelCoordinatesButton1;
    private javax.swing.JLabel labelCoordinatesButton2;
    private javax.swing.JLabel labelCurrentPlayer;
    private javax.swing.JLabel labelImagePlayer;
    private javax.swing.JLabel labelPressASquare;
    private javax.swing.JLabel labelPressTwoSquares;
    private javax.swing.JLabel labelQuantityBirdsPlayer1;
    private javax.swing.JLabel labelQuantityBirdsPlayer2;
    private javax.swing.JLabel labelQuantityBirdsPlayer3;
    private javax.swing.JLabel labelQuantityBirdsPlayer4;
    private javax.swing.JLabel labelRow1;
    private javax.swing.JLabel labelRow10;
    private javax.swing.JLabel labelRow2;
    private javax.swing.JLabel labelRow3;
    private javax.swing.JLabel labelRow4;
    private javax.swing.JLabel labelRow5;
    private javax.swing.JLabel labelRow6;
    private javax.swing.JLabel labelRow7;
    private javax.swing.JLabel labelRow8;
    private javax.swing.JLabel labelRow9;
    private javax.swing.JLabel labelSelectADirection;
    private javax.swing.JLabel labelTurnOf;
    private java.awt.Panel panelJuego;
    private javax.swing.JRadioButton radioConnect;
    private javax.swing.JRadioButton radioExtend;
    private javax.swing.ButtonGroup radioTypeMovement;
    // End of variables declaration//GEN-END:variables
}
