/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
//Cinthya Calbete 229418
import exceptions.AllConfiguredPlayersAreNotSelectedException;
import exceptions.TheDataEnteredIsNotInTheRangeException;
import exceptions.ThereAreNotPlayersLeftToSelectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Game {

    private int quantityPlayersConfigured;
    private int quantityBirdsPlayerConfigured;
    private Board board;
    private ArrayList<Player> listSelectedPlayers;
    private int wayToFinishConfigured;
    private int quantityTurnsToFinishConfigured;
    private ArrayList<String> colors = new ArrayList<>();
    private int currentTurn;
    private Helper helper;

    /**
     * *
     * when a game is created, the default configuration is entered
     */
    public Game() {
        this.quantityPlayersConfigured = 2;
        this.quantityBirdsPlayerConfigured = 20;
        this.listSelectedPlayers = new ArrayList<>();
        this.wayToFinishConfigured = 1;
        this.quantityTurnsToFinishConfigured = 5;
        this.board = new Board();
        this.colors.add("Red");
        this.colors.add("Blue");
        this.colors.add("Yellow");
        this.colors.add("Green");
        //the variable currentTurn starts at -1 so that the first time 
        //the getThePlayerNextTurn method is called, return 1
        this.currentTurn = -1;
        this.helper = helper;
    }

    /**
     * *
     * it is evaluated if the game is over according to the form that has been
     * configured
     *
     * @return
     */
    public boolean gameOver() {
        boolean over = false;

        if (this.getWayToFinishConfigured() == 1) {
            for (int i = 0; i < getListSelectedPlayers().size(); i++) {
                if (getListSelectedPlayers().get(i).getQuantityBirdsOnBoard() == getQuantityBirdsPlayerConfigured()) {
                    over = true;
                }
            }
        }
        if (this.getWayToFinishConfigured() == 2) {
            if (getListSelectedPlayers().get(getListSelectedPlayers().size() - 1).getPlayedTurns() == getQuantityTurnsToFinishConfigured()) {
                over = true;
            }
        }
        return over;
    }

    /**
     * the player who pressed the give up button during the game is received by
     * parameter and a list is returned with the rest of the players of the game
     * as winners
     *
     * @param player: Player that select give up for to way finish
     * @return
     */
    public ArrayList<Player> getPlayersWhoDidNotSurrender(Player player) {
        ArrayList<Player> winnersPlayers = new ArrayList<>();
        for (int i = 0; i < getListSelectedPlayers().size(); i++) {
            if (!getListSelectedPlayers().get(i).equals(player)) {
                winnersPlayers.add(getListSelectedPlayers().get(i));
                addNewGameWonToPlayer(getListSelectedPlayers().get(i));
            }
        }
        return winnersPlayers;
    }

    /**
     * *
     * a more won game is added to the player's counter passed by parameter
     *
     * @param player
     */
    public void addNewGameWonToPlayer(Player player) {
        player.setQuantityGamesWon(player.getQuantityGamesWon() + 1);
    }

    /**
     * *
     * get the list of winning players by qunatity of birds placed
     *
     * @return
     */
    public ArrayList<Player> getWinnersPlayers() {
        ArrayList<Player> winnersPlayers = new ArrayList<>();
        int minBirds = Integer.MAX_VALUE;
        for (int i = 0; i < getListSelectedPlayers().size(); i++) {
            if (getListSelectedPlayers().get(i).getQuantityBirdsOnBoard() < minBirds) {
                minBirds = getListSelectedPlayers().get(i).getQuantityBirdsOnBoard();
            }
        }
        for (int i = 0; i < getListSelectedPlayers().size(); i++) {
            if (getListSelectedPlayers().get(i).getQuantityBirdsOnBoard() == minBirds) {
                winnersPlayers.add(getListSelectedPlayers().get(i));
                addNewGameWonToPlayer(getListSelectedPlayers().get(i));
            }
        }
        return winnersPlayers;

    }

    /**
     * *
     * returns the player who has to play the next turn
     *
     * @return
     */
    public Player getThePlayerNextTurn() {
        currentTurn++;
        if (currentTurn > getListSelectedPlayers().size() - 1) {
            currentTurn = 0;
        }
        return getListSelectedPlayers().get(currentTurn);

    }

    /**
     * *
     * the list of colors for the players is interspersed, and one is assigned
     * to each one at random
     */
    public void assignColorToPlayers() {
        Collections.shuffle(this.getListSelectedPlayers());
        for (int i = 0; i < this.getListSelectedPlayers().size(); i++) {
            this.getListSelectedPlayers().get(i).setColor(colors.get(i));
        }
    }

    /**
     * *
     * a more played game is added to the counter of each player
     */
    public void setQuantityGamesPlayedOfPlayers() {
        for (int i = 0; i < this.getListSelectedPlayers().size(); i++) {
            Player player = this.getListSelectedPlayers().get(i);
            player.setQuantityGamesPlayed(player.getQuantityGamesPlayed() + 1);
        }
    }

    /**
     * *
     * it is evaluated if the quantity of players configured for this game was
     * selected
     *
     * @return
     */
    public boolean allConfiguredPlayersAreSelected() {
        return getListSelectedPlayers().size() == getQuantityPlayersConfigured();
    }

    /**
     * *
     * throw an exception if the quantity of players configured does not match
     * the quantity of players selected
     *
     * @throws AllConfiguredPlayersAreNotSelectedException
     */
    public void validateAllConfiguredPlayersAreSelected() throws AllConfiguredPlayersAreNotSelectedException {
        if (!(allConfiguredPlayersAreSelected())) {
            throw new AllConfiguredPlayersAreNotSelectedException(this.getListSelectedPlayers().size()
                    + " players were selected and " + this.getQuantityPlayersConfigured()
                    + " players were configured for the game. Select the players again");
        }
    }

    /**
     * *
     * throw an exception if you already selected the same quantity of players
     * that were configured for the game, this is for when the user wants to
     * enter the window to select players created
     *
     * @throws ThereAreNotPlayersLeftToSelectException
     */
    public void validateAreTherePlayersLeftToSelect() throws ThereAreNotPlayersLeftToSelectException {
        if (getListSelectedPlayers().size() == getQuantityPlayersConfigured()) {
            throw new ThereAreNotPlayersLeftToSelectException();
        }
    }

    /**
     * *
     * the data of the new configuration of the game is passed by parameter and
     * the previous configuration is overwritten. This method is used when the
     * way to finish is "all the birds of a player are placed."
     *
     * @param quantityPlayers
     * @param quantityBirdsPlayer
     * @throws TheDataEnteredIsNotInTheRangeException
     */
    public void defineSpecialSettings(int quantityPlayers, int quantityBirdsPlayer) throws TheDataEnteredIsNotInTheRangeException {
        this.setQuantityPlayersConfigured(quantityPlayers);
        this.setQuantityBirdsPlayerConfigured(quantityBirdsPlayer);
        this.setWayToFinishConfigured(1);
    }

    /**
     * *
     * the data of the new configuration of the game is passed by parameter and
     * the previous configuration is overwritten. This method is used when the
     * way to finish is " a player's turn ends."
     *
     * @param quantityPlayers
     * @param quantityBirdsPlayer
     * @param turnsToFinish
     * @throws TheDataEnteredIsNotInTheRangeException
     */
    public void defineSpecialSettings(int quantityPlayers, int quantityBirdsPlayer, int turnsToFinish) throws TheDataEnteredIsNotInTheRangeException {
        this.setQuantityPlayersConfigured(quantityPlayers);
        this.setQuantityBirdsPlayerConfigured(quantityBirdsPlayer);
        this.setQuantityTurnsToFinishConfigured(turnsToFinish);
        this.setWayToFinishConfigured(2);
    }

    /**
     * *
     * given a list of players another list is returned with the players of that
     * list that have not been selected, this serves to show players to select
     * in the window select player created
     *
     * @param players
     * @return
     */
    public Iterator<Player> removePlayersWereAlreadySelected(ArrayList<Player> players) {
        Iterator<Player> playersToSelect = players.iterator();
        String alias;
        while (playersToSelect.hasNext()) {
            alias = playersToSelect.next().getAlias();
            Player aux = new Player();
            aux.setAlias(alias);
            if (this.getListSelectedPlayers().contains(aux)) {
                playersToSelect.remove();
            }
        }
        return playersToSelect;
    }

    /**
     * *
     * given a list of players another list is returned with the alias players
     * of that list that have not been selected, this serves to show players to
     * select in the window select player created
     *
     * @param players
     * @return
     */
    public ArrayList<String> removePlayersByAliasWereAlreadySelected(ArrayList<String> players) {
        Iterator<String> playersToSelect = players.iterator();
        String alias;
        while (playersToSelect.hasNext()) {
            alias = playersToSelect.next();
            Player aux = new Player();
            aux.setAlias(alias);
            if (this.getListSelectedPlayers().contains(aux)) {
                playersToSelect.remove();
            }
        }
        return (ArrayList<String>) playersToSelect;
    }

    /**
     * *
     * this method adds a player passed by parameter to the list of players
     * selected for this game
     *
     * @param player
     */
    public void addPlayerToSelectedList(Player player) {
        this.getListSelectedPlayers().add(player);
    }

    /**
     * *
     * with the quantity of players in the game, the play counter against the
     * quantity of opponents is updated by each player
     */
    public void increaseQuantityOfOpponentToPlayers() {
        int opponents = this.getListSelectedPlayers().size() - 1;
        for (int i = 0; i < this.getListSelectedPlayers().size(); i++) {
            Player player = this.getListSelectedPlayers().get(i);
            player.getQuantityOpponents()[opponents]++;
        }
    }

    /**
     * *
     * a more played game is added to each player
     */
    public void increaseQuantityGamesPlayedToPlayers() {
        for (int i = 0; i < this.getListSelectedPlayers().size(); i++) {
            Player player = this.getListSelectedPlayers().get(i);
            player.setQuantityGamesPlayed(player.getQuantityGamesPlayed() + 1);
        }
    }

    public int getQuantityPlayersConfigured() {
        return quantityPlayersConfigured;
    }

    public void setQuantityPlayersConfigured(int quantityPlayers) {
        this.quantityPlayersConfigured = quantityPlayers;
    }

    public int getQuantityBirdsPlayerConfigured() {
        return quantityBirdsPlayerConfigured;
    }

    public void setQuantityBirdsPlayerConfigured(int quantityBirdsPlayerConfigured) {
        this.quantityBirdsPlayerConfigured = quantityBirdsPlayerConfigured;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getListSelectedPlayers() {
        return listSelectedPlayers;
    }

    public void setListSelectedPlayers(ArrayList<Player> listPlayers) {
        this.listSelectedPlayers = listPlayers;
    }

    public int getWayToFinishConfigured() {
        return wayToFinishConfigured;
    }

    public void setWayToFinishConfigured(int wayToFinish) {
        this.wayToFinishConfigured = wayToFinish;
    }

    public int getQuantityTurnsToFinishConfigured() {
        return quantityTurnsToFinishConfigured;
    }

    public void setQuantityTurnsToFinishConfigured(int quantityTurnsToFinishConfigured) {
        this.quantityTurnsToFinishConfigured = quantityTurnsToFinishConfigured;
    }

    @Override
    public String toString() {
        return "Game " + "quantityPlayers: " + quantityPlayersConfigured + ", quantityBirdsPlayer: " + quantityBirdsPlayerConfigured + ", board: " + board + ", playersList: " + listSelectedPlayers + ", wayToFinish: " + wayToFinishConfigured + ", maxTurnsToFinish: " + quantityTurnsToFinishConfigured;
    }

}
