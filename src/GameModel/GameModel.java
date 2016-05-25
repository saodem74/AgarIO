/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public class GameModel {
    
    private Dish dish;
    
    private AbstractFabric fabric;
    
    private ArrayList<Controller> players = new ArrayList<>();
    
    public GameModel(int width, int height, AbstractFabric fabric){
        this.fabric = fabric;
        dish = new Dish(width,height,fabric);
    }
    
    public void startGame(){
        Bacterium b = dish.createBactery();
        players.add(fabric.createPlayerController(b));
        fireMainPlayerCreated(b);
        dish.createBactery(new Point(200,200));
    }
    
    public void update(long l){
        for(Controller p : players){
            p.update();
        }
        dish.update(l);
    }
    
    public Dish getDish(){
        return dish;
    }
    
    private ArrayList<ActionListener> listeners = new ArrayList<>();
    
    public void addListener(ActionListener l){
        listeners.add(l);
    }
    
    private void fireMainPlayerCreated(Bacterium b){
        ActionEvent e = new ActionEvent(b,1,"main player created");
        for(ActionListener l : listeners){
            l.actionPerformed(e);
        }
    }
}
