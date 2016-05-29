/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Game.AbstractFabric;
import GameModel.specializations.EvolutionaryTree;
import GameModel.specializations.Specialization;
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
    
    private final double EMERGENCE_OF_NEW_BACTERY_CHANCE = 0.02;
    
    private final int PLAYER_SIZE_DIFFERENCE = 40;
    
    private final double EMERGENCE_OF_PRIMITIVES_CHANCE = 0.05;
    
    private final int EMERGING_PRIMITIVES_COUNT = 5;
    
    private Dish dish;
    
    private EvolutionaryTree specTree;
    
    private AbstractFabric fabric;
    
    private ArrayList<Controller> players = new ArrayList<>();
    
    private static GameModel instance = null;
    
    public static GameModel getInstance(){
        if (instance == null){
            instance = new GameModel();
        }
        return instance;
    }

    private GameModel() {
        
    }
    
    public EvolutionaryTree getEvolutionaryTree(){
        return this.specTree;
    }
    
    public GameModel(int width, int height, AbstractFabric fabric){
        this.fabric = fabric;
        dish = new Dish(width,height,fabric);
        specTree = new EvolutionaryTree();
        instance = this;
    }
    
    public void startGame(){
        createPlayers();
        dish.createBasicPrimitives(PRIMITIVES_START_COUNT);
    }
    
    private void createPlayers(){
        //create main player
        Bacterium b = dish.createBactery(PLAYER_START_SIZE, specTree.getBaseSpec());
        players.add(fabric.createPlayerController(b));
        fireMainPlayerCreated(b);
        //create other players
        int bactNumber = (int)(Math.random()* PLAYERS_START_COUNT);
        for(int i=0; i<bactNumber; i++){
            createAIPlayer(PLAYER_START_SIZE,specTree.getBaseSpec());
        }
    }
    
    private void createAIPlayer(int size, Specialization spec){
        Bacterium b = dish.createBactery(size,spec);
        AIController ai = new AIController(b);
        players.add(ai);
    }
    
    public void update(long l){
        for(Controller p : players){
            p.update();
        }
        if(Math.random() < EMERGENCE_OF_NEW_BACTERY_CHANCE){
            createAIPlayer(PLAYER_START_SIZE + (int)(Math.random()*PLAYER_SIZE_DIFFERENCE), specTree.getRandomSpec());
        }
        if(Math.random() < EMERGENCE_OF_PRIMITIVES_CHANCE){
            dish.createBasicPrimitives((int) (Math.random()*EMERGING_PRIMITIVES_COUNT));
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
