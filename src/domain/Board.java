/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
//Cinthya Calbete 229418
import exceptions.*;
import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private String[][] matrix;
    private String red = "Red";
    private String blue = "Blue";
    private String green = "Green";
    private String yellow = "Yellow";
    private String redWithBird = "RX";
    private String blueWithBird = "BX";
    private String greenWithBird = "GX";
    private String yellowWithBird = "YX";
    private ArrayList<String> colors = new ArrayList<>();
    private Helper helper;

    /**
     * *
     * when the board is created, the colors that can be assigned to a player
     * are saved, the matrix of tablets is created and colors are applied to the
     * tablets
     */
    public Board() {
        this.colors.add(red);
        this.colors.add(blue);
        this.colors.add(green);
        this.colors.add(yellow);
        this.matrix = new String[11][11];
        //the tablets are placed with colors ordered at random
        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 1; j < matrix[0].length; j += 2) {
                putTablet(i, j);
            }
        }
        //the special tablets are put
        putTablet(1, 1, red, blue, green, yellow);
        putTablet(1, 3, green, yellow, red, blue);
        helper = new Helper();
    }

    /**
     * *
     * given the coordinates of the first tablet locker the colors are put in
     * random order
     *
     * @param firstRow
     * @param firstColumn
     * @param firstColor
     * @param secondColor
     * @param thirdColor
     * @param quarterColor
     */
    public void putTablet(int firstRow, int firstColumn, String firstColor, String secondColor,
            String thirdColor, String quarterColor) {
        this.matrix[firstRow][firstColumn] = firstColor;
        this.matrix[firstRow][firstColumn + 1] = secondColor;
        this.matrix[firstRow + 1][firstColumn] = thirdColor;
        this.matrix[firstRow + 1][firstColumn + 1] = quarterColor;
    }

    /**
     * *
     * given the coordinates of the tablet's first locker and the order of the
     * colors, the colors are put on the tablet
     *
     * @param firstRow
     * @param firstColumn
     */
    public void putTablet(int firstRow, int firstColumn) {
        Collections.shuffle(colors);
        putTablet(firstRow, firstColumn, colors.get(0), colors.get(1),
                colors.get(2), colors.get(3));
    }

    /**
     * *
     * given the coordinates of a locker, it is asked if it has a bird of any
     * specific color, in case the parameter colorPlayer is "whatever" it will
     * return true in case of finding a bird regardless of the color
     *
     * @param row
     * @param column
     * @param colorPlayer
     * @return if exist bird in this position
     */
    public boolean existBirdInPosition(int row, int column, String colorPlayer) {
        boolean existBird = false;
        if (this.getMatrix()[row][column] != null) {
            switch (colorPlayer) {
                case "Red":
                    if (this.getMatrix()[row][column].equals(redWithBird)) {
                        existBird = true;
                    }
                    break;
                case "Blue":
                    if (this.getMatrix()[row][column].equals(blueWithBird)) {
                        existBird = true;
                    }
                    break;
                case "Yellow":
                    if (this.getMatrix()[row][column].equals(yellowWithBird)) {
                        existBird = true;
                    }
                    break;
                case "Green":
                    if (this.getMatrix()[row][column].equals(greenWithBird)) {
                        existBird = true;
                    }
                    break;
                case "Whatever":
                    existBird = this.getMatrix()[row][column].equals(redWithBird)
                            || this.getMatrix()[row][column].equals(blueWithBird)
                            || this.getMatrix()[row][column].equals(yellowWithBird)
                            || this.getMatrix()[row][column].equals(greenWithBird);
                    break;
            }
        }
        return existBird;
    }

    /**
     * *
     * given the coordinates of a locker, it is asked if there is another
     * player's bird, the current player's color must be passed by parameter
     *
     * @param row
     * @param column
     * @param color
     * @return if exist bird of the other players in this position
     */
    public boolean existBirdsOfTheOthersPlayersInPosition(int row, int column, String color) {
        boolean existBird = false;
        switch (color) {
            case "Red":
                existBird = this.getMatrix()[row][column].equals(blueWithBird)
                        || this.getMatrix()[row][column].equals(yellowWithBird)
                        || this.getMatrix()[row][column].equals(greenWithBird);
                break;
            case "Blue":
                existBird = this.getMatrix()[row][column].equals(redWithBird)
                        || this.getMatrix()[row][column].equals(yellowWithBird)
                        || this.getMatrix()[row][column].equals(greenWithBird);
                break;
            case "Yellow":
                existBird = this.getMatrix()[row][column].equals(redWithBird)
                        || this.getMatrix()[row][column].equals(blueWithBird)
                        || this.getMatrix()[row][column].equals(greenWithBird);
                break;
            case "Green":
                existBird = this.getMatrix()[row][column].equals(redWithBird)
                        || this.getMatrix()[row][column].equals(blueWithBird)
                        || this.getMatrix()[row][column].equals(yellowWithBird);
                break;
        }
        return existBird;
    }

    /**
     * *
     * it is evaluated if it can be connected horizontally, in case it is
     * possible to place birds all the way, if not, an error sound is played and
     * the player is expected to enter again a movement
     *
     * @param player
     * @param rowColumnMatch
     * @throws CouldNotConnectPositionsException
     */
    public void connectPositionsHorizontally(Player player, int[] rowColumnMatch) throws CouldNotConnectPositionsException {
        boolean could = true;
        int since;
        int until;
        if (rowColumnMatch[1] < rowColumnMatch[2]) {
            since = rowColumnMatch[1];
            until = rowColumnMatch[2];
        } else {
            since = rowColumnMatch[2];
            until = rowColumnMatch[1];
        }
        for (int i = since; i <= until; i++) {
            if (existBirdInPosition(rowColumnMatch[0], i, player.getColor())) {
                could = true;
            } else if (existBirdsOfTheOthersPlayersInPosition(rowColumnMatch[0], i, player.getColor())) {
                could = false;
            }
        }
        if (could) {
            for (int column = since; column <= until; column++) {
                putBird(rowColumnMatch[0], column, player);
            }
            helper.playerMadeAValidMove(player);
        } else {
            throw new CouldNotConnectPositionsException();
        }
    }

    /**
     * *
     * it is evaluated if it can be connected vertically, if it is possible to
     * place birds all the way, if not, an error sound is played and the player
     * is expected to enter again a movement
     *
     * @param player
     * @param columnRowMatch
     * @throws CouldNotConnectPositionsException
     */
    public void connectPositionsVertically(Player player, int[] columnRowMatch) throws CouldNotConnectPositionsException {
        boolean could = true;
        int since;
        int until;
        if (columnRowMatch[1] < columnRowMatch[2]) {
            since = columnRowMatch[1];
            until = columnRowMatch[2];
        } else {
            since = columnRowMatch[2];
            until = columnRowMatch[1];
        }
        for (int i = since; i <= until; i++) {
            if (!existBirdInPosition(i, columnRowMatch[0], player.getColor())) {
                could = true;
            } else if (existBirdsOfTheOthersPlayersInPosition(i, columnRowMatch[0], player.getColor())) {
                could = false;
            }
        }
        if (could) {
            for (int row = since; row <= until; row++) {
                putBird(row, columnRowMatch[0], player);
            }
            helper.playerMadeAValidMove(player);
        } else {
            throw new CouldNotConnectPositionsException();
        }
    }

    /**
     * *
     * given the coordinates of a locker, the information is saved that the
     * player * placed another bird and the location so that the window can show
     * it
     *
     * @param row
     * @param column
     * @param player
     */
    public void putBird(int row, int column, Player player) {
        String color = player.getColor();
        switch (color) {
            case "Red":
                this.getMatrix()[row][column] = redWithBird;
                break;
            case "Blue":
                this.getMatrix()[row][column] = blueWithBird;
                break;
            case "Yellow":
                this.getMatrix()[row][column] = yellowWithBird;
                break;
            case "Green":
                this.getMatrix()[row][column] = greenWithBird;
                break;
        }
        player.setQuantityBirdsOnBoard(player.getQuantityBirdsOnBoard() + 1);
    }

    /**
     * *
     * given 2 rows returns true if they are equal, since it means that the
     * positions must be connected horizontally, and otherwise returns false,
     * since the positions do not share the row
     *
     * @param row1
     * @param row2
     * @return if the position share the row
     */
    public boolean positionsAreHorizontal(int row1, int row2) {
        return row1 == row2;
    }

    /**
     * *
     * given 2 columns returns true if they are equal, since it means that the
     * positions must be connected vertically, and otherwise returns false,
     * since the positions do not share the column
     *
     * @param column1
     * @param column2
     * @return if the position share the column
     */
    public boolean positionsAreVertical(int column1, int column2) {
        return column1 == column2;

    }

    /**
     * *
     * given the coordinates of 2 positions it is evaluated if they are
     * connected horizontally or vertically
     *
     * @param row1
     * @param row2
     * @param column1
     * @param column2
     * @throws PositionsAreNeitherHorizontalNorVerticalException
     */
    public void validatePositionsAreHorizontalOrVertical(int row1, int row2, int column1, int column2) throws PositionsAreNeitherHorizontalNorVerticalException {
        if (!positionsAreHorizontal(row1, row2) && !positionsAreVertical(column1, column2)) {
            throw new PositionsAreNeitherHorizontalNorVerticalException();
        }
    }

    /**
     * it is evaluated according to the direction entered by parameter the route
     * where the birds must be placed, in case that it is possible to put all
     * the birds in the route, in case that no, error message is displayed and
     * the player is expected make a movement again
     *
     * @param rowColumnMatch
     * @param player
     * @param direction
     * @throws CouldNotExtendDirectionException
     */
    public void extendInDirection(int[] rowColumnMatch, Player player, String direction) throws CouldNotExtendDirectionException {
        boolean could = true;
        int since = -1;
        int until = -1;
        switch (direction) {
            case "left":
                for (int i = rowColumnMatch[1]; i >= 1; i--) {
                    if (existBirdsOfTheOthersPlayersInPosition(rowColumnMatch[0], i, player.getColor()) && since == -1) {
                        could = false;
                    }
                    if (existBirdInPosition(rowColumnMatch[0], i, player.getColor())) {
                        since = i;
                    }
                }
                until = rowColumnMatch[1];
                if (since == -1) {
                    since = 1;
                }
                break;
            case "right":
                for (int i = rowColumnMatch[1]; i <= 10; i++) {
                    if (existBirdsOfTheOthersPlayersInPosition(rowColumnMatch[0], i, player.getColor()) && until == -1) {
                        could = false;
                    }
                    if (existBirdInPosition(rowColumnMatch[0], i, player.getColor())) {
                        until = i;
                    }
                }
                since = rowColumnMatch[1];
                if (until == -1) {
                    until = 10;
                }
                break;
            case "up":
                for (int i = rowColumnMatch[0]; i >= 1; i--) {
                    if (existBirdsOfTheOthersPlayersInPosition(i, rowColumnMatch[1], player.getColor()) && since == -1) {
                        could = false;
                    }
                    if (existBirdInPosition(i, rowColumnMatch[1], player.getColor())) {
                        since = i;
                    }
                }
                until = rowColumnMatch[0];
                if (since == -1) {
                    since = 1;
                }
                break;
            case "down":
                for (int i = rowColumnMatch[0]; i <= 10; i++) {
                    if (existBirdsOfTheOthersPlayersInPosition(i, rowColumnMatch[1], player.getColor()) && until == -1) {
                        could = false;
                    }
                    if (existBirdInPosition(i, rowColumnMatch[1], player.getColor())) {
                        until = i;
                    }
                }
                since = rowColumnMatch[0];
                if (until == -1) {
                    until = 10;
                }
                break;
        }
        if (could) {
            if (direction.equals("left") || direction.equals("right")) {
                for (int i = since; i <= until; i++) {
                    putBird(rowColumnMatch[0], i, player);
                }
            }
            if (direction.equals("up") || direction.equals("down")) {
                for (int i = since; i <= until; i++) {
                    putBird(i, rowColumnMatch[1], player);
                }
            }
            helper.playerMadeAValidMove(player);
        } else {
            throw new CouldNotExtendDirectionException();
        }
    }

    /**
     * *
     * it is evaluated if all the buttons that the player presses are of their
     * color
     *
     * @param positionButtons
     * @param player
     * @throws PositionsAreNotPlayerColorException
     */
    public void validateColorsMatch(int[] positionButtons, Player player) throws PositionsAreNotPlayerColorException {
        if (!(this.getMatrix()[positionButtons[1]][positionButtons[2]].equals(player.getColor()))) {
            throw new PositionsAreNotPlayerColorException(player.getColor());
        }
        if (positionButtons[0] == 0) {
            if (!(this.getMatrix()[positionButtons[3]][positionButtons[4]].equals(player.getColor()))) {
                throw new PositionsAreNotPlayerColorException(player.getColor());
            }
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
}
