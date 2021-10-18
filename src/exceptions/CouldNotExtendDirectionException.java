/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class CouldNotExtendDirectionException extends Exception {

    Helper helper = new Helper();

    public CouldNotExtendDirectionException() {
        super("Could not extend, there are birds of other players on the road");
        Object[] button = {"Ok"};
        helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "Could not extend, there are birds of other players on the road", "Error", JOptionPane.ERROR_MESSAGE,
                JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
