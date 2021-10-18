/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//Cinthya Calbete 229418

public class Player implements Comparable<Player> {

    private String name;
    private String alias;
    private String color;
    private int age;
    private String pathAvatar;
    private int quantityBirdsOnBoard;

    //example in index the quantity of times the player played 
    //against 1 player is saved
    private int[] quantityOpponents;
    private int playedTurns;
    private int quantityGamesPlayed;
    private int quantityGamesWon;

    public Player() {
        super();
    }

    /**
     * *
     * when a player is created, they are given their personal data and their
     * counters are reset to zero
     *
     * @param name
     * @param alias
     * @param age
     * @param pathAvatar
     */
    public Player(String name, String alias, int age, String pathAvatar) {
        this.name = name;
        this.alias = alias;
        this.age = age;
        this.pathAvatar = pathAvatar;
        this.quantityOpponents = new int[4];
        this.playedTurns = 0;
        this.quantityGamesPlayed = 0;
        this.quantityGamesWon = 0;
    }

    public int getQuantityGamesPlayed() {
        return quantityGamesPlayed;
    }

    public void setQuantityGamesPlayed(int quantityGamesPlayed) {
        this.quantityGamesPlayed = quantityGamesPlayed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQuantityBirdsOnBoard() {
        return quantityBirdsOnBoard;
    }

    public void setQuantityBirdsOnBoard(int quantityBirdsOnBoard) {
        this.quantityBirdsOnBoard = quantityBirdsOnBoard;
    }

    public int[] getQuantityOpponents() {
        return quantityOpponents;
    }

    public void setQuantityOpponents(int[] quantityOpponents) {
        this.quantityOpponents = quantityOpponents;
    }

    public int getPlayedTurns() {
        return playedTurns;
    }

    public void setPlayedTurns(int playedTurns) {
        this.playedTurns = playedTurns;
    }

    @Override
    public boolean equals(Object o) {
        Player aux = (Player) o;
        return this.getAlias().equals(aux.getAlias());
    }

    public int compareTo(Player p) {
        return p.getName().compareTo(this.getName());

    }

    public String getPathAvatar() {
        return pathAvatar;
    }

    public void setPathAvatar(String pathAvatar) {
        this.pathAvatar = pathAvatar;
    }

    public int getQuantityGamesWon() {
        return quantityGamesWon;
    }

    public void setQuantityGamesWon(int quantityGamesWon) {
        this.quantityGamesWon = quantityGamesWon;
    }

    @Override
    public String toString() {
        return alias;
    }
}
