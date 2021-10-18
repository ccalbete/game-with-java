/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.util.ArrayList;
import java.util.Collections;
import java.net.URL;

public class Board {

    private String matrix[][];
    private String red = (char) 27 + "[" + String.valueOf(41) + "m" + " " + "\u001B[0m";
    private String blue = (char) 27 + "[" + String.valueOf(44) + "m" + " " + "\u001B[0m";
    private String green = (char) 27 + "[" + String.valueOf(42) + "m" + " " + "\u001B[0m";
    private String yellow = (char) 27 + "[" + String.valueOf(43) + "m" + " " + "\u001B[0m";
    private String redWithBird = (char) 27 + "[" + String.valueOf(41) + "m" + "X" + "\u001B[0m";
    private String greenWithBird = (char) 27 + "[" + String.valueOf(42) + "m" + "X" + "\u001B[0m";
    private String yellowWithBird = (char) 27 + "[" + String.valueOf(43) + "m" + "X" + "\u001B[0m";
    private String blueWithBird = (char) 27 + "[" + String.valueOf(44) + "m" + "X" + "\u001B[0m";
    private int quantityPlacedTablets = 0;
    private ArrayList<String> colors = new ArrayList<>();
    private String[] lettersRow = new String[19];
    private int[] numbersColumns = new int[11];
    private boolean validEnteredCommand;

    public Board() {
        this.matrix = new String[20][20];
        putTablet(8, 8, red, blue, green, yellow);
        putTablet(8, 10, green, yellow, red, blue);
        this.colors.add((char) 27 + "[" + String.valueOf(41) + "m" + " " + "\u001B[0m");
        this.colors.add((char) 27 + "[" + String.valueOf(44) + "m" + " " + "\u001B[0m");
        this.colors.add((char) 27 + "[" + String.valueOf(42) + "m" + " " + "\u001B[0m");
        this.colors.add((char) 27 + "[" + String.valueOf(43) + "m" + " " + "\u001B[0m");
        this.lettersRow[0] = "A";
        this.lettersRow[2] = "B";
        this.lettersRow[4] = "C";
        this.lettersRow[6] = "D";
        this.lettersRow[8] = "E";
        this.lettersRow[10] = "F";
        this.lettersRow[12] = "G";
        this.lettersRow[14] = "H";
        this.lettersRow[16] = "I";
        this.lettersRow[18] = "J";
        this.numbersColumns[1] = 0;
        this.numbersColumns[2] = 2;
        this.numbersColumns[3] = 4;
        this.numbersColumns[4] = 6;
        this.numbersColumns[5] = 8;
        this.numbersColumns[6] = 10;
        this.numbersColumns[7] = 12;
        this.numbersColumns[8] = 14;
        this.numbersColumns[9] = 16;
        this.numbersColumns[10] = 18;
        this.validEnteredCommand = true;
    }

    public boolean existTablet(int row, int column) {
        return existColorInPosition(row, column, "Whatever");
    }

    public boolean existColorInPosition(int row, int column, String color) {
        return existTabletPositionWithoutBird(row, column, color)
                || existTabletPositionWithBird(row, column, color);
    }

    public boolean noExistColorInPositionOrExistBirdsOfTheOtherPlayers(int row, int column, String color) {
        return !existTabletPositionWithoutBird(row, column, "Whatever")
                || existTabletPositionWithBirdOfTheOthersPlayers(row, column, color);
    }

