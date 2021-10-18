/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

public class Player implements Comparable<Player>, Cloneable {

    private String name;
    private String alias;
    private String color;
    private int age;
    private int quantityRotation;
    private int quantityBirdsOnBoard;
    private int[] quantityOpponents;
    private int playedTurns;
    private int quantityGamesPlayed;

    public Player() {
        super();
    }

    public Player(String name, String alias, int age) {
        this.name = name;
        this.alias = alias;
        this.age = age;
        this.quantityOpponents = new int[4];
        this.playedTurns = 0;
        this.quantityGamesPlayed = 0;
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

    public int getQuantityRotation() {
        return quantityRotation;
    }

    public void setQuantityRotation(int quantityRotation) {
        this.quantityRotation = quantityRotation;
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

    public int compareTo(Player t) {
        return t.getName().compareTo(this.getName());

    }

    @Override
    public String toString() {
        return alias;
    }
}
