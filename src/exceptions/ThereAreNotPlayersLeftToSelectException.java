/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class ThereAreNotPlayersLeftToSelectException extends Exception {

    Helper helper = new Helper();

    public ThereAreNotPlayersLeftToSelectException() {
        super("There are not players left to select");
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "There are not players left to select", "Error",
                JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
