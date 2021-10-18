/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.Comparator;


public class OrderGamesPlayed implements Comparator<Player>{

  

    @Override
    public int compare(Player o1, Player o2) {
        return o2.getQuantityGamesPlayed() - o1.getQuantityGamesPlayed();
    }
    
}
