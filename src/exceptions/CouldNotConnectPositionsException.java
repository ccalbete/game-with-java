/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;
import domain.Helper;

public class CouldNotConnectPositionsException extends Exception {
     Helper helper = new Helper();
     
    public CouldNotConnectPositionsException() {
        super("Could not connect the positions, there are birds of other players on the road");
        Object[] button = {"Ok"};
         helper.playErrorSound();
        JOptionPane.showOptionDialog(null, "Could not connect the positions, "
                + "there are birds of other players on the road",
                "Error", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, button, "Ok");
    }

}
