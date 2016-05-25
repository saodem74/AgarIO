/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEGame;

import GTGEModel.*;
import GTGEView.*;
import Game.*;
import GameModel.*;
import IModel.*;
import IView.*;
import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;

/**
 *
 * @author tranhieu
 */
public class GTGEFabric extends AbstractFabric {
    
    private Game game;
    private DishViewGTGE dishView;
    private PlayerControllerGTGE controller;

    @Override
    public Bacterium createBactery(Dish d) {
        //create model object
        DishObjectSpriteGTGE sprite = new DishObjectSpriteGTGE();
        Bacterium b = new Bacterium(d,sprite);
        sprite.setDishObject(b);
        //create view object
        IDishObjectViewRealization viewR = new DishObjectViewRealizationGTGE(sprite);
        DishObjectView view = new BacteryView(viewR,b.getSize());
        b.addListener(view);
        createdDishObjects.put(b, view);
        return b;
    }

    @Override
    public DishObject createBolid(Dish d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DishObject createPrimitive(Dish d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CollisionManager createCollisionManager() {
        return new CollisionManagerGTGE();
    }

    @Override
    public PlayerController createPlayerController(Bacterium b) {
        controller = new PlayerControllerGTGE(b,this);
        controller.setBackground(dishView.getBackground());
        return controller;
    }

    @Override
    public GameView createGameView(GameModel model, int w, int h) {
        return new GameViewGTGE(model,this,w,h);
    }

    @Override
    public DishView createDishView(Dish dish, int w, int h) {
        dishView = new DishViewGTGE(dish,this,w,h);
        return dishView;
    }

    @Override
    public GameManager createGameManager() {
        GameManagerGTGE gm = new GameManagerGTGE(this);
        return gm;
    }
    
    public Game getGameGTGEObject(){
        return game;
    }
    
    public void setGameGTGEObject(Game g){
        game = g;
        if(controller != null){
            controller.setGame(g);
        }
    }
    
    public Background getBackground(){
        return dishView.getBackground();
    }
    
}
