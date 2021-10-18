/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class PlayerAlreadyExistException extends Exception {

    Helper helper = new Helper();

    public PlayerAlreadyExistException() {
        super("Could not create a player, the alias already exist");
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "Could not create a player, the alias already exist",
                "Error", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
