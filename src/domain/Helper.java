/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
//Cinthya Calbete 229418
import exceptions.PositionsAreTheSameException;
import exceptions.TheDataEnteredIsNotInTheRangeException;
import exceptions.TheDataIsEmptyException;
import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Helper {

    private boolean anErrorWasFound = false;

    /**
     * *
     * it is evaluated if the data is left empty, in case it has been left empty
     * if an exception is made and the nameData is requested to show a specific
     * message
     *
     * @param data
     * @param nameData
     * @throws TheDataIsEmptyException
     */
    public void validateTheDataHaveBeenEntered(String data, String nameData) throws TheDataIsEmptyException {
        if (data.isEmpty()) {
            throw new TheDataIsEmptyException("Must enter the " + nameData);
        }
    }

    /**
     * it is evaluated that the player has entered the quantity of data required
     * for the movement
     *
     * @param positionButtons
     * @throws TheDataIsEmptyException
     */
    public void validateQuantityOfMovementData(int[] positionButtons) throws TheDataIsEmptyException {
        if (positionButtons[0] == 1 && positionButtons[1] == 0 ) {//if the movement is extend
            throw new TheDataIsEmptyException("Must press a button");
        }
        if (positionButtons[0] == 0 //if the movement is connect
                && (positionButtons[1] == 0
                || positionButtons[4] == 0)) {
            throw new TheDataIsEmptyException("Must press two buttons");
        }
    }

    /**
     * *
     * it is evaluated if the player pressed more than once the same button for
     * the same move positionButtons[1] positionButtons[2] correspond to the
     * coordinates of the position of the first pressed button and
     * positionButtons[3] positionButtons[4] corresponds to the second button
     *
     * @param positionButtons
     * @throws PositionsAreTheSameException
     */
    public void validateIfTheSamePositions(int[] positionButtons) throws PositionsAreTheSameException {
        if (Integer.toString(positionButtons[1]).equals(Integer.toString(positionButtons[3]))
                && Integer.toString(positionButtons[2]).equals(Integer.toString(positionButtons[4]))) {
            throw new PositionsAreTheSameException();
        }
    }

    /**
     * *
     * you try to convert the string into a number, in case you can not because
     * it contains letters, an exception is thrown.
     *
     * @param number
     * @return
     * @throws TheDataEnteredIsNotInTheRangeException
     */
    public int convertStringNumberToInt(String number, String nameData) throws TheDataEnteredIsNotInTheRangeException {
        int numberAux = 0;
        try {
            numberAux = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            Object[] button = {"Ok"};
            this.playErrorSound();
            JOptionPane.showOptionDialog(null, "The "+nameData+" must be number", "Error",
                    JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, button, "Ok");
        }
        return numberAux;
    }

    /**
     * Method validates that integer is in range if not throw exception it is
     * requested by nameData parameter to give specific information in the
     * exception message
     *
     * @param min
     * @param max
     * @param num
     * @param nameData
     * @throws exceptions.TheDataEnteredIsNotInTheRangeException
     */
    public void validateThatIntIsInARange(int min, int max, int num, String nameData) throws TheDataEnteredIsNotInTheRangeException {
        if (!(num >= min && num <= max)) {
            throw new TheDataEnteredIsNotInTheRangeException(nameData, min, max);
        }
    }

    /**
     * *
     * an error sound is played and the information that an error appeared is
     * saved
     */
    public void playErrorSound() {
        URL url = getClass().getClassLoader().getResource("resources/Error.wav");
        AudioClip clip = newAudioClip(url);
        clip.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        this.anErrorWasFound = true;
    }

    /**
     * *
     * the information is saved that the play ended correctly, to then know if
     * the player should be changed for the next play because in case the play
     * has not been completed correctly, the player is not changed to continue
     * playing. And also one more play is added to the player for when he
     * validates the game is over
     *
     * @param player
     */
    public void playerMadeAValidMove(Player player) {
        this.anErrorWasFound = false;
        player.setPlayedTurns(player.getPlayedTurns() + 1);
    }

    /**
     * *
     * given a file containing a list of player names a new file with name
     * DIFERENTES.txt is generated with the names that are not found in the
     * system
     *
     * @param file
     */
    public void generateFileDifferentPlayers(File file, Company company) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            FileWriter fileWriter = new FileWriter(file.getParent() + "/DIFERENTES.txt");
            Iterator<String> iterator = input.lines().iterator();
            while (iterator.hasNext()) {
                String line = iterator.next();
                if (!company.playerIsInSystem(line)) {
                    fileWriter.write(line + ";");
                }
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * *
     * given the String of a color is converted to the same color of the Color
     * class so that it can be displayed in the windows
     *
     * @param color
     * @return
     */
    public Color convertColors(String color) {
        Color colorReturn = null;
        switch (color) {
            case "Red":
                colorReturn = Color.red;
                break;
            case "Blue":
                colorReturn = Color.blue;
                break;
            case "Green":
                colorReturn = Color.green;
                break;
            case "Yellow":
                colorReturn = Color.yellow;
                break;
        }
        return colorReturn;
    }

    /**
     * *
     * the path is passed through to know where the image is located and the
     * JLabel to know in what label to put it
     *
     * @param label
     * @param path
     */
    public void putImage(String path, JLabel label) {
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }

    public boolean anErrorWasFound() {
        return anErrorWasFound;
    }

    public void setAnErrorWasFound(boolean anErrorWasFound) {
        this.anErrorWasFound = anErrorWasFound;
    }

}
