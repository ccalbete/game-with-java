/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class PositionsAreNotPlayerColorException extends Exception {

    Helper helper = new Helper();

    public PositionsAreNotPlayerColorException(String color) {
        super("Must enter 2 positions with color " + color);
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "Must enter 2 positions with color " + color, "Error", JOptionPane.ERROR_MESSAGE,
                JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