    public boolean existTabletPositionWithBird(int row, int column, String colorPlayer) {
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

    public boolean existTabletPositionWithBirdOfTheOthersPlayers(int row, int column, String color) {
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

    public int[] convertRow(String letterRow) {
        int[] rows = new int[2];
        rows[0] = -1;
        rows[1] = -1;
        letterRow = letterRow.toUpperCase();
        for (int i = 0; i <= 18; i = i + 2) {
            if (lettersRow[i].equals(letterRow)) {
                rows[0] = i;
                rows[1] = i + 1;
            }
        }
        return rows;
    }

    public int[] convertColumn(String column) {
        int[] columns = new int[2];
        columns[0] = -1;
        columns[1] = -1;
        int columnAux = Integer.parseInt(column);
        if (columnAux >= 1 && columnAux <= 10) {
            columns[0] = this.numbersColumns[columnAux];
            columns[1] = this.numbersColumns[columnAux] + 1;
        }
        return columns;
    }

    public String[] convertColors(String[] colors) {
        String[] colorsReturn = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {
            switch (colors[i].toUpperCase()) {
                case "R":
                    colorsReturn[i] = red;
                    break;
                case "A":
                    colorsReturn[i] = blue;
                    break;
                case "V":
                    colorsReturn[i] = green;
                    break;
                case "M":
                    colorsReturn[i] = yellow;
                    break;
                default:
                    colorsReturn[i] = "invalid";
                    break;
            }

        }
        return colorsReturn;
    }

    public boolean validateAngle(String angle) {
        boolean valid = false;
        if (angle.equals("90") || angle.equals("180") || angle.equals("270")) {
            valid = true;
        }
        return valid;
    }

    public boolean validatePutTablet(int row, int column, int quantityTabletsConfigured) {
        boolean valid = true;
        if (quantityTabletsConfigured == this.quantityPlacedTablets || existTablet(row, column)) {
            valid = false;
        } else {
            for (int i = 0; i < this.getMatrix().length; i += 2) {
                for (int j = 0; j < this.getMatrix()[0].length; j += 2) {
                    if (existTablet(i, j)) {
                        int diffRow = i - row;
                        int diffColumn = j - column;
                        if (diffRow >= 10 || diffRow <= -10 || diffColumn >= 10 || diffColumn <= -10) {
                            valid = false;
                        }
                    }
                }
            }
        }
        return valid;
    }

    public boolean validateSense(String sense) {
        boolean valid = true;
        if (sense.equals("I") || sense.equals("D") || sense.equals("A") || sense.equals("B")) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    public Boolean validateListColors(String[] colors) {
        boolean valid = true;
        int quantityRed = 0;
        int quantityBlue = 0;
        int quantityGreen = 0;
        int quantityYellow = 0;
        if (colors.length == 4) {
            for (int i = 0; i < colors.length; i++) {

                if (colors[i].equals(red)) {
                    quantityRed++;
                }
                if (colors[i].equals(blue)) {
                    quantityBlue++;
                }
                if (colors[i].equals(green)) {
                    quantityGreen++;
                }
                if (colors[i].equals(yellow)) {
                    quantityYellow++;
                }
            }
        } else {
            valid = false;
        }

        if (quantityRed != 1 || quantityBlue != 1 || quantityGreen != 1 || quantityYellow != 1) {
            valid = false;
        }

        return valid;
    }

    public void putTablet(int firstRow, int firstColumn, String firstColor, String secondColor,
            String thirdColor, String quarterColor) {
        this.matrix[firstRow][firstColumn] = firstColor;
        this.matrix[firstRow][firstColumn + 1] = secondColor;
        this.matrix[firstRow + 1][firstColumn] = thirdColor;
        this.matrix[firstRow + 1][firstColumn + 1] = quarterColor;
        this.quantityPlacedTablets++;
    }

    public void putLocker(String row, String column, String color) {
        int rowAux = Integer.parseInt(row);
        int columnAux = Integer.parseInt(column);
        this.matrix[rowAux][columnAux] = color;
    }

    public void putTablet(int firstRow, int firstColumn) {
        Collections.shuffle(colors);
        putTablet(firstRow, firstColumn, colors.get(0), colors.get(1),
                colors.get(2), colors.get(3));
    }

    public void rotateTablet(int[] rows, int[] columns, String angle, Player player) {
        String[] locker1Aux = new String[3];
        String[] locker2Aux = new String[3];
        String[] locker3Aux = new String[3];
        String[] locker4Aux = new String[3];

        locker1Aux[0] = this.getMatrix()[rows[0]][columns[0]];
        locker1Aux[1] = Integer.toString(rows[0]);
        locker1Aux[2] = Integer.toString(columns[0]);
        locker2Aux[0] = this.getMatrix()[rows[0]][columns[1]];
        locker2Aux[1] = Integer.toString(rows[0]);
        locker2Aux[2] = Integer.toString(columns[1]);
        locker3Aux[0] = this.getMatrix()[rows[1]][columns[0]];
        locker3Aux[1] = Integer.toString(rows[1]);
        locker3Aux[2] = Integer.toString(columns[0]);
        locker4Aux[0] = this.getMatrix()[rows[1]][columns[1]];
        locker4Aux[1] = Integer.toString(rows[1]);
        locker4Aux[2] = Integer.toString(columns[1]);

        switch (angle) {
            case "90":
                putLocker(locker1Aux[1], locker1Aux[2], locker3Aux[0]);
                putLocker(locker2Aux[1], locker2Aux[2], locker1Aux[0]);
                putLocker(locker3Aux[1], locker3Aux[2], locker4Aux[0]);
                putLocker(locker4Aux[1], locker4Aux[2], locker2Aux[0]);
                break;
            case "180":
                putLocker(locker1Aux[1], locker1Aux[2], locker4Aux[0]);
                putLocker(locker2Aux[1], locker2Aux[2], locker3Aux[0]);
                putLocker(locker3Aux[1], locker3Aux[2], locker2Aux[0]);
                putLocker(locker4Aux[1], locker4Aux[2], locker1Aux[0]);
                break;
            case "270":
                putLocker(locker1Aux[1], locker1Aux[2], locker2Aux[0]);
                putLocker(locker2Aux[1], locker2Aux[2], locker4Aux[0]);
                putLocker(locker3Aux[1], locker3Aux[2], locker1Aux[0]);
                putLocker(locker4Aux[1], locker4Aux[2], locker3Aux[0]);
                break;
        }

        player.setQuantityRotation(player.getQuantityRotation() - 1);

    }

    public boolean existTabletPositionWithoutBird(int row, int column, String color) {
        boolean exist = false;
        if (this.getMatrix()[row][column] != null) {
            switch (color) {
                case "Red":
                    exist = this.getMatrix()[row][column].equals(red);
                    break;
                case "Blue":
                    exist = this.getMatrix()[row][column].equals(blue);
                    break;
                case "Yellow":
                    exist = this.getMatrix()[row][column].equals(yellow);
                    break;
                case "Green":
                    exist = this.getMatrix()[row][column].equals(green);
                    break;
                case "Whatever":
                    exist = this.getMatrix()[row][column].equals(red)
                            || this.getMatrix()[row][column].equals(blue)
                            || this.getMatrix()[row][column].equals(yellow)
                            || this.getMatrix()[row][column].equals(green);
                    break;
            }
        }
        return exist;
    }

    public boolean connectPositionsHorizontally(Player player, int[] rowColumnMatch) {
        boolean result = true;
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
            if (existTabletPositionWithBird(rowColumnMatch[0], i, player.getColor())) {
                result = true;
            } else if (noExistColorInPositionOrExistBirdsOfTheOtherPlayers(rowColumnMatch[0], i, player.getColor())) {
                result = false;
            }
        }

        if (result) {
            for (int column = since; column <= until; column++) {
                putBird(rowColumnMatch[0], column, player);
            }
        }
        return result;
    }

    public boolean connectPositionsVertically(Player player, int[] columnRowMatch) {
        boolean result = true;
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
            if (existTabletPositionWithBird(i, columnRowMatch[0], player.getColor())) {
                result = true;
            } else if (noExistColorInPositionOrExistBirdsOfTheOtherPlayers(i, columnRowMatch[0], player.getColor())) {
                result = false;
            }
        }
        if (result) {
            for (int row = since; row <= until; row++) {
                putBird(row, columnRowMatch[0], player);
            }
        }
        return result;
    }

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

    public int[] rowWhereTheColorsMatchOf2Positions(int[] rows1, int[] columns1, int[] rows2,
            int[] columns2, String colorPlayer) {
        int[] rowColumn1 = new int[2];
        int[] rowColumn2 = new int[2];
        rowColumn1[0] = -1;
        rowColumn1[1] = -1;
        rowColumn2[0] = -1;
        rowColumn2[1] = -1;
        int[] rowColumnsMatch = new int[3];
        rowColumnsMatch[0] = -2;
        int[] sinceUntil = new int[2];

        if (rows1[0] < rows2[1]) {
            sinceUntil[0] = rows1[0];
            sinceUntil[1] = rows2[1];
        } else {
            sinceUntil[0] = rows2[1];
            sinceUntil[1] = rows1[0];
        }

        rowColumn1 = rowColumnWhereTheColorsMatchOf1Position(sinceUntil, columns1, colorPlayer);
        rowColumn2 = rowColumnWhereTheColorsMatchOf1Position(sinceUntil, columns2, colorPlayer,
                columns2[0] != columns1[0], columns2[1] != columns1[1]);

        if (positionsAreHorizontal(rowColumn1[0], rowColumn2[0]) && rowColumn1[0] != -1 && rowColumn2[0] != -1) {
            rowColumnsMatch[0] = rowColumn1[0];
        }
        rowColumnsMatch[1] = rowColumn1[1];
        rowColumnsMatch[2] = rowColumn2[1];
        return rowColumnsMatch;
    }

    public int[] columnWhereTheColorsMatchOf2Positions(int[] rows1, int[] columns1, int[] rows2,
            int[] columns2, String colorPlayer) {
        int[] rowColumn1 = new int[2];
        int[] rowColumn2 = new int[2];
        rowColumn1[0] = -1;
        rowColumn1[1] = -1;
        rowColumn2[0] = -1;
        rowColumn2[1] = -1;
        int[] columnRowMatch = new int[3];
        columnRowMatch[0] = -2;
        int[] sinceUntil = new int[2];

        if (columns1[0] < columns2[1]) {
            sinceUntil[0] = columns1[0];
            sinceUntil[1] = columns2[1];
        } else {
            sinceUntil[0] = columns2[0];
            sinceUntil[1] = columns1[1];
        }

        rowColumn1 = rowColumnWhereTheColorsMatchOf1Position(rows1, sinceUntil, colorPlayer);
        rowColumn2 = rowColumnWhereTheColorsMatchOf1Position(rows2, sinceUntil, colorPlayer,
                rows2[0] != rows1[0], rows2[1] != rows1[1]);

        if (positionsAreVertical(rowColumn1[1], rowColumn2[1]) && rowColumn1[1] != -1 && rowColumn2[1] != -1) {
            columnRowMatch[0] = rowColumn2[1];
        }
        columnRowMatch[1] = rowColumn1[0];
        columnRowMatch[2] = rowColumn1[1];
        return columnRowMatch;
    }

    public int[] rowColumnWhereTheColorsMatchOf1Position(int[] rows1, int[] columns1,
            String colorPlayer, boolean condition1, boolean condition2) {
        int[] rowColumnMatch = new int[2];
        rowColumnMatch[0] = -1;
        rowColumnMatch[1] = -1;
        for (int i = columns1[0]; i <= columns1[1]; i++) {
            if (existColorInPosition(rows1[0], i, colorPlayer) && condition1) {
                rowColumnMatch[0] = rows1[0];
                rowColumnMatch[1] = i;
            } else if (existColorInPosition(rows1[1], i, colorPlayer) && condition2) {
                rowColumnMatch[0] = rows1[1];
                rowColumnMatch[1] = i;
            }
        }
        return rowColumnMatch;

    }

    public int[] rowColumnWhereTheColorsMatchOf1Position(int[] rows1, int[] columns1, String colorPlayer) {
        int[] rowColumnMatch = new int[2];
        rowColumnMatch[0] = -1;
        rowColumnMatch[1] = -1;
        for (int i = columns1[0]; i <= columns1[1]; i++) {
            if (existColorInPosition(rows1[0], i, colorPlayer)) {
                rowColumnMatch[0] = rows1[0];
                rowColumnMatch[1] = i;
            } else if (existColorInPosition(rows1[1], i, colorPlayer)) {
                rowColumnMatch[0] = rows1[1];
                rowColumnMatch[1] = i;
            }
        }
        return rowColumnMatch;

    }

    public boolean positionsAreHorizontal(int row1, int row2) {
        return row1 == row2;
    }

    public boolean positionsAreVertical(int column1, int column2) {
        return column1 == column2;

    }

    public boolean extendSense(String sense, int[] rowColumnMatch, Player player) {
        boolean result = true;
        int since = -1;
        boolean found = false;
        int until = -1;

        switch (sense) {
            case "I":
                for (int i = 0; i < 20; i += 2) {
                    if (existTablet(rowColumnMatch[0], i) && !found) {
                        since = i;
                        found = true;
                    }
                }
                until = rowColumnMatch[1];
                break;
            case "D":
                for (int i = 18; i >= 0; i--) {
                    if (existTablet(rowColumnMatch[0], i) && !found) {
                        until = i;
                        found = true;
                    }
                }
                since = rowColumnMatch[1];
                break;
            case "A":
                for (int i = 0; i < 20; i += 2) {
                    if (existTablet(i, rowColumnMatch[1])
                            && !found) {
                        since = i;
                        found = true;
                    }
                }
                until = rowColumnMatch[0];
                break;
            case "B":
                for (int i = 18; i >= 0; i--) {
                    if (existTablet(i, rowColumnMatch[1]) && !found) {
                        until = i;
                        found = true;
                    }
                }
                since = rowColumnMatch[0];
                break;
        }
        if (since != -1 && until != -1) {

            if (sense.equals("I") || sense.equals("D")) {
                for (int i = since; i <= until; i++) {
                    if (existTabletPositionWithBird(rowColumnMatch[0], i, player.getColor())) {
                        result = true;
                    } else if (noExistColorInPositionOrExistBirdsOfTheOtherPlayers(rowColumnMatch[0], i, player.getColor())) {
                        result = false;
                    }
                }

                if (result) {
                    for (int i = since; i <= until; i++) {
                        putBird(rowColumnMatch[0], i, player);
                    }
                }
            }

        }

        if (sense.equals("A") || sense.equals("B")) {
            for (int i = since; i <= until; i++) {
                if (existTabletPositionWithBird(i, rowColumnMatch[1], player.getColor())) {
                    result = true;
                } else if (noExistColorInPositionOrExistBirdsOfTheOtherPlayers(i, rowColumnMatch[1], player.getColor())) {
                    result = false;
                }
            }
            if (result) {
                for (int i = since; i <= until; i++) {
                    putBird(i, rowColumnMatch[1], player);
                }
            }

        }

        return result;
    }

    public void validCommand(Player player) {
        this.setValidEnteredCommand(true);
        player.setPlayedTurns(player.getPlayedTurns() + 1);
    }

    public void invalidCommand() {
        this.setValidEnteredCommand(false);
        URL url = getClass().getClassLoader().getResource("resources/Error.wav");

        AudioClip clip = newAudioClip(url);
        clip.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public int getQuantityPlacedTablets() {
        return quantityPlacedTablets;
    }

    public void setQuantityPlacedTablets(int quantityPlacedTablets) {
        this.quantityPlacedTablets = quantityPlacedTablets;
    }

    public boolean isValidEnteredCommand() {
        return validEnteredCommand;
    }

    public void setValidEnteredCommand(boolean validEnteredCommand) {
        this.validEnteredCommand = validEnteredCommand;
    }

}
