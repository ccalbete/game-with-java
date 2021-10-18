/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private int quantityPlayers;
    private int quantityBirdsPlayer;
    private int quantityRotationPlayer;
    private int quantityTablets;
    private Board board;
    private Player winner;
    private ArrayList<Player> playersList;
    private int wayToFinish;
    private String[] wayToFinishDescription;
    private int quantityTurnsToFinish;
    private ArrayList<String> colors = new ArrayList<>();
    private int currentTurn;

    public Game() {
        this.quantityPlayers = 2;
        this.quantityBirdsPlayer = 45;
        this.quantityRotationPlayer = 5;
        this.quantityTablets = 25;
        this.playersList = new ArrayList<>();
        this.board = new Board();
        this.wayToFinish = 3;
        this.wayToFinishDescription = new String[4];
        this.wayToFinishDescription[1] = "When the last tablet is placed on the 5*5 board.";
        this.wayToFinishDescription[2] = "When all the birds of a player are placed.";
        this.wayToFinishDescription[3] = "When a player's turn ends.";
        this.quantityTurnsToFinish = 10;
        this.colors.add("Red");
        this.colors.add("Blue");
        this.colors.add("Yellow");
        this.colors.add("Green");
        this.currentTurn = -1;
    }

    public boolean gameOver() {
        boolean over = false;

        if (this.getWayToFinish() == 1) {
            if (getBoard().getQuantityPlacedTablets() == getQuantityTablets()) {
                over = true;
            }
        }
        if (this.getWayToFinish() == 2) {
            for (int i = 0; i < getPlayersList().size(); i++) {
                if (getPlayersList().get(i).getQuantityBirdsOnBoard() == getQuantityBirdsPlayer()) {
                    over = true;
                }
            }
        }
        if (this.getWayToFinish() == 3) {
                if (getPlayersList().get(getPlayersList().size()-1).getPlayedTurns() == getQuantityTurnsToFinish()) {
                    over = true; 
            }
        }
        return over;
    }

    /**
     *
     * @param player: Player that select X for to way finish
     * @return
     */
    public ArrayList<Player> showWinnerX(Player player) {
        ArrayList<Player> winnersPlayers = new ArrayList<>();
        for (int i = 0; i < getPlayersList().size(); i++) {
            if (!getPlayersList().get(i).equals(player)) {
                winnersPlayers.add(getPlayersList().get(i));
            }
        }
        return winnersPlayers;
    }

    public ArrayList<Player> showWinner() {
        ArrayList<Player> winnersPlayers = new ArrayList<>();
        int maxBirds = 0;
        for (int i = 0; i < getPlayersList().size(); i++) {
            if (getPlayersList().get(i).getQuantityBirdsOnBoard() > maxBirds) {
                maxBirds = getPlayersList().get(i).getQuantityBirdsOnBoard();
            }
        }
         for (int i = 0; i < getPlayersList().size(); i++) {
             if(getPlayersList().get(i).getQuantityBirdsOnBoard() == maxBirds){
                 winnersPlayers.add(getPlayersList().get(i));
         }
         }
        return winnersPlayers;

    }

    public Player nextTurn() {
        currentTurn++;
        if (currentTurn > getPlayersList().size() - 1) {
            currentTurn = 0;
        }
        return getPlayersList().get(currentTurn);
    }

    public void assignColorToPlayers() {
        Collections.shuffle(this.getPlayersList());
        int colorPosition = 0;
        for (int i = 0; i < this.getPlayersList().size(); i++) {
            this.getPlayersList().get(i).setColor(colors.get(colorPosition));
            colorPosition++;

        }
    }

    public int getQuantityPlayers() {
        return quantityPlayers;
    }

    public void setQuantityPlayers(int quantityPlayers) {
        this.quantityPlayers = quantityPlayers;
    }

    public int getQuantityBirdsPlayer() {
        return quantityBirdsPlayer;
    }

    public void setQuantityBirdsPlayer(int quantityBirdsPlayer) {
        this.quantityBirdsPlayer = quantityBirdsPlayer;
    }

    public int getQuantityRotationPlayer() {
        return quantityRotationPlayer;
    }

    public void setQuantityRotationPlayer(int quantityRotationPlayer) {
        this.quantityRotationPlayer = quantityRotationPlayer;
    }

    public int getQuantityTablets() {
        return quantityTablets;
    }

    public void setQuantityTablets(int quantityTablets) {
        this.quantityTablets = quantityTablets;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public int getWayToFinish() {
        return wayToFinish;
    }

    public void setWayToFinish(int wayToFinish) {
        this.wayToFinish = wayToFinish;
    }

    public int getQuantityTurnsToFinish() {
        return quantityTurnsToFinish;
    }

    public void setQuantityTurnsToFinish(int quantityTurnsToFinish) {
        this.quantityTurnsToFinish = quantityTurnsToFinish;
    }

    public String[] getWayToFinishDescription() {
        return wayToFinishDescription;
    }

    public void setWayToFinishDescription(String[] wayToFinishDescription) {
        this.wayToFinishDescription = wayToFinishDescription;
    }

    @Override
    public String toString() {
        return "Game " + "quantityPlayers: " + quantityPlayers + ", quantityBirdsPlayer: " + quantityBirdsPlayer + ", quantityRotationPlayer: " + quantityRotationPlayer + ", quantityTablets: " + quantityTablets + ", board: " + board + ", winner: " + winner + ", playersList: " + playersList + ", wayToFinish: " + wayToFinish + ", maxTurnsToFinish: " + quantityTurnsToFinish;
    }

}