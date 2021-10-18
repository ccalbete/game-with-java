/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.ArrayList;

public class Company {

    ArrayList<Player> playersList;
    ArrayList<Game> gamesList;

    public Company() {
        this.playersList = new ArrayList<>();
        this.gamesList = new ArrayList<>();
    }
    
    public boolean existPlayer(String alias){ 
        boolean exist = false;
        if(this.getPlayersList().size()!=0){
     for(int i=0; i< this.getPlayersList().size(); i++){ 
         exist = this.getPlayersList().get(i).getAlias().equals(alias);
     }  }
     return exist;
    }
    
    public Player createPlayer(String name, String alias, int age){
        Player player = new Player(name, alias, age);
        this.getPlayersList().add(player);
        return player;
    }
    
    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public ArrayList<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(ArrayList<Game> gamesList) {
        this.gamesList = gamesList;
    }
    
    
}
