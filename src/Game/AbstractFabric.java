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
    
    public abstract Bacterium createBactery(Dish d);
    
    public abstract DishObject createBolid(Dish d);
    
    public abstract DishObject createPrimitive(Dish d);
    
    public DishObjectView getDishObjectView(DishObject model){
        return createdDishObjects.get(model);
    }
    
    public abstract CollisionManager createCollisionManager();
    
    public abstract PlayerController createPlayerController(Bacterium b);
    
    public abstract GameView createGameView(GameModel model);
    
    public abstract DishView createDishView(Dish dish);
    
    public abstract GameManager createGameManager();
}
