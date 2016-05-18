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

/**
 *
 * @author tranhieu
 */
public class GTGEFabric extends AbstractFabric {
    
    private Game game;

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
        return new PlayerControllerGTGE(b);
    }

    @Override
    public GameView createGameView(GameModel model, int w, int h) {
        return new GameViewGTGE(model,this,w,h);
    }

    @Override
    public DishView createDishView(Dish dish, int w, int h) {
        return new DishViewGTGE(dish,this,w,h);
    }

    @Override
    public GameManager createGameManager() {
        return new GameManagerGTGE(this);
    }
    
    public Game getGameGTGEObject(){
        return game;
    }
    
}
