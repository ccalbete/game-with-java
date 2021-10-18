/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class TheDataIsEmptyException extends Exception {

    Helper helper = new Helper();

    public TheDataIsEmptyException(String message) {
        super(message);
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, message,
                "Error", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, button, "Ok");

    }

}
