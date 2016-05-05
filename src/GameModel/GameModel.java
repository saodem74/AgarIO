/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        dish.createBactery();
    }
    
    public Dish getDish(){
        return dish;
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
}
