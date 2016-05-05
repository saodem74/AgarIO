/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import IView.*;
import java.awt.Graphics2D;

/**
 *
 * @author tranhieu
 */
public abstract class GameManager {
    
    protected final int GAME_WIDTH = 800;
    protected final int GAME_HEIGHT = 600;
    
    private GameModel model;
    private GameView view;
    
    public GameManager(AbstractFabric fabric) {
        model = new GameModel(GAME_WIDTH, GAME_HEIGHT,fabric);
        view = fabric.createGameView(model);
        model.startGame();
    }
    
    public void update(long l){
        
    }
    
    public void render(Graphics2D g){
        
    }
}
