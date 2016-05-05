/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import IModel.*;
import IView.*;
import java.util.HashMap;

/**
 *
 * @author tranhieu
 */
public abstract class AbstractFabric {
    
    protected HashMap<DishObject,DishObjectView> createdDishObjects = new HashMap<>();
    
    public abstract DishObject createBactery();
    
    public abstract DishObject createBolid();
    
    public abstract DishObject createPrimitive();
    
    public DishObjectView getDishObjectView(DishObject model){
        return createdDishObjects.get(model);
    }
    
    public abstract CollisionManager createCollisionManager();
    
    public abstract IPlayerController createPlayerController();
    
    public abstract GameView createGameView(GameModel model);
    
    public abstract DishView createDishView();
    
    public abstract GameManager createGameManager();
}
