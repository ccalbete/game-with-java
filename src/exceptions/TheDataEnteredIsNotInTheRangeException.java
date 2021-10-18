/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class TheDataEnteredIsNotInTheRangeException extends Exception {

    Helper helper = new Helper();

    public TheDataEnteredIsNotInTheRangeException(String data, int since, int until) {
        super("The " + data + " must be within the range " + since + "-" + until);
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "The " + data + " must be within the range " + since + "-" + until, "Error", JOptionPane.ERROR_MESSAGE,
                JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
