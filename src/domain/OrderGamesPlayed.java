/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//Cinthya Calbete 229418
import java.util.Comparator;

public class OrderGamesPlayed implements Comparator<Player> {

    /**
     * *
     * the list of players is sorted in a decreasing way by the quantity of
     * games played
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Player o1, Player o2) {
        return o2.getQuantityGamesPlayed() - o1.getQuantityGamesPlayed();
    }

}
