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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public DishObjectView getDishObjectView(DishObject model) {
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
        return new GameViewGTGE();
    }

    @Override
    public DishView createDishView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameManager createGameManager() {
        return new GameManagerGTGE(this);
    }
    
}
