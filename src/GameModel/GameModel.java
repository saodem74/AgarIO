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
    
    private final int PLAYER_START_SIZE = 40;
    
    private final int PLAYERS_START_COUNT = 20;
    
    private final int PRIMITIVES_START_COUNT = 20;
    
    private Dish dish;
    
    private AbstractFabric fabric;
    
    private ArrayList<Controller> players = new ArrayList<>();
    
    public GameModel(int width, int height, AbstractFabric fabric){
        this.fabric = fabric;
        dish = new Dish(width,height,fabric);
    }
    
    public void startGame(){
        createPlayers();
        dish.createBasicPrimitives(PRIMITIVES_START_COUNT);
    }
    
    private void createPlayers(){
        //create main player
        Bacterium b = dish.createBactery(PLAYER_START_SIZE);
        players.add(fabric.createPlayerController(b));
        fireMainPlayerCreated(b);
        int bactNumber = (int)(Math.random()* PLAYERS_START_COUNT);
        for(int i=0; i<bactNumber; i++){
            createAIPlayer(PLAYER_START_SIZE);
        }
    }
    
    private void createAIPlayer(int size){
        Bacterium b = dish.createBactery(size);
        AIController ai = new AIController(b);
        players.add(ai);
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
