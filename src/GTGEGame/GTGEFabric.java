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

/**
 *
 * @author tranhieu
 */
public class GTGEFabric extends AbstractFabric {

    @Override
    public DishObject createBactery() {
        //create model object
        DishObjectSpriteGTGE sprite = new DishObjectSpriteGTGE();
        Bacterium b = new Bacterium(sprite);
        sprite.setDishObject(b);
        //create view object
        IDishObjectViewRealization viewR = new DishObjectViewRealizationGTGE(sprite);
        DishObjectView view = new BacteryView(viewR);
        b.addListener(view);
        createdDishObjects.put(b, view);
        return b;
    }

    @Override
    public DishObject createBolid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DishObject createPrimitive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CollisionManager createCollisionManager() {
        return new CollisionManagerGTGE();
    }

    @Override
    public IPlayerController createPlayerController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameView createGameView(GameModel model) {
        return new GameViewGTGE(model,this);
    }

    @Override
    public DishView createDishView() {
        return new DishViewGTGE(this);
    }

    @Override
    public GameManager createGameManager() {
        return new GameManagerGTGE(this);
    }
    
}
