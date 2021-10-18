/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Data {

    static Game game = new Game();
    static char letter = 65;
    static int auxRow = 0;
    static int quantityPutColorsTabletRow1 = 0;
    static int quantityPutColorsTabletRow2 = 0;
    static Player player = new Player();

    public static void main(String[] args) {
        Company company = new Company();

        int option = 0;
        String showSpecialSettings = "";
        int optionSpecialSettings = 0;
        String command = "";
        int finish = 0;

        String menu = "\n\n        MENU\n";
        menu += "1. Define a special settings.\n";
        menu += "2. Create a new player.\n";
        menu += "3. Select a player created.\n";
        menu += "4. Play.\n";
        menu += "5. List by player.\n";
        menu += "6. End.\n";
        do {

            System.out.println(menu);
            option = readInt("Enter an option: ");

            switch (option) {
                case 1:
                    System.out.println("\nDEFINE A SPECIAL SETTINGS: \n");
                    do {
                        showSpecialSettings = "1. Quantity of players: "
                                + game.getQuantityPlayers() + " (Valid values between 2 and 4).\n";
                        showSpecialSettings += "2. Quantity of birds per player: "
                                + game.getQuantityBirdsPlayer() + " (Valid values between 5 and 45).\n";
                        showSpecialSettings += "3. Quantity of rotation per player: "
                                + game.getQuantityRotationPlayer() + " (Valid values between 0 and 5).\n";
                        showSpecialSettings += "4. Quantity of maximum tablets for the board: "
                                + game.getQuantityTablets() + " (Valid values between 5 and 25).\n";
                        showSpecialSettings += "5. Way to finish: "
                                + game.getWayToFinishDescription()[game.getWayToFinish()]
                                + "  (3 valid ways to finish).\n";
                        showSpecialSettings += "6. Return to main menu.";

                        System.out.println(showSpecialSettings);
                        optionSpecialSettings = readInt("\nEnter an option: ");
                        switch (optionSpecialSettings) {
                            case 1:
                                game.setQuantityPlayers(readAndValidateInt(2, 4,
                                        "\nEnter the quantity of players: "));
                                System.out.println("Quantity of players it was correctly modified.");
                                break;
                            case 2:
                                game.setQuantityBirdsPlayer(readAndValidateInt(5, 45,
                                        "\nEnter the quantity of birds per player: "));
                                System.out.println("Quantity of birds per player it was correctly modified.");
                                break;
                            case 3:
                                game.setQuantityRotationPlayer(readAndValidateInt(0, 5,
                                        "\nEnter the quantity of rotation per player: "));
                                System.out.println("Quantity of rotation per player it was correctly modified.");
                                break;
                            case 4:
                                game.setQuantityTablets(readAndValidateInt(5, 25,
                                        "\nEnter the quantity of maximum tablets for the board: "));
                                System.out.println("Quantity of maximum tablets for the board it was correctly modified.");
                                break;
                            case 5:
                                for (int i = 1; i < game.getWayToFinishDescription().length; i++) {
                                    System.out.println(i + ". " + game.getWayToFinishDescription()[i]);
                                }
                                game.setWayToFinish(readAndValidateInt(1, 3,
                                        "\nEnter a number of way to finish: "));
                                if (game.getWayToFinish() == 3) {
                                    game.setQuantityTurnsToFinish(readAndValidateInt(1, 50,
                                            "\nEnter a number of turns to finish: "));
                                }
                                System.out.println("Way to finish it was correctly modified.");
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("\nMust enter an option between 1 and 6: ");
                                break;
                        }
                    } while (optionSpecialSettings != 6);
                    break;
                case 2:
                    System.out.println("\nCREATE A NEW PLAYER\n");
                    String name = readString("Enter a name: ");

                    String alias = readString("Enter an alias: ");
                    while (company.existPlayer(alias)) {
                        System.out.println("This alias has already been "
                                + "registered, please try another.\n");
                        alias = readString("Enter an alias: ");
                    }

                    int age = readAndValidateInt(5, 120, "Enter an age: ");

                    player = company.createPlayer(name, alias, age);
                    System.out.println("\nPlayer " + alias + " it was correctly created.");
                    if (game.getPlayersList().size() <= game.getQuantityPlayers()) {
                        int select = readAndValidateInt(1, 2, "Select this player for"
                                + " this game? \n1. Yes   -   2. No: ");
                        if (select == 1) {
                            game.getPlayersList().add(player);
                        }
                    }
                    break;
                case 3:
                    String aliasForSelect;
                    System.out.println("\nSELECT A PLAYER CREATED\n");
                    if (company.getPlayersList().isEmpty()) {
                        System.out.println("There are no players created\n");
                    } else if (game.getPlayersList().size() < game.getQuantityPlayers()) {
                        ArrayList<String> playersForSelect = new ArrayList<>();
                        for (int i = 0; i < company.getPlayersList().size(); i++) {
                            playersForSelect.add(company.getPlayersList().get(i).getAlias());
                        }

                        Iterator<String> it = playersForSelect.iterator();
                        while (it.hasNext()) {
                            aliasForSelect = it.next();
                            Player aux = new Player();
                            aux.setAlias(aliasForSelect);
                            if (game.getPlayersList().contains(aux)) {
                                it.remove();
                            }
                        }
                        int quantityForSelect = playersForSelect.size();
                        for (int i = 0; i < quantityForSelect; i++) {
                            aliasForSelect = playersForSelect.get(i);
                            System.out.println((i + 1) + "- " + aliasForSelect);
                        }
                        int number = 0;
                        if (quantityForSelect != 0) {
                            number = readAndValidateInt(1, quantityForSelect, "0- Return to main menu\n.Enter a number: ");
                        } else {
                            System.out.println("There are no players created who haven't been selected.");
                        }

                        if (number > 0) {
                            for (int i = 0; i < company.getPlayersList().size(); i++) {
                                String aliasSelected = playersForSelect.get(number - 1);
                                if (company.getPlayersList().get(i).getAlias().equals(aliasSelected)) {
                                    player = company.getPlayersList().get(i);
                                }
                            }
                            game.getPlayersList().add(player);
                        }
                    } else if (game.getPlayersList().size() == game.getQuantityPlayers()) {
                        System.out.println(game.getQuantityPlayers() + " players "
                                + "have already been selected.\nIf you want to select more will must use the settings special");
                    } else {
                        System.out.println("The quantity of players selected(" + game.getPlayersList().size() + ")"
                                + " is more than the quantity players configured(" + game.getQuantityPlayers() + ").");
                    }
                    break;
                case 4:
                    System.out.println("\nPLAY\n");
                    if (game.getPlayersList().size() == game.getQuantityPlayers()) {
                        int opponents = game.getPlayersList().size() - 1;
                        for (int i = 0; i < game.getPlayersList().size(); i++) {
                            player = game.getPlayersList().get(i);
                            player.getQuantityOpponents()[opponents]++;
                            player.setQuantityRotation(game.getQuantityRotationPlayer());
                            player.setQuantityGamesPlayed(player.getQuantityGamesPlayed() + 1);
                        }
                        game.assignColorToPlayers();
                        company.getGamesList().add(game);
                        String[] commandArray;

                        do {
                            String[] rowColumnpos1;
                            String[] rowColumnpos2;
                            String row1;
                            String column1;
                            String row2;
                            String column2;
                            String[] colors;
                            int[] rows1;
                            int[] columns1;
                            int[] rows2;
                            int[] columns2;
                            int[] rowColumnMatch = new int[3];
                            int[] columnRowMatch = new int[3];
                            String sense;
                            String angle;

                            if (game.getBoard().isValidEnteredCommand()) {
                                player = game.nextTurn();
                                showBoard();
                            }
                            command = readString("Enter a command to play: ");
                            commandArray = command.split(" ");

                            switch (commandArray[0].toUpperCase()) {

                                case "R":
                                    if (validateCommand(3, commandArray)) {
                                        rowColumnpos1 = commandArray[1].split("");
                                        angle = commandArray[2];
                                        if (rowColumnpos1.length != 2) {
                                            game.getBoard().invalidCommand();
                                            System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                        } else {
                                            row1 = rowColumnpos1[0];
                                            column1 = rowColumnpos1[1];
                                            if ((row1.equals("E") && column1.equals("5")) || (row1.equals("E") && column1.equals("6"))) {
                                                game.getBoard().invalidCommand();
                                                System.out.println("Can not rotate the tablets E5 and E6.\n");
                                            } else {
                                                rows1 = game.getBoard().convertRow(row1);
                                                columns1 = game.getBoard().convertColumn(column1);
                                                if (game.getBoard().validateAngle(angle)) {
                                                    if (game.getBoard().existTabletPositionWithoutBird(rows1[0], columns1[0], "Whatever")) {
                                                        if (player.getQuantityRotation() > 0) {
                                                            game.getBoard().rotateTablet(rows1, columns1, angle, player);
                                                        } else {
                                                            game.getBoard().invalidCommand();
                                                            System.out.println("The player does not have rotation tokens available.\n");
                                                        }
                                                    } else {
                                                        game.getBoard().invalidCommand();
                                                        System.out.println("Must indicate a position where there is a tablet without birds.\n");
                                                    }
                                                } else {
                                                    game.getBoard().invalidCommand();
                                                    System.out.println("The angle must be 90, 180 o 270.\n");
                                                }
                                            }
                                        }
                                    } else {
                                        game.getBoard().invalidCommand();
                                        System.out.println("Must enter a valid format of commands.\n");
                                    }
                                    break;
                                case "C":
                                    if (validateCommand(3, commandArray)) {
                                        rowColumnpos1 = commandArray[1].split("");
                                        rowColumnpos2 = commandArray[2].split("");
                                        if (rowColumnpos1.equals(rowColumnpos2)) {
                                            game.getBoard().invalidCommand();
                                            System.out.println("For the command C must enter differents positions.\n");
                                        } else if (rowColumnpos1.length != 2 || rowColumnpos2.length != 2) {
                                            game.getBoard().invalidCommand();
                                            System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                        } else {
                                            row1 = rowColumnpos1[0];
                                            column1 = rowColumnpos1[1];
                                            row2 = rowColumnpos2[0];
                                            column2 = rowColumnpos2[1];
                                            rows1 = game.getBoard().convertRow(row1);
                                            columns1 = game.getBoard().convertColumn(column1);
                                            rows2 = game.getBoard().convertRow(row2);
                                            columns2 = game.getBoard().convertColumn(column2);
                                            rowColumnMatch[0] = -1;
                                            columnRowMatch[0] = -1;
                                            if (rows1.length == 0 || columns1.length == 0 || rows2.length == 0 || columns2.length == 0) {
                                                game.getBoard().invalidCommand();
                                                System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                            } else if (game.getBoard().existTablet(rows1[0], columns1[0])
                                                    && game.getBoard().existTablet(rows2[0], columns2[0])) {
                                                columnRowMatch = game.getBoard().columnWhereTheColorsMatchOf2Positions(rows1, columns1, rows2, columns2, player.getColor());
                                                rowColumnMatch = game.getBoard().rowWhereTheColorsMatchOf2Positions(rows1, columns1, rows2, columns2, player.getColor());

                                                if (rowColumnMatch[0] != -2 || columnRowMatch[0] != -2) {
                                                    if (rowColumnMatch[0] != -1 && rowColumnMatch[0] != -2) {
                                                        if (!(game.getBoard().connectPositionsHorizontally(
                                                                player, rowColumnMatch))) {
                                                            game.getBoard().invalidCommand();
                                                            System.out.println("Could not connect the positions, there are no tablets on the road or there are birds on the road.\n");
                                                        } else {
                                                            game.getBoard().validCommand(player);
                                                        }
                                                    }
                                                    if (columnRowMatch[0] != -1 && columnRowMatch[0] != -2) {
                                                        if (!(game.getBoard().connectPositionsVertically(player, columnRowMatch))) {
                                                            game.getBoard().invalidCommand();
                                                            System.out.println("Could not connect the positions, there are no tablets on the road or there are birds on the road.\n");
                                                        } else {
                                                            game.getBoard().validCommand(player);
                                                        }
                                                    }
                                                } else {
                                                    game.getBoard().invalidCommand();
                                                    System.out.println("Must enter 2 positions with player color are aligned..\n");
                                                }
                                            } else {
                                                game.getBoard().invalidCommand();
                                                System.out.println("Must enter 2 positions with tablets.\n");
                                            }
                                        }
                                    } else {
                                        game.getBoard().invalidCommand();
                                        System.out.println("Must enter a valid format of commands.\n");
                                    }
                                    break;

                                case "P":
                                    if (validateCommand(2, commandArray)) {
                                        rowColumnpos1 = commandArray[1].split("");
                                        if (rowColumnpos1.length == 2) {
                                            rows1 = game.getBoard().convertRow(rowColumnpos1[0]);
                                            columns1 = game.getBoard().convertColumn(rowColumnpos1[1]);
                                            if (rows1[0] != -1 && columns1[0] != -1) {
                                                if (game.getBoard().validatePutTablet(rows1[0], columns1[0], game.getQuantityTablets())) {
                                                    game.getBoard().putTablet(rows1[0], columns1[0]);
                                                    game.getBoard().validCommand(player);
                                                } else {
                                                    game.getBoard().invalidCommand();
                                                    System.out.println("Could not put the tablet.\n");
                                                }
                                            } else {
                                                game.getBoard().invalidCommand();
                                                System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                            }
                                        } else {
                                            game.getBoard().invalidCommand();
                                            System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                        }
                                    } else {
                                        game.getBoard().invalidCommand();
                                        System.out.println("Must enter a valid format of commands.\n");
                                    }
                                    break;
                                case "E":
                                    if (validateCommand(3, commandArray)) {
                                        sense = commandArray[1].toUpperCase();
                                        rowColumnpos1 = commandArray[2].split("");
                                        if (rowColumnpos1.length != 2) {
                                            game.getBoard().invalidCommand();
                                            System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                        } else {
                                            rows1 = game.getBoard().convertRow(rowColumnpos1[0]);
                                            columns1 = game.getBoard().convertColumn(rowColumnpos1[1]);
                                            if (game.getBoard().validateSense(sense)) {
                                                if (rows1[0] != -1 && columns1[0] != -1) {
                                                    rowColumnMatch = game.getBoard().rowColumnWhereTheColorsMatchOf1Position(rows1, columns1, player.getColor());
                                                    if (rowColumnMatch[0] != -1) {
                                                        if (game.getBoard().extendSense(sense, rowColumnMatch, player)) {
                                                            game.getBoard().validCommand(player);
                                                        } else {
                                                            game.getBoard().invalidCommand();
                                                            System.out.println("Could not extend, there are no tablets on the road or there are birds on the road.\n");
                                                        }
                                                    } else {
                                                        game.getBoard().invalidCommand();
                                                        System.out.println("Must enter a position where the player's color is\n");
                                                    }

                                                } else {
                                                    game.getBoard().invalidCommand();
                                                    System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                                }
                                            } else {
                                                game.getBoard().invalidCommand();
                                                System.out.println("Must enter a valid format of sense.\n");
                                            }
                                        }
                                    } else {
                                        game.getBoard().invalidCommand();
                                        System.out.println("Must enter a valid format of commands.\n");
                                    }

                                    break;
                                case "PM":
                                    if (validateCommand(3, commandArray)) {
                                        rowColumnpos1 = commandArray[1].split("");
                                        if (rowColumnpos1.length != 2) {
                                            game.getBoard().invalidCommand();
                                            System.out.println("Column or row not valid. Must enter a row between A-J and column between 1-10.\n");
                                        } else {
                                            rows1 = game.getBoard().convertRow(rowColumnpos1[0]);
                                            columns1 = game.getBoard().convertColumn(rowColumnpos1[1]);
                                            if (game.getBoard().existTablet(rows1[0], columns1[0])) {
                                                game.getBoard().invalidCommand();
                                                System.out.println("You must enter a position where there are no tablets.\n");
                                            } else {
                                                colors = commandArray[2].split("");
                                                colors = game.getBoard().convertColors(colors);
                                                if (!game.getBoard().validateListColors(colors)) {
                                                    game.getBoard().invalidCommand();
                                                    System.out.println("Must enter a valid colors.\n");
                                                } else {
                                                    game.getBoard().putTablet(rows1[0], columns1[0],
                                                            colors[0], colors[1], colors[2], colors[3]);
                                                    game.getBoard().validCommand(player);

                                                }
                                            }
                                        }
                                    } else {
                                        game.getBoard().invalidCommand();
                                        System.out.println("Must enter a valid format of commands.\n");
                                    }

                                    break;
                                case "X":
                                    finish = readAndValidateInt(1, 2, "Do you want to finish?\n1- Yes - 2-No. ");
                                    break;
                                default:
                                    game.getBoard().invalidCommand();
                                    System.out.println("Must enter a valid command.\n");
                                    break;
                            }

                        } while (!game.gameOver() && finish == 0);
                        for (int i = 0; i < game.getPlayersList().size(); i++) {
                            Player auxPlayer = game.getPlayersList().get(i);
                            auxPlayer.setQuantityGamesPlayed(auxPlayer.getQuantityGamesPlayed() + 1);
                        }
                        System.out.println("\nGame over.\n\nThe winner(s) are:\n");
                        if (commandArray[0].toUpperCase().equals("X")) {
                            ArrayList<Player> winners;
                            winners = game.showWinnerX(player);
                            for (int i = 0; i < winners.size(); i++) {
                                System.out.println(" - " + winners.get(i));
                            }
                        } else {
                            ArrayList<Player> listWinners = game.showWinner();
                            for (int i = 0; i < listWinners.size(); i++) {
                                System.out.println("- " + listWinners.get(i));
                            }
                        }

                    } else {
                        System.out.println("The quantity players configured("
                                + game.getQuantityPlayers()
                                + ") isn't the same than the quantity players "
                                + "selected.(" + game.getPlayersList().size()
                                + ")\nSelect all the players again.");
                    }
                    Iterator<Player> it = game.getPlayersList().iterator();
                    while (it.hasNext()) {
                        player = it.next();
                        it.remove();
                    }
                    break;

                case 5:
                    System.out.println("\nLIST BY PLAYER\n");
                    Collections.sort(company.getPlayersList(), new OrderGamesPlayed());
                    if (company.getPlayersList().isEmpty()) {
                        System.out.println("There are no players created\n");
                    } else {
                        for (int i = 0; i < company.getPlayersList().size(); i++) {
                            player = company.getPlayersList().get(i);
                            System.out.println("\n\n- " + player + ": ");
                            for (int j = 1; j < player.getQuantityOpponents().length; j++) {
                                int auxOpponents = player.getQuantityOpponents()[i];
                                System.out.print("\n  " + j + " opponents: " + auxOpponents);
                            }
                        }
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Must enter an option between 1 and 6: ");
                    break;
            }

        } while (option
                != 6);
    }

    public static void showBoard() {
        letter = 65;
        auxRow = 0;

        System.out.print("\n  1  2  3  4  5  6  7  8  9  10\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("\u001B[0m");
            drawRow();
            drawColumns();
            quantityPutColorsTabletRow1 = 0;
            quantityPutColorsTabletRow2 = 0;
            auxRow++;
        }
        drawRow();

        System.out.println("\n Player turn: " + player + " - color: " + player.getColor());
        System.out.println(" Quantity birds on board: " + player.getQuantityBirdsOnBoard());
        String formatCommands = "\n Format valid of commands:\n";
        formatCommands += " R RowColumn Angle (angle is 90, 180 or 270) (to rotate empty tablet) \n";
        formatCommands += " C RowColumn RowColumn (to connect 2 positions) \n";
        formatCommands += " P RowColumn (to put tablet) \n";
        formatCommands += " E Sense RowColumn (to extend, sense is I, D, A, B) \n";
        formatCommands += " PM (To put manually a tablet)\n";
        formatCommands += " X (to finish)\n";
        System.out.println(formatCommands);

    }

    public static boolean validateCommand(int quantityData, String[] command) {
        boolean valid = true;
        if (quantityData != command.length) {
            valid = false;
        }
        return valid;
    }

    public static void drawRow() {
        for (int i = 0; i < game.getBoard().getMatrix().length; i = i + 2) {
            if (i == 0) {
                System.out.print(" +");
            }
            System.out.print("--+");
        }
        System.out.print("\n");

    }

    public static void drawColumns() {
        quantityPutColorsTabletRow1 = 0;
        for (int j = 0; j < 20; j++) {

            if (j == 0) {
                System.out.print(letter + "|");
                letter++;
            }

            if (game.getBoard().getMatrix()[auxRow][j] != null) {
                System.out.print(game.getBoard().getMatrix()[auxRow][j]);
                quantityPutColorsTabletRow1++;
                if (quantityPutColorsTabletRow1 == 2) {
                    System.out.print("|");
                    quantityPutColorsTabletRow1 = 0;
                }
            } else if (j % 2 == 0) {
                System.out.print("  |");
            }

        }
        auxRow++;
        quantityPutColorsTabletRow2 = 0;
        System.out.print("\n");
        for (int j = 0; j < 20; j++) {

            if (j == 0) {
                System.out.print(" |");
            }

            if (game.getBoard().getMatrix()[auxRow][j] != null) {
                System.out.print(game.getBoard().getMatrix()[auxRow][j]);
                quantityPutColorsTabletRow2++;
                if (quantityPutColorsTabletRow2 == 2) {
                    System.out.print("|");
                    quantityPutColorsTabletRow2 = 0;
                }
            } else if (j % 2 == 0) {
                System.out.print("  |");
            }
        }
        System.out.print("\n");

    }

    /**
     * Method that reads a value and validates that it is integer
     *
     * @param message
     * @return value valid
     */
    public static int readInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int value = -1;
        while (value == -1) {
            try {
                value = in.nextInt();

            } catch (InputMismatchException e) {
                System.out.print("Value not valid.\n" + message);
                in.nextLine();
            }
        }
        return value;
    }

    /**
     * Method that reads a value, validates that it is integer and that it is in
     * range
     *
     * @param min
     * @param max
     * @param message
     * @return value valid
     */
    public static int readAndValidateInt(int min, int max, String message) {
        int value = readInt(message);
        while (!intIsValid(min, max, value)) {
            System.out.println("The value must be between " + min + " and " + max);
            value = readInt(message);
        }
        return value;
    }

    /**
     * Method validates that integer is in range
     *
     * @param min
     * @param max
     * @param num
     * @return value valid
     */
    public static boolean intIsValid(int min, int max, int num) {
        return num >= min && num <= max;
    }

    public static String readString(String message) {
        Scanner in = new Scanner(System.in);
        String value = "";
        System.out.print(message);
        do {
            value = in.nextLine();
        } while (value.isEmpty());

        return value;
    }
}
