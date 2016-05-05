/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameModel.*;
import IModel.*;
import IView.*;
import java.util.Map;

/**
 *
 * @author tranhieu
 */
public abstract class AbstractFabric {
    
    private Map<DishObject,DishObjectView> createdDishObjects;
    
    public abstract DishObject createBactery();
    
    public abstract DishObject createBolid();
    
    public abstract DishObject createPrimitive();
    
    public abstract DishObjectView getDishObjectView(DishObject model);
    
    public abstract CollisionManager createCollisionManager();
    
    public abstract IPlayerController createPlayerController();
    
    public abstract GameView createGameView(GameModel model);
    
    public abstract DishView createDishView();
    
    public abstract GameManager createGameManager();
}
