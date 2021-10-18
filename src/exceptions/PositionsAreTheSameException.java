/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class PositionsAreTheSameException extends Exception {

    Helper helper = new Helper();

    public PositionsAreTheSameException() {
        super("Must enter differents positions");
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "Must enter differents positions", "Error", JOptionPane.ERROR_MESSAGE,
                JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
