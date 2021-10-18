/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//Cinthya Calbete 229418
import exceptions.PlayerAlreadyExistException;
import exceptions.ThereAreNotPlayersCreatedException;
import java.util.ArrayList;

public class Company {

    private ArrayList<Player> listCreatedPlayers;
    private Game game;
    private Helper helper;

    /**
     * *
     * When the company is created, a game and a list of players are created
     */
    public Company() {
        this.game = new Game();
        this.listCreatedPlayers = new ArrayList<>();
        this.helper = new Helper();
    }

    /**
     * *
     * given an alias, it is evaluated if there is a player created that has the
     * same alias
     *
     * @param alias
     * @throws PlayerAlreadyExistException
     */
    public void validateExistPlayer(String alias) throws PlayerAlreadyExistException {
        for (int i = 0; i < this.getListCreatedPlayers().size(); i++) {
            if (this.getListCreatedPlayers().get(i).getAlias().equals(alias)) {
                throw new PlayerAlreadyExistException();
            }
        }
    }

    /**
     * *
     * it is evaluated if there is at least 1 player created, in case there is
     * none, error message is displayed
     *
     * @throws ThereAreNotPlayersCreatedException
     */
    public void validateThereArePlayersCreated() throws ThereAreNotPlayersCreatedException {
        if (this.getListCreatedPlayers().isEmpty()) {
            throw new ThereAreNotPlayersCreatedException();
        }
    }

    /**
     * *
     * given the name of a player is evaluated if this is in the system. Until
     * one letter of difference (added, changed or omitted) is considered the
     * same name
     *
     * @param namePlayer
     * @return if found the same player in system
     */
    public boolean playerIsInSystem(String namePlayer) {
        boolean is = true;
        if (this.getListCreatedPlayers().isEmpty()) {
            is = false;
        }
        String nameInFile = namePlayer.toLowerCase();
        int quantityTimesNotContains = 0;
        int until = 0;
        boolean lengthNameInFileIsMoreLonger = false;
        boolean lengthNameInSystemIsMoreLonger = false;
        for (int i = 0; i < this.getListCreatedPlayers().size(); i++) {
            String nameInSystem = this.getListCreatedPlayers().get(i).getName().toLowerCase();
            if (nameInFile.length() == nameInSystem.length() - 1) {
                until = nameInSystem.length();
                lengthNameInSystemIsMoreLonger = true;
            } else {
                if (nameInFile.length() == nameInSystem.length() + 1) {
                    until = nameInFile.length();
                    lengthNameInFileIsMoreLonger = true;
                } else {
                    is = false;
                }
            }

            for (int j = 0; j < until && is; j++) {
                if ((lengthNameInFileIsMoreLonger || lengthNameInSystemIsMoreLonger)) {
                    if (j != until - 1) {
                        if (!(nameInFile.charAt(j) == (nameInSystem.charAt(j)))) {
                            quantityTimesNotContains++;
                            for (int k = j; k < until; k++) {
                                if (lengthNameInFileIsMoreLonger && k != until - 1) {
                                    if ((nameInFile.charAt(k + 1) == (nameInSystem.charAt(k)))) {
                                        is = true;
                                    } else {
                                        is = false;
                                    }
                                }
                                if (lengthNameInSystemIsMoreLonger && k != until - 1) {
                                    if ((nameInFile.charAt(k) == (nameInSystem.charAt(k + 1)))) {
                                        is = true;
                                    } else {
                                        is = false;
                                    }
                                }
                            }
                        }

                        if (quantityTimesNotContains > 1) {
                            is = false;
                        }
                    }
                } else {
                    is = false;
                }
            }

        }
        return is;
    }

    /**
     * *
     * Given the data of a player, a new instance is created and that player is
     * saved * in the list of players created by the company
     *
     * @param name
     * @param alias
     * @param age
     * @param pathAvatar
     * @return the player created
     */
    public Player createPlayer(String name, String alias, int age, String pathAvatar) {
        Player player = new Player(name, alias, age, pathAvatar);
        this.getListCreatedPlayers().add(player);
        return player;
    }

    public ArrayList<Player> getListCreatedPlayers() {
        return listCreatedPlayers;
    }

    public void setListCreatedPlayers(ArrayList<Player> listCreatedPlayers) {
        this.listCreatedPlayers = listCreatedPlayers;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
