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
 * Класс приложения
 */
public abstract class Application {
    
    protected final int SCREEN_WIDTH = 800;
    protected final int SCREEN_HEIGHT = 600;
    
    private GameModel model;
    private GameView view;
    
    public Application(AbstractFabric fabric) {
        model = new GameModel(fabric);
        view = fabric.createGameView(model,SCREEN_WIDTH,SCREEN_HEIGHT);
        model.startGame();
    }
    
    public void update(long l){
        model.update(l);
    }
    
    public void render(Graphics2D g){
        view.render(g);
    }
}
