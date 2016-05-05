/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;

/**
 *
 * @author tranhieu
 */
public class GameModel {
    
    private Dish dish;
    
    public GameModel(int width, int height, AbstractFabric fabric){
        dish = new Dish(width,height,fabric);
    }
    
    public void startGame(){
        
    }
}
